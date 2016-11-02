package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SearchResaultPage extends BasePage{

    public ElementsCollection answers = $$(".g");

    public int countAnswersPerPage() {
        return answers.size();
    }

    public void clickLink(String linkText) {
        $(By.partialLinkText(linkText)).click();

    }
}
