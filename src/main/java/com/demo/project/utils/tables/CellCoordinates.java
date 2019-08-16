package com.demo.project.utils.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class CellCoordinates {
    private final int rowIndex;
    private final int headerIndex;
}
