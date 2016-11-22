package com.google.search.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class ExpectedConditions {

    public static ExpectedCondition<Boolean> sizeOf(final List<WebElement> elements, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            public Boolean apply(WebDriver driver) {
                listSize = elements.size();
                return listSize == expectedSize;
            }
        };
    }
}
