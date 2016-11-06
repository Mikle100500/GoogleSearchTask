package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class GoogleSearch {

    public static ElementsCollection results = $$(By.xpath("//*[@id=\"rso\" or @class=\"srg\"]/div[@class=\"g\"]"));

    public static void navigateToGoogle() {
        open("https://www.google.com/ncr");
    }

    public static void search(String queryText) {
        $(By.name("q")).setValue(queryText).submit();
    }

    public static void followFirstLink() {
        results.get(0).$("h3>a").click();
    }

    public static void assertResultsCount(int count) {
        results.shouldHaveSize(count);
    }
}
