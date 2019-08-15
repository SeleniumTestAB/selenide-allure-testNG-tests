package com.demo.project.utils;




import com.codeborne.selenide.Condition;


import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;


class Expectations {

    final Condition readable = and("Element is readable/visible on page", exist, visible);
    final Condition active = and("Element is active on page", exist, enabled);
    final Condition interactable = and("Element is interactable on page", active, readable);


}
