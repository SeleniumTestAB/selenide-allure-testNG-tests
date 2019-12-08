package com.demo.project.pages;

import com.demo.project.modals.AddUserModal;
import com.demo.project.pages.generic.elements.GenericAddButton;


public class UsersListViewPage {
    private final GenericAddButton addNewUserButton = new GenericAddButton("Add User");

    public AddUserModal clickOnAddNewUserButton() {
        return addNewUserButton.addItem(new AddUserModal());
    }

}
