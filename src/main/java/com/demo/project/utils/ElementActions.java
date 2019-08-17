package com.demo.project.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ElementActions extends Expectations {
    public void fillField(SelenideElement field, String givenValue) {
        field.append(givenValue)
                .shouldNotBe(empty)
                .shouldHave(value(givenValue));
    }

    public void clickOnClickableElement(SelenideElement element) {
        element.shouldBe(active).click();
    }

    public void waitUntilPageLoadsContent() {
        $x("//div[@id='preloader']").waitUntil(appear.because("There is a small delay for loader to appear"), 2000)
                .waitUntil(disappear, 10000);
    }

    public void waitUntilElementAppears(By pathToElement) {
        $(pathToElement).waitUntil(appears, 8000);
    }

}
