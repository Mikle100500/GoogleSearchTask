package com.google;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    public static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testGoogleSearch(){

        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("Selenium automates browsers" + Keys.ENTER);

        List<WebElement> results = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#rso>.g>.rc, .srg>.g")));

        assertEquals(10, results.size());
        assertTrue(results.get(0).findElement(By.cssSelector(".st")).getText().contains("Selenium automates browsers"));

        results.get(0).findElement(By.cssSelector("h3>a")).click();

        assertTrue(driver.findElement(By.cssSelector("#mainContent>h2")).getText().contains("What is Selenium?"));
        assertEquals("http://docs.seleniumhq.org/", driver.getCurrentUrl());

    }
}

