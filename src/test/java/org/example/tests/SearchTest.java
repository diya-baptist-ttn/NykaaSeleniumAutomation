package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.SearchPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    private SearchPage searchPage;

    @BeforeClass
    public void setUpTest() {
        setup();
        searchPage = new SearchPage(getDriver());
    }

    @Test
    public void testSearchProduct() throws InterruptedException {
        searchPage.searchProduct("Lipstick");
    }

    @AfterClass
    public void tearDownTest() {
        quit();
    }
}
