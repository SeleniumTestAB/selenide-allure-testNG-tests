package com.demo.project.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeDetailsPage {
    private final ElementUtils employeeDetailsUtils = new ElementUtils();
    private final By employeeNameOnNavBarPath = Selectors.byXpath("//span[@id='pim.navbar.employeeName']");


    public void checkIfEmployeeGotCreated(String firstName, String lastName) {
        assertThat(getNameFromNavBar()).contains(firstName, lastName);
    }

    private SelenideElement findEmployeeNameOnNavBar() {
        return employeeDetailsUtils.finder().findReadableElement.apply(employeeNameOnNavBarPath);
    }

    private String getNameFromNavBar() {
       return findEmployeeNameOnNavBar().text();
    }

}
