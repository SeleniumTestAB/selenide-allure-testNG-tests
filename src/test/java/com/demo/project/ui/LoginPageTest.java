package com.demo.project.ui;

import com.demo.project.config.PropertyFileReader;
import com.demo.project.documentation.DocumentedTest;
import com.demo.project.documentation.LoginDocumentation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest extends TestBase{

    private String adminLogin, adminPassword;

    @BeforeClass
    public void getLoginAndPassword() {
        adminLogin = PropertyFileReader.getProperty("setup.properties", "adminLogin");
        adminPassword = PropertyFileReader.getProperty("setup.properties", "adminPassword");
    }

    @Test
    @DocumentedTest(byMethod = "loginAsAdminDocumentation", fromClass = LoginDocumentation.class)
    public void loginAsBusinessAdminPositiveTest() {
        open(loginPage().getLoginPageUrl());
        loginPage().fillLoginField(adminLogin)
                .fillPasswordField(adminPassword)
                .login();
    }



}
