package com.demo.project.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.config.PropertyFileReader;
import com.demo.project.utils.ElementUtils;
import lombok.Getter;
import org.openqa.selenium.By;

public class LoginPage {
    @Getter
    private final String loginPageUrl = PropertyFileReader.getProperty("setup.properties", "siteUrl");
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
        loginUtils.commenceAction().clearField(findLoginInputField());
        loginUtils.commenceAction().fillField(findLoginInputField(), givenLogin);
        return this;
    }

    public LoginPage fillPasswordField(String givenPassword) {
        loginUtils.commenceAction().clearField(findPasswordInputField());
        loginUtils.commenceAction().fillField(findPasswordInputField(), givenPassword);
        return this;
    }

    public DashboardPage login() {
        findLoginForm().submit();
        loginUtils.commenceAction().waitUntilPageLoads();
        return new DashboardPage();
    }

}
