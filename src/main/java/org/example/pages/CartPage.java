package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstProduct = By.xpath("(//div[contains(@class, 'css') and contains(@class, 'product')]//a)[1]");
    private By addToBagButton = By.xpath("(//button[contains(@class, 'css-13zjqg6')])[1]");
    private By bagIcon = By.xpath("(//button)[3]");
    private By firstIframe = By.xpath("(//iframe)[1]");
    private By checkoutButton = By.xpath("(//button[@class='css-f1qhpj e8tshxd0'])[2]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void addToCart() throws InterruptedException {
        // Step 1: Click on the first product
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        product.click();

        // Step 2: Switch to new tab
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }

        // Step 3: Click "Add to Bag"
        WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToBag);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToBag);
        Thread.sleep(3000);
    }

    public void goToCartAndProceed() throws InterruptedException {
        // Step 4: Click on the Bag icon
        wait.until(ExpectedConditions.elementToBeClickable(bagIcon)).click();
        Thread.sleep(3000);

        // Step 5: Switch to iframe for checkout
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(firstIframe));
        driver.switchTo().frame(iframeElement);

        // Step 6: Click "Checkout"
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        Thread.sleep(3000);

        // Step 7: Switch back to main page
        driver.switchTo().defaultContent();
    }
}
