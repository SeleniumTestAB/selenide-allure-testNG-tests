package com.demo.project.ui;

import com.demo.project.documentation.DocumentedTest;
import com.demo.project.documentation.EmployeeDocumentation;
import com.demo.project.pages.AddNewEmployeePage;
import com.demo.project.pages.EmployeesListViewPage;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class EmployeeListTest extends TestBase {
    private EmployeesListViewPage employeesListViewPage;
    private AddNewEmployeePage addNewEmployeePage;

    @Test
    @DocumentedTest(byMethod = "addNewEmployeeDocumentation", fromClass = EmployeeDocumentation.class)
    public void goToEmployeeListPageTest() {
     employeesListViewPage = dashboardPage().sidePageNavigation()
                .expandPimMenu()
                .enterEmployeesListView();
    }
    @Test
    @Issue("AL-2")
    @TmsLink("AL-1")
    public void startAddNewEmployeeWizardTest() {
        addNewEmployeePage = employeesListViewPage.clickOnAddNewEmployeeButton()
               .waitForModalToAppear()
               .fillEmployeeFirstName("Mark")
               .fillEmployeeMiddleName("Middle")
               .fillEmployeeLastName("Test")
               .chooseEmployeeLocation("British Development Center")
               .proceedToAddNewEmployeeWizardPage();

    }
    @Test
    @DocumentedTest(byMethod = "addNewEmployeeDocumentation", fromClass = EmployeeDocumentation.class)
    public void newEmployeeWizardPersonalDetailsStageTest() {
        addNewEmployeePage.personalDetailsStage()
                .selectBloodGroup("A")
                .fillHobbiesInput("testing");

    }

    @Test
    public void newEmployeeWizardJobStageTest() {
        addNewEmployeePage.goToJobStage()
                .provideNewEmployeeEffectiveDate("2019-10-08")
                .selectNewEmployeeRegion("Region-1")
                .selectNewEmployeeFte("0.5")
                .selectNewEmployeeTempDepartment("Sub unit-1");
    }

    @Test
    @DocumentedTest(byMethod = "addNewEmployeeDocumentation", fromClass = EmployeeDocumentation.class)
    public void finishNewEmployeeWizardTest() {
        addNewEmployeePage.finishNewEmployeeWizard()
                .checkIfEmployeeGotCreated("Mark", "Test");
    }


}
