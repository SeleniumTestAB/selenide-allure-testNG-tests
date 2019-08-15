package com.demo.project.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

public class LoginPage {
    private final String loginPageUrl = "https://orangehrm-demo-6x.orangehrmlive.com/auth/login";
    private final By loginInputFieldPath = Selectors.byId("txtUsername");
    private final By passwordInputFieldPath = Selectors.byId("txtPassword");
    private final By loginFormPath = Selectors.byId("frmLogin");
    private final ElementUtils loginUtils = new ElementUtils();

    private SelenideElement findLoginInputField() {
        return loginUtils.finder().findInteractableElement.apply(loginInputFieldPath);
    }

    private SelenideElement findPasswordInputField() {
        return loginUtils.finder().findInteractableElement.apply(passwordInputFieldPath);
    }

    private SelenideElement findLoginForm() {
        return loginUtils.finder().findExistingElement.apply(loginFormPath);
    }

    public LoginPage fillLoginField(String givenLogin) {
        loginUtils.commenceAction().fillField(findLoginInputField(), givenLogin);
        return this;
    }

    public LoginPage fillPasswordField(String givenPassword) {
        loginUtils.commenceAction().fillField(findPasswordInputField(), givenPassword);
        return this;
    }

    public DashboardPage login() {
        findLoginForm().submit();
        return new DashboardPage();
    }

}
