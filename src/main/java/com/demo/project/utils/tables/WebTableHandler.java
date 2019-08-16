package com.demo.project.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class WebTableHandler {
    private final ElementUtils tableUtils = new ElementUtils();

    private List<SelenideElement> retrieveListOfTableHeadersFromPage() {
        return tableUtils.finder().findExistingElements.apply(Selectors.byXpath("//thead/descendant::th"));
    }

    public int getNumberOfTableHeaders() {
        return retrieveListOfTableHeadersFromPage().size();
    }

    public int findIndexOfAHeaderColumn(String givenHeader) {
        int foundHeaderIndex = 0;
        for (int headerIndex = 0; headerIndex < getNumberOfTableHeaders(); headerIndex++) {
            if (retrieveListOfTableHeadersFromPage().get(headerIndex).has(Condition.text(givenHeader))) {
                foundHeaderIndex = headerIndex;
            }
        }
        return foundHeaderIndex;
    }



}
