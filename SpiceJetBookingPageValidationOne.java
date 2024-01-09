package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpiceJetBookingPageValidationOne {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateSpiceJetLinks() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Spicejet");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"))
                .click();

        driver.get("https://www.spicejet.com/");

        WebElement checkInLink = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[2]/div[2]"));
        checkInLink.click();
        driver.navigate().back();

        WebElement flightStatusLink = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[3]/div[2]"));
        flightStatusLink.click();
        driver.navigate().back();

        WebElement manageBookingLink = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[4]/div[2]"));
        manageBookingLink.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
