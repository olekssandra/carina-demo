package com.qaprosoft.carina.demo;


import com.qaprosoft.carina.demo.web.gui.rozetka.components.CartFrame;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.Header;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.CategoryPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.HomePage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.ProductPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.ProductSectionPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.IAbstractTest;


public class RozetkaWebTest implements IAbstractTest {

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testHeaderVerifying() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(), "Header wasn't found!");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testProductSectionOpening() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.openProductSectionPage("Ноутбуки та комп’ютери").isPageOpened(), "Product section page is not opened");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSectionPage productSectionPage = homePage.openProductSectionPage("Ноутбуки та комп’ютери");
        Assert.assertTrue(productSectionPage.isPageOpened(), "Product section page is not opened");
        CategoryPage categoryPage = productSectionPage.openCategoryPage("Ноутбуки");
        Assert.assertTrue(categoryPage.isPageOpened(), "Category page is not opened");
        String productName = "Ноутбук Apple MacBook Air 13\" M1 256GB 2020 (MGN93) Silver";
        ProductPage productPage = categoryPage.selectProduct(productName);
        Assert.assertTrue(productPage.isPageOpened(), "Product page is not opened");
        CartFrame cartFrame = productPage.clickBuyButton();
        Assert.assertEquals(cartFrame.findCartItem(productName).readName(), productName, "The product was not added to the cart");
        Assert.assertEquals(cartFrame.getFinalPrice(),"42999", "The final price is not correct");
        cartFrame.increaseProductQuantity(productName);
        Assert.assertEquals(cartFrame.getFinalPrice(),"85998", "The final price is not correct");
        cartFrame.clickContinueShoppingBtn();
        Assert.assertFalse(cartFrame.isUIObjectPresent(), "Cart frame is not closed");
        Assert.assertEquals(productPage.getBuyProductBtn().getText(), "В кошику","The product is not displayed as added to the cart");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testRemoveProductFromCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductSectionPage productSectionPage = homePage.openProductSectionPage("Ноутбуки та комп’ютери");
        CategoryPage categoryPage = productSectionPage.openCategoryPage("Ноутбуки");
        String productName = "Ноутбук Apple MacBook Air 13\" M1 256GB 2020 (MGN93) Silver";
        ProductPage productPage = categoryPage.selectProduct(productName);
        CartFrame cartFrame = productPage.clickBuyButton();
        Assert.assertEquals(cartFrame.findCartItem(productName).readName(), productName, "The product was not added to the cart");
        cartFrame.removeProductFromCart(productName);
        Assert.assertTrue(cartFrame.idEmptyCartTitlePresent(), "The empty cart title is not presented");
        cartFrame.closeCartFrame();
        Assert.assertFalse(cartFrame.isUIObjectPresent(), "Cart frame is not closed");
        Assert.assertEquals(productPage.getBuyProductBtn().getText(), "Купити","Product page is not opened");
    }
}
