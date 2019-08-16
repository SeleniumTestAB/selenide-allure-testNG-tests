package com.demo.project.utils.tables;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.demo.project.utils.ElementUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import java.util.List;

public class WebTableHandler {
    private final ElementUtils tableUtils = new ElementUtils();
    private final By cellValuePath = Selectors.byXpath("./descendant::span");
    private final By cellEditButtonPath = Selectors.byXpath("./td[@data-tooltip='Edit']");

    private List<SelenideElement> retrieveListOfTableHeadersFromPage() {
        return tableUtils.finder().findExistingElements.apply(Selectors.byXpath("//thead/descendant::th"));
    }

    public List<SelenideElement> retrieveListOfTableRowsFromPage() {
        return tableUtils.finder().findExistingElements.apply(Selectors.byXpath("//thbody/descendant::tr"));
    }

    public List<SelenideElement> retrieveCellsFromRow(SelenideElement givenRow) {
        return tableUtils.finder().findNestedExistingElements.apply(givenRow, Selectors.byXpath("./td"));
    }

    public int getNumberOfTableHeaders() {
        return retrieveListOfTableHeadersFromPage().size();
    }

    public int findIndexOfAHeaderColumn(String givenHeader) {
        int foundHeaderIndex = 0;
        for (int headerIndex = 0; headerIndex < getNumberOfTableHeaders(); headerIndex++) {
            if (retrieveListOfTableHeadersFromPage().get(headerIndex)
                    .has(Condition.attribute("data-field", givenHeader))) {
                foundHeaderIndex = headerIndex;
            }
        }
        return foundHeaderIndex;
    }

    public CellCoordinates retrieveCellCoordinates(String givenHeader, String searchValue) {
        int searchHeaderIndex = findIndexOfAHeaderColumn(givenHeader);
        List<SelenideElement> rows = retrieveListOfTableRowsFromPage();
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            List<SelenideElement> cellsInRow = retrieveCellsFromRow(rows.get(rowIndex));
            for (int cellIndex = 0; cellIndex < cellsInRow.size(); cellIndex++) {
                String valueOfCell = tableUtils.finder().findNestedReadableElement
                        .apply(cellsInRow.get(cellIndex), cellValuePath).getText();
                if (StringUtils.equals(valueOfCell, searchValue) && searchHeaderIndex == cellIndex) {
                    return new CellCoordinates(rowIndex, searchHeaderIndex);
                }
            }
            cellsInRow.clear();
        }
        throw new IllegalStateException("There was no such cell with value " + searchValue + " in column with name " + givenHeader + "!");
    }

    public SelenideElement getCellEditInfoButton(CellCoordinates cellCoordinates) {
        SelenideElement rowContainingCell = retrieveListOfTableRowsFromPage().get(cellCoordinates.rowIndex());
        return tableUtils.finder().findNestedExistingElement.apply(rowContainingCell, cellEditButtonPath);
    }


}
