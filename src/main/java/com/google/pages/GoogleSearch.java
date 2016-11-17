package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class GoogleSearch {

    public static WebDriver driver;

    public void navigateToGoogle() {
        driver.get("https://www.google.com/ncr");
    }

    public List<WebElement> results = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#rso>.g>.rc, .srg>.g")));

    public void search(String queryText) {
        driver.findElement(By.name("q")).sendKeys(queryText + Keys.ENTER);
    }

    public void followLink(int index) {
        results.get(index).findElement(By.cssSelector("h3>a")).click();
    }

    public void assertResultsCount(int count) {
        assertEquals(count, results.size());
    }
}
