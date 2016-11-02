package com.google.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


public class GoogleSearch {

    public static void navigateToGoogle(){
        open("https://www.google.com/");
    }

    public static void search(String query){
        $("#lst-ib").setValue(query).submit();
    }

    public static void clickLink(String linkText) {
        $(By.partialLinkText(linkText)).click();
    }

    public static void assertAnswers(int count) {
        $$(".g").shouldHaveSize(count);
    }

    public static void assertTitle(String title){
        $(title()).shouldHave(exactText(title));
    }
}
