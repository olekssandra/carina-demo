package com.qaprosoft.carina.demo;


import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.gui.rozetka.common.LaptopsAndComputersSectionPageBase;
import com.qaprosoft.carina.demo.web.gui.rozetka.common.LaptopsPageBase;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.CartFrame;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.Header;
import com.qaprosoft.carina.demo.web.gui.rozetka.enums.ComputersSectionCategories;
import com.qaprosoft.carina.demo.web.gui.rozetka.enums.Sections;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.categories.LaptopsPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.HomePage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.sections.LaptopsAndComputersSectionPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.ProductPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.IAbstractTest;


public class RozetkaWebTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "oleksandra")
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
        Assert.assertTrue(homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS).isPageOpened(),
                "Product section page is not opened");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Category page is not opened");
        String productName = "Ноутбук Apple MacBook Air 13\" M1 256GB 2020 (MGN93) Silver";
        ProductPage productPage = laptopsPage.selectProduct(productName);
        Assert.assertTrue(productPage.isPageOpened(productName), "Product page is not opened");
        CartFrame cartFrame = productPage.clickBuyButton();
        Assert.assertEquals(cartFrame.findCartItem(productName).readName(), productName, "The product was not added to the cart");
        Assert.assertEquals(cartFrame.getFinalPrice(),"42999", "The final price is not correct");
        cartFrame.increaseProductQuantity(productName);
        Assert.assertEquals(cartFrame.getFinalPrice(),"85998", "The final price is not correct");
        cartFrame.clickContinueShoppingBtn();
        Assert.assertFalse(cartFrame.isUIObjectPresent(), "Cart frame is not closed");
        Assert.assertEquals(productPage.getBuyProductBtnText(), "В кошику",
                "The product is not displayed as added to the cart");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testRemoveProductFromCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Category page is not opened");
        String productName = "Ноутбук Apple MacBook Air 13\" M1 256GB 2020 (MGN93) Silver";
        ProductPage productPage = laptopsPage.selectProduct(productName);
        CartFrame cartFrame = productPage.clickBuyButton();
        Assert.assertEquals(cartFrame.findCartItem(productName).readName(), productName,
                "The product was not added to the cart");
        cartFrame.removeProductFromCart(productName);
        Assert.assertTrue(cartFrame.idEmptyCartTitlePresent(), "The empty cart title is not presented");
        cartFrame.closeCartFrame();
        Assert.assertFalse(cartFrame.isUIObjectPresent(), "Cart frame is not closed");
        Assert.assertEquals(productPage.getBuyProductBtnText(), "Купити","Product page is not opened");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testFilterProductByBrand() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Category page is not opened");
        String brandName = "ASUS";
        laptopsPage.filterByBrand(brandName);
        Assert.assertTrue(laptopsPage.verifyProductTitles(brandName), "Products were not filtered by brand");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testFilterBrandSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Category page is not opened");
        String brandName = "Lenovo";
        Assert.assertTrue(laptopsPage.searchBrand(brandName), "Filter search doesn't work correctly");
    }

    @Test()
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testProductSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Header header = homePage.getHeader();
        String product ="macbook";
        LaptopsPage laptopsPage = header.searchProduct(product);
        Assert.assertFalse(laptopsPage.isRequestResultEmpty(), "Nothing was found for this request");
        Assert.assertTrue(laptopsPage.verifyProductTitles(product),"Products do not correspond to the searched name");
    }
}
