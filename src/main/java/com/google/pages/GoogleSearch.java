package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertTrue;


public class GoogleSearch {

    public static ElementsCollection links = $$(".srg>.g");

    public static void navigateToGoogle() {
        open("https://www.google.com/ncr");
    }

    public static void search(String query) {
        $("#lst-ib").setValue(query).submit();
    }

    public static void clickLink(String linkText) {

        for (SelenideElement link : links) {

            if (link.has(text(linkText))) {
                link.$("h3>a").click();
                break;
            }
        }
        $(title()).shouldBe(exist);
    }

    public static void assertAnswers(int count) {
        links.shouldHaveSize(count);
    }

    public static void assertUrl(String url) {
        assertTrue(url().equals(url));
    }
}
