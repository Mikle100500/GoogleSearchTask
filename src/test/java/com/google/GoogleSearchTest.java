package com.google;

import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.google.pages.GoogleSearch.*;
import static org.junit.Assert.assertEquals;

/**

 Automate:
 1 visit http://google.com/ncr
 2 search: “Selenium automates browsers”
 3 check that 10 results are found
 4 check the text “Selenium automates browsers” in 1st result
 5 follow the link in 1st result
 6 check that selenium official page is loaded

 */
public class GoogleSearchTest {

    @Test
    public void testSearchAndFollowLink(){

        navigateToGoogle();

        search("Selenium automates browsers");
        assertResultsCount(10);
        results.get(0).shouldHave(text("Selenium automates browsers"));

        followLink(0);

        $("#mainContent>h2").shouldHave(text("What is Selenium?"));
        assertEquals("http://docs.seleniumhq.org/", url());

//        adding coments
    }
}
