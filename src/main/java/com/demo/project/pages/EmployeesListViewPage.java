package com.demo.project.pages;

import com.demo.project.modals.AddEmployeeModal;
import com.demo.project.pages.generic.elements.GenericAddButton;
import com.demo.project.utils.ElementUtils;
import com.demo.project.utils.tables.WebTableHandler;

public class EmployeesListViewPage {
    private final WebTableHandler employeesTableHandler = new WebTableHandler();
    private final GenericAddButton addEmployeeButton = new GenericAddButton("Add Employee");
    private final ElementUtils employeesListUtils = new ElementUtils();


    public AddEmployeeModal clickOnAddNewEmployeeButton() {
        return addEmployeeButton.addItem(new AddEmployeeModal());
    }
}
