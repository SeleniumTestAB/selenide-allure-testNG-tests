package com.demo.project.listeners;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.*;

public class DemoProjectListener implements ISuiteListener, IInvokedMethodListener2 {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

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
}
