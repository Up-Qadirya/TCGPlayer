package com.tcgplayer.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementUtil {

    private WebDriver driver;

    public ElementUtil(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /*public List<WebElement> getElements(By locator) {

        return driver.findElements(locator);
    }*/

    public void doSendKeys(By locator, String value) {

        getElement(locator).sendKeys(value);
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public boolean doIsDisplayed(By locator) {

        return getElement(locator).isDisplayed();
    }

    public boolean doIsEnabled(By locator) {

        return getElement(locator).isEnabled();
    }

    public String doGetText(By locator) {

        return getElement(locator).getText();
    }

    public void selectDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);

    }
    public void waitForElementTobeVisible(By locator, int timeOut) {
        WebElement element = getElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickWithJS(By element) {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("argument[0].click()",element);
    }


}
