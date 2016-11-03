package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class GoogleSearch {

    public static ElementsCollection links = $$(".srg>.g");

    public static void navigateToGoogle() {
        open("https://www.google.com/ncr");
    }

    public static void search(String query) {
        $(".gsfi").setValue(query).submit();
    }

    public static void clickLink(String linkText) {

        for (SelenideElement link : links) {
            if (link.shouldHave(text(linkText)) != null) {
                link.$("h3>a").click();
                break;
            }
        }
    }

    public static void assertAnswers(int count) {
        links.shouldHaveSize(count);
    }

    public static void assertTitle(String title) {
        $(title()).shouldHave(exactText(title));
    }
}
