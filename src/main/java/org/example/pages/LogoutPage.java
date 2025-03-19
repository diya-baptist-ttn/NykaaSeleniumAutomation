package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By profileButton = By.xpath("//button[@aria-label='Kebab menu']");
    private By logoutButton = By.xpath("//button[contains(text(),'Logout')]");
    private By confirmLogout = By.xpath("//*[@id=\"portal-root\"]/div/div[1]/div/div/div[1]");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logout() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogout)).click();
        Thread.sleep(3000);
    }
}
