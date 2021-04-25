package com.tcgplayer.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    //public WebDriver driver;
    public static WebDriver driver;
    public Properties prop;

    public WebDriver init_driver(String browser) {
        System.out.println("Browser type is " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();


        }

        getDriver().manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();


    }

    public static WebDriver getDriver() {
        return driver;
    }

    public Properties init_Prop() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/main/java/com/tcgplayer/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }

    public String getScreenshot() {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}

   /* private static BasePage basePage;
    private static Properties prop;
    private static WebDriver driver;

    public BasePage() {
        prop = new Properties();

        FileInputStream fis ;
        try {

            fis = new FileInputStream("./src/main/java/com/tcgplayer/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String browserName= prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }else if (browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.getInstance(SafariDriver.class).setup();
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public static WebDriver getDriver() {
        return driver;

    }

    public static void openPage() {
        driver.get(prop.getProperty("url"));
    }

    public static void setUp() {
        if(basePage == null) { //means if there is no object created in this class
            basePage = new BasePage();
        }
    }

    public static void tearDown() {
        if(driver!= null) {//if driver is not null
            driver.quit();
        }
        basePage = null; //release the basePage to the null, reseting object memory to zero/nullBa
    }
*/

