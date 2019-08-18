package com.demo.project.pages.wizards.employee;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.pages.generic.elements.GenericDropdownList;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

public class PersonalDetailsStage {
    private final ElementUtils personDetailsUtils = new ElementUtils();
    private final GenericDropdownList bloodGroupSelect = new GenericDropdownList("1_inputfileddiv");
    private final By hobbiesInputPath = Selectors.byId("5");


    public PersonalDetailsStage selectBloodGroup(String givenBloodGroup) {
        bloodGroupSelect.expandDropdownList()
                .chooseOption(givenBloodGroup)
                .checkIfOptionGotSelected(givenBloodGroup);
        return this;
    }

    public void fillHobbiesInput(String givenHobbies) {
        personDetailsUtils.commenceAction()
                .fillField(findHobbiesInput(), givenHobbies);
    }

    private SelenideElement findHobbiesInput() {
        return personDetailsUtils.finder().findInteractableElement.apply(hobbiesInputPath);
    }


}
