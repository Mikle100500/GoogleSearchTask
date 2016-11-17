package com.google;

import com.google.pages.GoogleSearch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.pages.GoogleSearch.driver;
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

    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mikle/chromedriver_win32/chromedriver.exe");
    }

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

        GoogleSearch page = new GoogleSearch();

        page.navigateToGoogle();

        page.search("Selenium automates browsers");
        page.assertResultsCount(10);
        assertEquals("Selenium automates browsers", page.results.get(0).getText());

        page.followLink(0);

        WebElement mainContent = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mainContent>h2")));
        assertEquals("What is Selenium?", mainContent.getText());

        assertEquals("http://docs.seleniumhq.org/", driver.getCurrentUrl());
        driver.quit();
    }
}
