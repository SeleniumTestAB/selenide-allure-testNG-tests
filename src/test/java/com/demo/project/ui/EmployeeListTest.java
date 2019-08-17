package com.demo.project.ui;

import com.demo.project.pages.EmployeesListViewPage;
import org.testng.annotations.Test;

public class EmployeeListTest extends TestBase {
    private EmployeesListViewPage employeesListViewPage;

    @Test
    public void goToEmployeeListPageTest() {
     employeesListViewPage = dashboardPage().sidePageNavigation()
                .expandPimMenu()
                .enterEmployeesListView();
    }
    @Test
    public void addNewEmployeeTest() {
        System.out.println(employeesListViewPage);
    }

}
