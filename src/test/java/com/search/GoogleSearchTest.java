package com.search;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.search.core.CustomConditions.sizeOf;
import static com.google.search.core.CustomConditions.nthListElementHasText;

/**
 * Automate:
 * 1 visit http://google.com/ncr
 * 2 search: “Selenium automates browsers”
 * 3 check that 10 results are found
 * 4 check the text “Selenium automates browsers” in 1st result
 * 5 follow the link in 1st result
 * 6 check that selenium official page is loaded
 */

public class GoogleSearchTest {

    static {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mikle/chromedriver_win32/chromedriver.exe");
    }

    private static WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private By links = By.cssSelector("#rso>.g>.rc, .srg>.g");

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testGoogleSearch() {

        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("Selenium automates browsers" + Keys.ENTER);

        wait.until(sizeOf(links, 10));

        wait.until(nthListElementHasText(links, 0, "Selenium automates browsers"));

        followLink(0);

        wait.until(ExpectedConditions.urlToBe("http://docs.seleniumhq.org/"));
    }

    private void followLink(int index){

        driver.findElements(links)
                .get(index)
                .findElement(By.cssSelector("h3>a"))
                .click();
    }
}
