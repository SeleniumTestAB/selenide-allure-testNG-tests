package com.demo.project.pages.navigation;


import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class NavCollapsibleSection {
    private ElementUtils collapsibleSectionUtils = new ElementUtils();
    private final String sectionId;
    private final By toggleStatusPath = Selectors.byXpath("./child::a");
    private final By toggleButtonPath = Selectors.byXpath("./child::a[@class='collapsible-header waves-effect waves-orange']");


    public NavCollapsibleSection(String sectionId) {
        this.sectionId = sectionId;
    }

    private SelenideElement findSection() {
        return collapsibleSectionUtils.finder()
                .findReadableElement.apply(Selectors.byId(sectionId));
    }

    private SelenideElement findSectionToggleButton() {
        return collapsibleSectionUtils.finder()
                .findNestedInteractableElement.apply(findSection(), toggleButtonPath);
    }

    private SelenideElement findToggleStatus() {
        return collapsibleSectionUtils.finder()
                .findNestedExistingElement.apply(findSection(), toggleStatusPath);
    }

    private boolean isCollapsed() {
        return findToggleStatus().attr("class").contains("active");
    }

    public void expand() {

        collapsibleSectionUtils.commenceAction()
                .waitUntilElementAppears(findSectionToggleButton());
       collapsibleSectionUtils.commenceAction()
               .waitUntilElementBecomesActive(findSectionToggleButton());
        collapsibleSectionUtils.commenceAction()
                .clickOnClickableElement(findSectionToggleButton());
        assertThat(isCollapsed()).isTrue();
    }

    public void collapse() {
        collapsibleSectionUtils.commenceAction()
                .clickOnClickableElement(findSectionToggleButton());
        assertThat(isCollapsed()).isFalse();
    }

}
