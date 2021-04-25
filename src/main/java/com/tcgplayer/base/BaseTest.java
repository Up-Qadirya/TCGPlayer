package com.tcgplayer.base;

import com.tcgplayer.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import java.util.Properties;

public class BaseTest {
    public BasePage basePage;
    public WebDriver driver;
    public Properties prop;
    public SearchPage searchPage;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browserName) {
        basePage = new BasePage();
        prop = basePage.init_Prop();
        String browserType = prop.getProperty("browser");
        driver = basePage.init_driver(browserType);
        searchPage = new SearchPage(driver);
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}

