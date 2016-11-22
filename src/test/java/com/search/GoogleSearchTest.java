package com.search;

import com.google.search.pages.ExamplePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    static{
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mikle/chromedriver_win32/chromedriver.exe");
    }

    private static WebDriver driver;
    private ExamplePage page = PageFactory.initElements(driver, ExamplePage.class);

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
    }

    @AfterClass
    public  static void tearDown(){
        driver.quit();
    }

    @Test
    public void testGoogleSearch(){

        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("Selenium automates browsers" + Keys.ENTER);

        assertTrue((new WebDriverWait(driver, 5))
                .until(com.google.search.core.ExpectedConditions.sizeOf(page.elements, 10)));


        assertTrue(page.elements.get(0).getText().contains("Selenium automates browsers"));

        page.elements.get(0).findElement(By.cssSelector("h3>a")).click();

        assertTrue((new WebDriverWait(driver, 5))
                .until(ExpectedConditions.urlToBe("http://docs.seleniumhq.org/")));
    }
}

