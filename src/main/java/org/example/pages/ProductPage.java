package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By firstProduct = By.xpath("(//div[contains(@class, 'css') and contains(@class, 'product')]//a)[1]");
    private By addToBagButton = By.xpath("(//button[contains(@class, 'css-13zjqg6')])[1]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFirstProduct() {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        product.click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void addToCart() {
        WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToBag);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToBag);
    }
}
