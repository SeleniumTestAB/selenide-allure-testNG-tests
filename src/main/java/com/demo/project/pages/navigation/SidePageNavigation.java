package com.demo.project.pages.navigation;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.pages.UsersListViewPage;
import com.demo.project.utils.ElementUtils;
import org.openqa.selenium.By;

public class SidePageNavigation {
    private final ElementUtils sideNavigationUtils = new ElementUtils();
    private final NavCollapsibleSection adminMenu = new NavCollapsibleSection("menu_admin_viewAdminModule");
    private final NavCollapsibleSection adminUserManagementMenu = new NavCollapsibleSection("menu_admin_UserManagement");
    private final By usersSectionPath = Selectors.byId("menu_admin_viewSystemUsers");


    public SidePageNavigation expandAdminMenu() {
        adminMenu.expand();
        return this;
    }

    public SidePageNavigation expandUserManagementMenu() {
        adminUserManagementMenu.expand();
        return this;
    }

    public UsersListViewPage enterUsersListView() {
        sideNavigationUtils.commenceAction().clickOnClickableElement(findUsersListViewButton());
        return new UsersListViewPage();
    }

    private SelenideElement findUsersListViewButton() {
        return sideNavigationUtils.finder().findInteractableElement.apply(usersSectionPath);
    }

}
