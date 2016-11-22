package com.google.search.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExamplePage {

    @FindBy(css = "#rso>.g>.rc, .srg>.g")
    public List<WebElement> elements;
}
