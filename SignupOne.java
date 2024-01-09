package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignupOne {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void signUpTest() {
        try {
            driver.findElement(By.name("q")).sendKeys("Spicejet");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"))
                    .click();

            Thread.sleep(5000);

            driver.get("https://www.spicejet.com/");

            WebElement loginButton = driver.findElement(By.xpath(
                    "//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/div"));
            loginButton.click();

            driver.findElement(By.xpath(
                    "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div[1]/svg/g/circle[2]"))
                    .click();

            WebElement passwordInput = driver.findElement(By.xpath(
                    "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[1]/div[2]/input"));
            WebElement loginButton1 = driver.findElement(By.xpath(
                    "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[3]"));

            passwordInput.sendKeys("password123");

            // Click on the submit button
            loginButton1.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}