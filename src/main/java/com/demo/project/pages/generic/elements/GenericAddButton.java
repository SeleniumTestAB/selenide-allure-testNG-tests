package com.demo.project.pages.generic.elements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.page;


public class GenericAddButton {
    private final String addButtonTooltip;
    private final ElementUtils addButtonUtils = new ElementUtils();

    public GenericAddButton(String addButtonTooltip) {
        this.addButtonTooltip = addButtonTooltip;
    }

    private By makeAddButtonPath() {
        return Selectors.byXpath("//div[contains(@class,'fixed-action-btn') and @data-tooltip='" + addButtonTooltip + "']");
    }

    private SelenideElement findAddButton() {
        return addButtonUtils.finder().findInteractableElement.apply(makeAddButtonPath());
    }

    public <PageObjectClass, T extends PageObjectClass>  PageObjectClass addItem(T pageObjectClass) {
        addButtonUtils.commenceAction().clickOnClickableElement(findAddButton());
        return page(pageObjectClass);
    }

}
