package com.qaprosoft.carina.demo.web.gui.rozetka.pages.categories;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.ProductItem;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.ProductPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopsPage extends AbstractPage {

    @FindBy(css = "h1.catalog-heading.ng-star-inserted")
    private ExtendedWebElement title;
    @FindBy(xpath = "//ul[@class='catalog-grid ng-star-inserted']/li")
    private List<ProductItem> productItems;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement filterLink;

    @FindBy(css = "div[data-filter-name='producer'] a")
    private ExtendedWebElement filterBrandLink;

    @FindBy(css = "div[data-filter-name='producer'] input[placeholder='Пошук']")
    private ExtendedWebElement brandSearch;

    public LaptopsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://rozetka.com.ua/ua/notebooks/c80004/");
    }

    public ProductPage selectProduct(String productName) {
        for (ProductItem product : productItems) {
            if (product.readName().equalsIgnoreCase(productName)) {
                return product.openProductPage();
            }
        }
        throw new RuntimeException("Unable to open product: " + productName);
    }

    public LaptopsPage filterByBrand(String brandName) {
        filterLink.format(brandName).click();
        return new LaptopsPage(driver);
    }

    public boolean verifyProductTitles(String searchName) {
        for (ProductItem product : productItems) {
            if (!StringUtils.containsIgnoreCase(product.readName(),searchName)) {
                return false;
            }
        }
        return true;
    }

    public boolean searchBrand(String brandName) {
        brandSearch.type(brandName);
        if(!StringUtils.containsIgnoreCase(filterBrandLink.getText(),brandName)){
            return false;
        }
        return true;
    }

    public boolean isRequestResultEmpty(){
        return productItems.isEmpty();
    }
}
