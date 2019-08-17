package com.demo.project.pages.generic.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;

public class GenericSelectList {
    private final String containerId;
    private final String selectId;
    private final ElementUtils selectListUtils = new ElementUtils();

    public GenericSelectList(String containerId, String selectId) {
        this.containerId = containerId;
        this.selectId = selectId;
    }

    private SelenideElement findContainer() {
        return selectListUtils.finder().findReadableElement.apply(Selectors.byId(containerId));
    }

    private SelenideElement findNestedSelect() {
        return selectListUtils.finder().findNestedInteractableElement.apply(findContainer(), Selectors.byXpath("./select[@id='" + selectId + "']"));
    }

    public GenericSelectList openSelectContainer() {
        selectListUtils.commenceAction().clickOnClickableElement(findContainer());
        return this;
    }

    public GenericSelectList chooseOption(String givenOption) {
        findNestedSelect().selectOption(givenOption);
        return this;
    }

    public void checkIfOptionGotSelected(String givenOption) {
       selectListUtils.finder().findNestedReadableElement.apply(findContainer(), Selectors.byXpath("./descendant::input")).shouldHave(Condition.value(givenOption));
    }

}
