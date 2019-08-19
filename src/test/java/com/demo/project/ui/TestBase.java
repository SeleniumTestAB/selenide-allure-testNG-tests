package com.demo.project.ui;

import com.demo.project.pages.DashboardPage;
import com.demo.project.pages.LoginPage;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

@Accessors(fluent = true)
@Getter
public abstract class TestBase {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @BeforeSuite
    public void initializeBrowser() {
        open();
    }

}
