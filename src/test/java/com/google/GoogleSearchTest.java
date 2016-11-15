package com.google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSearchAndFollowLink(){

        navigateToGoogle();

        search("Selenium automates browsers");
        assertResultsCount(10);
        assertEquals("Selenium automates browsers", results.get(0).getText());

        followLink(0);

        WebElement mainContent = driver.findElement(By.cssSelector("#mainContent>h2"));
        assertEquals("What is Selenium?", mainContent.getText());

        assertEquals("http://docs.seleniumhq.org/", driver.getCurrentUrl());
        driver.quit();

    }
}
