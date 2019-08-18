package com.demo.project.listeners;

import com.codeborne.selenide.Configuration;
import com.demo.project.documentation.DocumentedTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.testng.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoProjectListener implements ISuiteListener, IInvokedMethodListener2 {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
       if(method.isTestMethod()) {
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

    @Override
    public void onStart(ISuite suite) {
        WebDriverManager.firefoxdriver().setup();
        Configuration.browser = "firefox";
        Configuration.browserBinary = System.getenv("FIREFOX_BINARY");
        Configuration.timeout = 15000;
    }

    @Override
    public void onFinish(ISuite suite) {

    }

    private void assignDocumentationToTest(IInvokedMethod method) {
        if(!checkIfDocumentationAnnotationIsPresent(method)) {
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
                            testResult.setDescriptionHtml((String)documentation.invoke(annotatedTest.fromClass().newInstance()));
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

    private Method getDocumentationMethodFromAnnotation (DocumentedTest annotation) {
        try{
            return annotation.fromClass().getDeclaredMethod(annotation.byMethod(), null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

}
