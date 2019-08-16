package com.demo.project.pages;

import com.demo.project.modals.AddUserModal;
import com.demo.project.pages.generic.elements.GenericAddButton;
import com.demo.project.utils.ElementUtils;

public class UsersListViewPage {
    private final ElementUtils userListUtils = new ElementUtils();
    private final GenericAddButton addNewUserButton = new GenericAddButton("Add User");

    public AddUserModal clickOnAddNewUserButton() {
        return addNewUserButton.addItem(new AddUserModal());
    }

}
