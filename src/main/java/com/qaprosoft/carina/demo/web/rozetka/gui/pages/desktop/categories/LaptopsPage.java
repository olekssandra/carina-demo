package com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop.categories;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.ProductItem;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.ProductSortingOptions;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.LaptopsPageBase;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.ProductPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LaptopsPageBase.class)
public class LaptopsPage extends LaptopsPageBase {

    @FindBy(css = "h1.catalog-heading.ng-star-inserted")
    private ExtendedWebElement title;
    @FindBy(xpath = "//ul[@class='catalog-grid ng-star-inserted']/li")
    private List<ProductItem> productItems;

    @FindBy(xpath = "//ul[@class='catalog-grid ng-star-inserted']/li")
    private ExtendedWebElement firstProductItem;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement filterLink;

    @FindBy(css = "div[data-filter-name='producer'] a")
    private ExtendedWebElement filterBrandLink;

    @FindBy(css = "div[data-filter-name='producer'] input[placeholder='Пошук']")
    private ExtendedWebElement brandSearch;

    @FindBy(className = "select-css")
    private ExtendedWebElement sortByDropDownList;

    @FindBy(xpath = "//select//option[@class='ng-star-inserted'][text()='%s']")
    private ExtendedWebElement sortBydropDownListOptions;

    public LaptopsPage(WebDriver driver) {
        super(driver);
        setPageURL("notebooks/c80004/");
    }

    @Override
    public ProductPageBase selectProduct(String productName) {
        for (ProductItem product : productItems) {
            if (StringUtils.containsIgnoreCase(product.readName(), productName)) {
                return product.openProductPage();
            }
        }
        throw new RuntimeException("Unable to open product: " + productName);
    }

    @Override
    public LaptopsPageBase filterProductsByItem(String filterItem) {
        filterLink.format(filterItem).click();
        return initPage(getDriver(), LaptopsPageBase.class);
    }

    @Override
    public boolean verifyProductTitles(String searchName) {
        return productItems.stream().allMatch(product -> StringUtils.containsIgnoreCase(product.readName(), searchName));
    }

    @Override
    public boolean searchBrand(String brandName) {
        brandSearch.type(brandName);
        return StringUtils.containsIgnoreCase(filterBrandLink.getText(), brandName);
    }

    @Override
    public boolean isRequestResultEmpty() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(firstProductItem.getBy()), 5);
        return productItems.isEmpty();
    }

    @Override
    public LaptopsPageBase sortProductsByOption(String sortOption) {
        sortByDropDownList.click();
        sortBydropDownListOptions.format(sortOption).click();
        return initPage(getDriver(), LaptopsPageBase.class);
    }

    @Override
    public boolean verifyProductPrices(String option) {
        List<Integer> pricesList = productItems.stream().map(productItem -> Integer.parseInt(StringUtils.deleteWhitespace(productItem.readPrice()))).collect(Collectors.toList());
        if (ProductSortingOptions.CHEAP_TO_EXPENSIVE.getOptionName().equals(option)) {
            List<Integer> sortedList = pricesList.stream().sorted().collect(Collectors.toList());
            return pricesList.equals(sortedList);
        }
        if (ProductSortingOptions.EXPENSIVE_TO_CHEAP.getOptionName().equals(option)) {
            List<Integer> sortedList = pricesList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            return pricesList.equals(sortedList);
        }
        throw new RuntimeException("Unable to sort the products");
    }

    @Override
    public ProductPageBase openFirstProduct() {
        return productItems.get(0).openProductPage();
    }

    @Override
    public String getFirstProductName() {
        return productItems.get(0).readName();
    }
}
