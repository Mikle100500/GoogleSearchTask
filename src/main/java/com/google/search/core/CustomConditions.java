package com.google.search.core;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<Boolean> sizeOf(final By elementsLocator, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {

            private int listSize;
            private List<WebElement> elements;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLocator);
                listSize = elements.size();
                return listSize == expectedSize;
            }

            public String toString() {
                return String.format("\nSize of list: %s\nExpected to be: %s\nActual size is: %s\n"
                        , elements
                        , expectedSize
                        , listSize);
            }
        };
    }

    public static ExpectedCondition<Boolean> textInElements(final By elementsLicator
            , final int linkIndex
            , final String expectedText) {
        return new ExpectedCondition<Boolean>() {

            private List<WebElement> elements;
            private String currentText;

            public Boolean apply(WebDriver driver) {
                elements = driver.findElements(elementsLicator);
                currentText = elements.get(linkIndex).getText();
                return currentText.contains(expectedText);
            }

            public String toString() {
                return String.format("\nCurrent text of element with index %s is: %s\nExpected text: %s"
                        , linkIndex
                        , currentText
                        , expectedText);
            }
        };
    }
}
