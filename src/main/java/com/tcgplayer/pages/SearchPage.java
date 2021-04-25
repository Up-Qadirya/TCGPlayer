package com.tcgplayer.pages;

import com.tcgplayer.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.tcgplayer.utils.ElementUtil;

public class SearchPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By searchBox = By.xpath("//input[contains(@role,'search')]");
    private By searchBtn = By.xpath("//button[@value='conduct product search']");
    private By searchResults = By.xpath("/html/body/div[1]/div/section[2]/div/div[1]/h1");
    // /html/body/div[1]/div/section[2]/div/div[1]/h1/text()
    private By checkBoxProductLineName = By.xpath("//span[contains(@id,'ForceofWill-filter-label')]");
    private By checkBox2 = By.xpath("(//span[contains(@class,'option-value-mobile')])[4]");
    //private By itemPrice = By.xpath("//span[@class='search-result__market-price--value'])[2]");
    private By itemPrice = By.xpath("/html/body/div[1]/div/section[2]/section/section/span/section/div[2]/div/a[1]/section[3]/span[2]");
    private By itemToBuy = By.xpath("(//span[@class='search-result__title'][contains(.,'The Hidden History - \"Mikage\"')])[1]"); // need to verify
    private By qtyOfItemToBuy = By.xpath("//select[@class='custom-select product-listing__qty-to-buy']");
    private By addToCartBtn = By.xpath("//button[@id='btnAddToCart_FeaturedSeller']");
    private By cartSummaryTag = By.xpath("//h2[contains(.,'Shopping Cart Summary')]");
    private By numOfItemInCart = By.xpath("//div[@data-aid='numberOfItemsValue']");
    private By editCartBtn = By.xpath("//button[@data-aid='editYourCart']");
    private By clearCartBtn = By.xpath("//button[@onclick='confirmClearCart()']");
    private By confirmClearCartBtn = By.xpath("//button[contains(.,'OK')]");
    private By cartEmptyMsg = By.xpath("//h1[contains(.,'Your Shopping Cart is Empty')]");


    public String verifySearchResults(String searchTarget) throws InterruptedException {
        elementUtil.doSendKeys(searchBox, searchTarget);
        elementUtil.doClick(searchBtn);
        Thread.sleep(5000);
        return elementUtil.doGetText(searchResults);
    }


    public String verifyFilteredResults() throws InterruptedException {
        elementUtil.doClick(checkBoxProductLineName);
        Thread.sleep(5000);
        return elementUtil.doGetText(searchResults);
    }

    public String verifyItemPrice() throws InterruptedException {

        Thread.sleep(5000);
        return elementUtil.doGetText(itemPrice);
    }

    public boolean selectItemToCart(String numOfItem) {
        elementUtil.doClick(itemToBuy);
        elementUtil.selectDropDown(driver.findElement(this.qtyOfItemToBuy), numOfItem);
        elementUtil.doClick(addToCartBtn);
        return elementUtil.doIsDisplayed(cartSummaryTag);
    }

    public String verifyNumOfItemInCart() {


        return elementUtil.doGetText(numOfItemInCart);
    }

    public boolean clearCart() {
        elementUtil.doClick(editCartBtn);
        elementUtil.doClick(clearCartBtn);
        //driver.switchTo().alert().accept();
        elementUtil.doClick(confirmClearCartBtn);
        return elementUtil.doIsDisplayed(cartEmptyMsg);
    }


}
