package com.demo.project.pages;

import com.demo.project.pages.navigation.SidePageNavigation;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
public class DashboardPage {
    @Getter
    private final SidePageNavigation sidePageNavigation = new SidePageNavigation();
}
