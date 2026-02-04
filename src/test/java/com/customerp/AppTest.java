package com.customerp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class AppTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.manage().window().maximize();

            driver.get("https://uat.customerportal.apainsurance.ke/"); 
            System.out.println("Opened browser successfully.");
            WebElement requestButton = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(By.id("request-for-quote")));
            requestButton.click();
            System.out.println("Clicked on Request for Quotation button successfully.");
            WebElement fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullName")));
            fullName.sendKeys("Phaustine Mulongo");
            driver.findElement(By.id("mobile")).sendKeys("794978627");
            driver.findElement(By.id("email")).sendKeys("Test89@gmail.com");
            driver.findElement(By.id("kra")).sendKeys("A000077885P");
            driver.findElement(By.id("password")).sendKeys("Apollo@123");
            driver.findElement(By.id("ConfirmPassword")).sendKeys("Apollo@123");
            WebElement termsBox = driver.findElement(By.xpath("//div[contains(@class, 'v-input--selection-controls__ripple')]"));
            termsBox.click();
            WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("signUp")));
            registerBtn.click();


            Thread.sleep(50000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
        }
    }
}