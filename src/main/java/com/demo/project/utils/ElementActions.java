package com.demo.project.utils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.value;

public class ElementActions extends Expectations {
    public void fillField(SelenideElement field, String givenValue) {
        field.append(givenValue)
                .shouldNotBe(empty)
                .shouldHave(value(givenValue));
    }

    public void clickOnClickableElement(SelenideElement element) {
        element.shouldBe(active).click();
    }

}
