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

            public Boolean apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(elementsLocator);
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

            private String currentText;

            public Boolean apply(WebDriver driver) {
                try {
                    List<WebElement> elements = driver.findElements(elementsLocator);
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

    public static ExpectedCondition<WebElement> nthElementIsVisible(final By elementsLocator, final int index) {
        return new ExpectedCondition<WebElement>() {
            List<WebElement> elements;
            WebElement actualResult;
            public WebElement apply(WebDriver driver) {
                try {
                    elements = driver.findElements(elementsLocator);
                    actualResult = elements.get(index);
                    return actualResult.isDisplayed() ? actualResult : null;
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\nExpected:"
                                + "\nVisibility of WebElement with index %s"
                                + "\nby locator - %s"
                                + "\nActual result: %s\n"
                        , index
                        , elementsLocator.toString()
                        , actualResult);
            }
        };
    }
}
