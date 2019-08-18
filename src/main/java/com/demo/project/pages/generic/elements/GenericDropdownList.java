package com.demo.project.pages.generic.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericDropdownList {
    private final String dropdownId;
    private final ElementUtils selectListUtils = new ElementUtils();

    public GenericDropdownList(String dropdownId) {
        this.dropdownId = dropdownId;

    }


    public GenericDropdownList expandDropdownList() {
        selectListUtils.commenceAction().clickOnClickableElement(findDropdown());
        return this;
    }

    public GenericDropdownList chooseOption(String givenOption) {
       selectListUtils.commenceAction()
               .clickOnClickableElement(findGivenOption(givenOption));
        return this;
    }

    public void checkIfOptionGotSelected(String givenOption) {
       String value  = findDropdown().find(Selectors.byXpath("./descendant::input")).val();
       assertThat(value).contains(givenOption);
    }


    private SelenideElement findDropdown() {
        return selectListUtils.finder().findReadableElement.apply(Selectors.byId(dropdownId));
    }

    private SelenideElement findGivenOption(String givenOption) {
        return selectListUtils.finder()
                .findNestedExistingElement.apply(findDropdown(), Selectors.byXpath("./descendant::li/child::span[contains(text(),'" + givenOption + "')]"));
    }


}
