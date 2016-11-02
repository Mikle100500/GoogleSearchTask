package com.google.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class SearchResaultPage extends BasePage {


    public void clickLink(String linkText) {
        $(By.partialLinkText(linkText)).click();

    }
}
