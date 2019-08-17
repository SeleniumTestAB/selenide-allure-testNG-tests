package com.demo.project.pages.wizards.employee;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.pages.generic.elements.GenericSelectList;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

public class PersonalDetailsStage {
    private final ElementUtils personDetailsUtils = new ElementUtils();
    private final GenericSelectList bloodGroupSelect = new GenericSelectList("1_inputfileddiv", "1");
    private final By hobbiesInputPath = Selectors.byId("5");


    public PersonalDetailsStage selectBloodGroup(String givenBloodGroup) {
        bloodGroupSelect.openSelectContainer()
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
