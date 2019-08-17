package com.demo.project.pages.wizards.employee;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.pages.generic.elements.GenericSelectList;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

public class JobStage {
    private final ElementUtils jobStageUtils = new ElementUtils();
    private final By effectiveFormDateInputPath = Selectors.byId("add_employee_effective_date");
    private final GenericSelectList employeeRegionSelect = new GenericSelectList("9_inputfileddiv", "9");
    private final GenericSelectList employeeFteSelect = new GenericSelectList("10_inputfileddiv", "10");
    private final GenericSelectList employeeTempDepartmentSelect = new GenericSelectList("11_inputfileddiv", "11");


    public JobStage provideNewEmployeeEffectiveDate(String givenDate) {
        jobStageUtils.commenceAction()
                .fillField(findEffectiveFormDateInput(), givenDate);
        return this;
    }

    public JobStage selectNewEmployeeRegion(String givenRegion) {
        employeeRegionSelect.openSelectContainer()
                .chooseOption(givenRegion)
                .checkIfOptionGotSelected(givenRegion);
        return this;
    }

    public JobStage selectNewEmployeeFte(String givenFte) {
        employeeFteSelect.openSelectContainer()
                .chooseOption(givenFte)
                .checkIfOptionGotSelected(givenFte);
        return this;
    }

    public void selectNewEmployeeTempDepartment(String givenTempDepartment) {
        employeeTempDepartmentSelect.openSelectContainer()
                .chooseOption(givenTempDepartment)
                .checkIfOptionGotSelected(givenTempDepartment);
    }


    private SelenideElement findEffectiveFormDateInput() {
        return jobStageUtils.finder().findInteractableElement.apply(effectiveFormDateInputPath);
    }

}
