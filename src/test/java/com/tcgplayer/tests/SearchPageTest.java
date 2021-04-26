package com.tcgplayer.tests;

import com.tcgplayer.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tcgplayer.utils.Constants;

public class SearchPageTest extends BaseTest {

    @Test(priority = 0)
    public void verifySearchResultsTest() throws InterruptedException {
        System.out.println("User is searching for item at homepage and getting results");
        Assert.assertEquals(searchPage.verifySearchResults(prop.getProperty("searchItem")), Constants.NUM_OF_RESULTS);
        System.out.println("Item search is verified and matched with expected result");
    }

    @Test(priority = 1)
    public void verifyFilteredResultsTest() throws InterruptedException {
        System.out.println("User is filtering result");
        Assert.assertEquals(searchPage.verifyFilteredResults(),Constants.NUM_OF_RESULTS_FILTERED);
        System.out.println("Filtering result is verified and matched with expected result");
    }

    @Test(priority = 2)
    public void verifyItemPriceTest() throws InterruptedException {
        System.out.println("User is checking the item price");
        Assert.assertEquals(searchPage.verifyItemPrice(),Constants.ITEM_PRICE);
        System.out.println("Price verification is successfully matched with expected result");
    }

    @Test(priority = 3)
    public void validateAddItemFunctionTest() {
        System.out.println("User is adding items into the cart");
        Assert.assertTrue(searchPage.selectItemToCart(prop.getProperty("selectItemQty")),"Add item not successful!");
        System.out.println("Add items to cart is successful");
    }

    @Test(priority = 4)
    public void verifyNumOfItemInCartTest() {
        System.out.println("User is checking number of items in cart");
        Assert.assertEquals(searchPage.verifyNumOfItemInCart(),Constants.NUM_ITEM_IN_CART);
        System.out.println("Number of items in cart verified and matched with expected result");
    }
    @Test(priority = 5)
    public void validateClearCartTest() {
        System.out.println("User is clearing the cart");
        Assert.assertTrue(searchPage.clearCart(),"Clear cart not successful!");
        System.out.println("Clear cart is successful");
    }
}
