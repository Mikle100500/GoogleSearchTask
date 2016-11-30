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

            Boolean currentState;

            public WebElement apply(WebDriver driver) {
                try {
                    List<WebElement> elements = driver.findElements(elementsLocator);
                    currentState = elements.get(index).isDisplayed();
                    return currentState ? elements.get(index) : null;
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\nVisibility of %s element, located %s"
                                + "\nExpected visibility state: true"
                                + "\nActual visibility state: %s\n"
                        , index
                        , elementsLocator.toString()
                        , currentState);
            }
        };
    }
}
