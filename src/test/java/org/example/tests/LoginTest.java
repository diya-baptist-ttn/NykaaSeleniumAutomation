package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeClass
    public void setUpTest() {
        setup();
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void testLogin() throws InterruptedException {
        loginPage.login("8920436404");
    }

    @AfterClass
    public void tearDownTest() {
        quit();
    }
}
