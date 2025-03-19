package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.SearchPage;
import org.example.pages.CartPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    private LoginPage loginPage;
    private SearchPage searchPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
        setup();
        loginPage = new LoginPage(getDriver());
        searchPage = new SearchPage(getDriver());
        cartPage = new CartPage(getDriver());

        // Step 1: Login
        //loginPage.login("8920436404");  // Using the same test number

        // Step 2: Search for a product
        searchPage.searchProduct("Lipstick");
    }

    @Test
    public void testFullCartFlow() throws InterruptedException {
        // Step 3: Select product and add to cart
        cartPage.addToCart();

        // Step 4: Go to cart and proceed to checkout
        cartPage.goToCartAndProceed();
    }

    @AfterClass
    public void tearDownTest() {
        quit();
    }
}
