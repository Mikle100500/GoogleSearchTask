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
                return String.format("\nSize of list located by %s"
                                + "\nExpected size should be: %s"
                                + "\nActual size is: %s\n"
                        , elementsLocator
                        , expectedSize
                        , listSize);
            }
        };
    }

    public static ExpectedCondition<Boolean> nthListElementHasText(final By elementsLocator
            , final int index
            , final String expectedText) {
        return new ExpectedCondition<Boolean>() {

            private List<WebElement> elements;
            private String currentText;

            public Boolean apply(WebDriver driver) {
                try {
                    elements = driver.findElements(elementsLocator);
                    currentText = elements.get(index).getText();
                    return currentText.contains(expectedText);
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }

            public String toString() {
                return String.format("\nText of %s element, located %s"
                                + "\nExpected text should be: %s"
                                + "\nActual text is: %s\n"
                        , index
                        , elementsLocator.toString()
                        , expectedText
                        , currentText);
            }
        };
    }
}
