package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By loginButton = By.xpath("//button[contains(text(),'Sign in')]");
    private By phoneInput = By.xpath("//input[@type='tel']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String phoneNumber) throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        driver.findElement(phoneInput).sendKeys(phoneNumber);
        Thread.sleep(20000);
        Thread.sleep(50000); // Assuming OTP auto-fills
    }
}
