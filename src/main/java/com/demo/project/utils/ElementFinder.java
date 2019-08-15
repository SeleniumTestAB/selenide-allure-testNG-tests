package com.demo.project.utils;



import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.function.BiFunction;
import java.util.function.Function;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ElementFinder extends Expectations{
    public Function<By, SelenideElement> findExistingElement = (elementPath -> $(elementPath).should(exist));
    public Function<By, SelenideElement> findReadableElement = (elementPath -> $(elementPath).shouldBe(readable));
    public Function<By, SelenideElement> findActiveElement = (elementPath -> $(elementPath).shouldBe(active));
    public Function<By, SelenideElement> findInteractableElement = (elementPath -> $(elementPath).shouldBe(interactable));
    public BiFunction<SelenideElement, By, SelenideElement> findNestedExistingElement = (parent, childPath) -> parent.find(childPath).should(exist);
    public BiFunction<SelenideElement, By, SelenideElement> findNestedReadableElement = (parent, childPath) -> parent.find(childPath).shouldBe(readable);
    public BiFunction<SelenideElement, By, SelenideElement> findNestedActiveElement = (parent, childPath) -> parent.find(childPath).shouldBe(active);
    public BiFunction<SelenideElement, By, SelenideElement> findNestedInteractableElement = (parent, childPath) -> parent.find(childPath).shouldBe(interactable);



}
