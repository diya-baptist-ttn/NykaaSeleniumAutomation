package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
        setup();
        loginPage = new LoginPage(getDriver());
        logoutPage = new LogoutPage(getDriver());

        // First, log in before logging out
        loginPage.login("8920436404");  // Use test phone number
        Thread.sleep(50000); // Wait for OTP (Assuming it's auto-filled)
    }

    @Test
    public void testLogout() throws InterruptedException {
        logoutPage.logout();
    }

    @AfterClass
    public void tearDownTest() {
        quit();
    }
}
