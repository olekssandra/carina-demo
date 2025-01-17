package com.qaprosoft.carina.demo;


import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.CartFrame;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.CompareList;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.Header;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.ComputersSectionCategories;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.ProductSortingOptions;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.Sections;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RozetkaWebTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testHeaderVerifying() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        Assert.assertTrue(header.isUIObjectPresent(), "Header wasn't found!");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testProductSectionOpening() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS).isPageOpened(),
                "Product section page is not opened");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testAddProductToCart() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Category page is not opened");
        String productName = "Ноутбук Apple MacBook Air 13\" M1 256GB 2020 (MGN63) Space Gray";
        ProductPageBase productPage = laptopsPage.selectProduct(productName);
        Assert.assertTrue(productPage.isPageOpened(productName), "Product page is not opened");
        //Header header = productPage.getHeader();
        CartFrame cartFrame = productPage.clickBuyButton();
        Assert.assertEquals(cartFrame.findCartItem(productName).readName(), productName, "The product was not added to the cart");
        Assert.assertEquals(cartFrame.getFinalPrice(), "42999", "The final price is not correct");
        cartFrame.increaseProductQuantity(productName);
        Assert.assertEquals(cartFrame.getFinalPrice(), "85998", "The final price is not correct");
        cartFrame.clickContinueShoppingBtn();
        Assert.assertFalse(cartFrame.isUIObjectPresent(), "Cart frame is not closed");
        Assert.assertEquals(productPage.getBuyProductBtnText(), "В кошику",
                "The product is not displayed as added to the cart");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testRemoveProductFromCart() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Category page is not opened");
        String productName = "Ноутбук Apple MacBook Air 13\" M1 256GB 2020 (MGN63) Space Gray";
        ProductPageBase productPage = laptopsPage.selectProduct(productName);
        CartFrame cartFrame = productPage.clickBuyButton();
        Assert.assertEquals(cartFrame.findCartItem(productName).readName(), productName,
                "The product was not added to the cart");
        cartFrame.removeProductFromCart(productName);
        Assert.assertTrue(cartFrame.isEmptyCartTitlePresent(), "The empty cart title is not presented");
        cartFrame.closeCartFrame();
        Assert.assertFalse(cartFrame.isUIObjectPresent(), "Cart frame is not closed");
        Assert.assertEquals(productPage.getBuyProductBtnText(), "Купити", "Product page is not opened");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testFilterProductByBrand() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Laptops page is not opened");
        String brandName = "ASUS";
        laptopsPage.filterProductsByItem(brandName);
        Assert.assertTrue(laptopsPage.verifyProductTitles(brandName), "Products were not filtered by brand");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testFilterBrandSearch() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        Assert.assertTrue(laptopsPage.isPageOpened(), "Laptops page is not opened");
        String brandName = "Lenovo";
        Assert.assertTrue(laptopsPage.searchBrand(brandName), "Filter search doesn't work correctly");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testProductSearch() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Header header = homePage.getHeader();
        String product = "macbook";
        LaptopsPageBase laptopsPage = header.searchProduct(product);
        Assert.assertFalse(laptopsPage.isRequestResultEmpty(), "Nothing was found for this request");
        Assert.assertTrue(laptopsPage.verifyProductTitles(product), "Products do not correspond to the searched name");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testSortProductsFromExpensiveToCheap() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        String brand = "Lenovo";
        laptopsPage.filterProductsByItem(brand);
        Assert.assertTrue(laptopsPage.verifyProductTitles(brand), "Products were not filtered by brand");
        laptopsPage.sortProductsByOption(ProductSortingOptions.CHEAP_TO_EXPENSIVE.getOptionName());
        Assert.assertTrue(laptopsPage.verifyProductPrices(ProductSortingOptions.CHEAP_TO_EXPENSIVE.getOptionName()), "Products were not sorted from cheap to expensive");
    }

    @Test()
    @MethodOwner(owner = "oordak")
    @TestLabel(name = "feature", value = {"web"})
    public void testAddProductToCompareList() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LaptopsAndComputersSectionPageBase laptopsAndComputersSectionPage =
                (LaptopsAndComputersSectionPageBase) homePage.openLaptopsAndComputersSectionPage(Sections.LAPTOPS_AND_COMPUTERS);
        Assert.assertTrue(laptopsAndComputersSectionPage.isPageOpened(), "Product section page is not opened");
        LaptopsPageBase laptopsPage = (LaptopsPageBase) laptopsAndComputersSectionPage.openCategoryPage(ComputersSectionCategories.LAPTOPS);
        String brand = "Lenovo";
        laptopsPage.filterProductsByItem(brand);
        Assert.assertTrue(laptopsPage.verifyProductTitles(brand), "Products were not filtered by brand");
        laptopsPage.sortProductsByOption(ProductSortingOptions.EXPENSIVE_TO_CHEAP.getOptionName());
        Assert.assertTrue(laptopsPage.verifyProductPrices(ProductSortingOptions.EXPENSIVE_TO_CHEAP.getOptionName()), "Products were not sorted from expensive to cheap");
        String productName = laptopsPage.getFirstProductName();
        ProductPageBase productPage = laptopsPage.openFirstProduct();
        Assert.assertTrue(productPage.isPageOpened(productName), "Product page is not opened");
        Header header = productPage.getHeader();
        productPage.addProductToCompareList();
        CompareList compareList = header.clickCompareListIcon();
        Assert.assertTrue(productPage.isCompareFramePresent(), "Compare frame is not opened");
        Assert.assertTrue(compareList.checkComparisonListsContainsList(ComputersSectionCategories.LAPTOPS.getCategoryName()));
        ProductComparisonPageBase productComparisonPage = compareList.openComparisonList(ComputersSectionCategories.LAPTOPS.getCategoryName());
        Assert.assertTrue(productComparisonPage.isPageOpened(ComputersSectionCategories.LAPTOPS.getCategoryName()), "Product comparison page is not opened");
        Assert.assertTrue(productComparisonPage.verifyProduct(productName), "Comparison page does not contain the selected product");
    }
}
