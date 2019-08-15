package com.demo.project.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Accessors(fluent = true)
public class ElementUtils {
    private ElementFinder finder = new ElementFinder();
    private ElementActions commenceAction = new ElementActions();
}
