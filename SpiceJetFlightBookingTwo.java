package com.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpiceJetFlightBookingTwo {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void performFlightBooking() {
        try {
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("Spicejet");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"))
                    .click();

            Thread.sleep(5000);

            driver.get("https://www.spicejet.com/");

            // Sign up button
            WebElement signUpButton = driver.findElement(By.xpath(
                    "//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[2]/div/a/div"));
            signUpButton.click();

            WebElement titleInput = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/select"));
            titleInput.sendKeys("Ms");

            WebElement firstNameInput = driver.findElement(By.id("first_name"));
            firstNameInput.sendKeys("K");

            WebElement lastNameInput = driver.findElement(By.id("last_name"));
            lastNameInput.sendKeys("Shivani");

            WebElement dobInput = driver.findElement(By.id("dobDate"));
            dobInput.sendKeys("03/11/2002");

            WebElement noInput = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[4]/div[1]/div/div[1]/input"));
            noInput.sendKeys("9444341749");

            WebElement emailInput = driver.findElement(By.id("email_id"));
            emailInput.sendKeys("shivanikshivi@gmail.com");

            driver.findElement(By.id("defaultCheck1")).click();

            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[7]/div[1]/a/button"));
            submitButton.click();

            // Dummy login
            driver.get("https://www.spicejet.com/");

            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/div"));
            loginButton.click();

            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[1]/div[2]/input"));
            WebElement loginButton1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[3]"));

            passwordInput.sendKeys("password123");

            
            loginButton1.click();

            // Close browser
            driver.get("https://www.spicejet.com/");
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
