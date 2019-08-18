package com.demo.project.modals;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.pages.AddNewEmployeePage;
import com.demo.project.pages.generic.elements.GenericDropdownList;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

public class AddEmployeeModal {

    private final By modalFormBodyPath = Selectors.byXpath("//form[@id='pimAddEmployeeForm']");
    private final ElementUtils addEmployeeModalUtils = new ElementUtils();
    private final By firstNameInputPath = Selectors.byId("firstName");
    private final By middleNameInputPath = Selectors.byId("middleName");
    private final By lastNameInputPath = Selectors.byId("lastName");
    private final GenericDropdownList employeeLocationList = new GenericDropdownList("location_inputfileddiv");
    private final By nextButtonPath = Selectors.byId("systemUserSaveBtn");


    public AddEmployeeModal waitForModalToAppear() {
        addEmployeeModalUtils.commenceAction().waitUntilElementAppears(modalFormBodyPath);
        return this;
    }

    public AddEmployeeModal fillEmployeeFirstName(String givenFirstName) {
        addEmployeeModalUtils.commenceAction().fillField(findEmployeeFirstNameInput(), givenFirstName);
        return this;
    }

    public AddEmployeeModal fillEmployeeMiddleName(String givenMiddleName) {
        addEmployeeModalUtils.commenceAction().fillField(findEmployeeMiddleNameInput(), givenMiddleName);
        return this;
    }

    public AddEmployeeModal fillEmployeeLastName(String givenLastName) {
        addEmployeeModalUtils.commenceAction().fillField(findEmployeeLastNameInput(), givenLastName);
        return this;
    }

    public AddEmployeeModal chooseEmployeeLocation(String givenLocation) {
        employeeLocationList.expandDropdownList()
                .chooseOption(givenLocation)
                .checkIfOptionGotSelected(givenLocation);
        return this;
    }

    public AddNewEmployeePage proceedToAddNewEmployeeWizardPage() {
        addEmployeeModalUtils.commenceAction()
                .clickOnClickableElement(findNextButton());
        addEmployeeModalUtils.commenceAction().waitUntilPageLoadsContent();
        return new AddNewEmployeePage();
    }

    private SelenideElement findNextButton() {
        return addEmployeeModalUtils.finder().findInteractableElement.apply(nextButtonPath);
    }

    private SelenideElement findEmployeeFirstNameInput() {
        return addEmployeeModalUtils.finder().findInteractableElement.apply(firstNameInputPath);
    }

    private SelenideElement findEmployeeMiddleNameInput() {
        return addEmployeeModalUtils.finder().findInteractableElement.apply(middleNameInputPath);
    }

    private SelenideElement findEmployeeLastNameInput() {
        return addEmployeeModalUtils.finder().findInteractableElement.apply(lastNameInputPath);
    }


}
