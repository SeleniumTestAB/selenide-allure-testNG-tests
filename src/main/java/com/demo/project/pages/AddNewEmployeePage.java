package com.demo.project.pages;

import com.demo.project.pages.navigation.WizardNavigation;
import com.demo.project.pages.wizards.employee.JobStage;
import com.demo.project.pages.wizards.employee.PersonalDetailsStage;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class AddNewEmployeePage {
    private final WizardNavigation addNewEmployeeNavigation = new WizardNavigation();
    @Getter
    private final PersonalDetailsStage personalDetailsStage = new PersonalDetailsStage();
    @Getter
    private final JobStage jobStage = new JobStage();

    public JobStage goToJobStage() {
        return addNewEmployeeNavigation.goToNextStage(jobStage);
    }

    public PersonalDetailsPage finishNewEmployeeWizard(PersonalDetailsPage personalDetails) {
        return addNewEmployeeNavigation.saveAndFinishWizard(personalDetails);
    }

    public PersonalDetailsPage finishNewEmployeeWizard(){
        return addNewEmployeeNavigation.saveAndFinishWizard(new PersonalDetailsPage());
    }

}
