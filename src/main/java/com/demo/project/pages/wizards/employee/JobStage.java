package com.demo.project.pages.wizards.employee;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.pages.generic.elements.GenericDropdownList;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

public class JobStage {
    private final ElementUtils jobStageUtils = new ElementUtils();
    private final By effectiveFormDateInputPath = Selectors.byId("add_employee_effective_date");
    private final GenericDropdownList employeeRegionSelect = new GenericDropdownList("9_inputfileddiv");
    private final GenericDropdownList employeeFteSelect = new GenericDropdownList("10_inputfileddiv");
    private final GenericDropdownList employeeTempDepartmentSelect = new GenericDropdownList("11_inputfileddiv");


    public JobStage provideNewEmployeeEffectiveDate(String givenDate) {
        jobStageUtils.commenceAction()
                .clearField(findEffectiveFormDateInput());
        jobStageUtils.commenceAction()
                .fillField(findEffectiveFormDateInput(), givenDate);
        return this;
    }

    public JobStage selectNewEmployeeRegion(String givenRegion) {
        employeeRegionSelect.expandDropdownList()
                .chooseOption(givenRegion)
                .checkIfOptionGotSelected(givenRegion);
        return this;
    }

    public JobStage selectNewEmployeeFte(String givenFte) {
        employeeFteSelect.expandDropdownList()
                .chooseOption(givenFte)
                .checkIfOptionGotSelected(givenFte);
        return this;
    }

    public void selectNewEmployeeTempDepartment(String givenTempDepartment) {
        employeeTempDepartmentSelect.expandDropdownList()
                .chooseOption(givenTempDepartment)
                .checkIfOptionGotSelected(givenTempDepartment);
    }


    private SelenideElement findEffectiveFormDateInput() {
        return jobStageUtils.finder().findInteractableElement.apply(effectiveFormDateInputPath);
    }

}
