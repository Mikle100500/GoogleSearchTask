package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class GoogleSearch {

    public static WebDriver driver = new ChromeDriver();

    public static List<WebElement> results = driver.findElements(By.cssSelector("#rso>.g>.rc, .srg>.g"));

    public static void navigateToGoogle() {
        driver.get("https://www.google.com/ncr");
    }

    public static void search(String queryText) {
        driver.findElement(By.name("q")).sendKeys(queryText + Keys.ENTER);
    }

    public static void followLink(int index) {
        results.get(index).findElement(By.cssSelector("h3>a")).click();
    }

    public static void assertResultsCount(int count) {
        assertEquals(count, results.size());
    }
}
