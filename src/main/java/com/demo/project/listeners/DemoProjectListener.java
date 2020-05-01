package com.demo.project.listeners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demo.project.documentation.DocumentedTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class DemoProjectListener implements ISuiteListener, IInvokedMethodListener2 {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (method.isTestMethod()) {
            assignDocumentationToTest(method);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    private DesiredCapabilities firefoxCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        cap.setVersion("74.0");
        cap.setCapability("enableVNC", true);
        cap.setCapability("enableVideo", false);
        return cap;
    }

    @Override
    public void onStart(ISuite suite) {
        Configuration.browser = System.getProperty("selenide.browser", "firefox");
        Configuration.remote = System.getenv("ZALENIUM_HUB");

        Map.of("firefox", WebDriverManager.firefoxdriver(),
                "chrome", WebDriverManager.chromedriver(),
                "edge", WebDriverManager.edgedriver(),
                "phantomjs", WebDriverManager.phantomjs())
                .get(Configuration.browser)
                .setup();

        Configuration.browserCapabilities = Map.of("firefox", firefoxCapabilities())
                .get(Configuration.browser);
        Configuration.timeout = 15000;
        SelenideLogger.addListener("Allure", new AllureSelenide().screenshots(true).savePageSource(false).includeSelenideSteps(false));

    }

    @Override
    public void onFinish(ISuite suite) {

    }

    private void assignDocumentationToTest(IInvokedMethod method) {
        if (!checkIfDocumentationAnnotationIsPresent(method)) {
            return;
        }

        DocumentedTest annotatedTest = getDocumentedTestAnnotation(method);
        Method documentation = getDocumentationMethodFromAnnotation(annotatedTest);
        if (documentation != null && documentation.getReturnType().equals(String.class)) {
            documentation.setAccessible(true);
            Allure.getLifecycle().updateTestCase(
                    Allure.getLifecycle().getCurrentTestCase().get(),
                    testResult -> {
                        try {
                            testResult.setDescriptionHtml((String) documentation.invoke(annotatedTest.fromClass().newInstance()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
    }


    private boolean checkIfDocumentationAnnotationIsPresent(IInvokedMethod method) {
        return method.getTestMethod()
                .getConstructorOrMethod()
                .getMethod()
                .isAnnotationPresent(DocumentedTest.class);
    }

    private DocumentedTest getDocumentedTestAnnotation(IInvokedMethod method) {
        return method.getTestMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(DocumentedTest.class);
    }

    private Method getDocumentationMethodFromAnnotation(DocumentedTest annotation) {
        try {
            return annotation.fromClass().getDeclaredMethod(annotation.byMethod(), null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

}
