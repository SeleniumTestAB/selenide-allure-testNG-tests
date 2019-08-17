package com.demo.project.pages.navigation;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.page;

public class WizardNavigation {
    private final ElementUtils wizardNavigationUtils = new ElementUtils();
    private final By wizardNavigationSectionPath = Selectors.byId("wizard-nav-button-section");
    private final By nextStageButtonPath = Selectors.byXpath("./button[@translate='Next' or contains(@ng-click,'vm.onNextStep()')]");
    private final By saveButtonPath = Selectors.byXpath("./button[@translate='Save' or contains(@ng-click,'vm.onFinish()')]");


    public <PageObjectClass, T extends PageObjectClass> PageObjectClass goToNextStage(PageObjectClass stage) {
        wizardNavigationUtils.commenceAction()
                .clickOnClickableElement(findNextStageButton());
        wizardNavigationUtils.commenceAction().waitUntilPageLoadsContent();
        return page(stage);
    }

    public <PageObjectClass, T extends PageObjectClass> PageObjectClass saveAndFinishWizard(PageObjectClass stage) {
        wizardNavigationUtils.commenceAction()
                .clickOnClickableElement(findSaveButton());
        wizardNavigationUtils.commenceAction().waitUntilPageLoadsContent();
        return page(stage);
    }

    private SelenideElement findNextStageButton() {
        return wizardNavigationUtils.finder().findNestedInteractableElement.apply(findWizardNavigationSection(), nextStageButtonPath);
    }

    private SelenideElement findSaveButton() {
        return wizardNavigationUtils.finder().findNestedInteractableElement.apply(findWizardNavigationSection(), saveButtonPath);
    }

    private SelenideElement findWizardNavigationSection() {
        return wizardNavigationUtils.finder().findExistingElement.apply(wizardNavigationSectionPath);
    }

}
