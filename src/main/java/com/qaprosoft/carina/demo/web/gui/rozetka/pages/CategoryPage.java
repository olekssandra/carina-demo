package com.qaprosoft.carina.demo.web.gui.rozetka.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.ProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends AbstractPage {

    @FindBy(css = "h1.catalog-heading.ng-star-inserted")
    private ExtendedWebElement title;
    @FindBy(xpath = "//ul[@class='catalog-grid ng-star-inserted']/li")
    private List<ProductItem> productItems;

    public CategoryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://rozetka.com.ua/ua/notebooks/c80004/");
    }

    public ProductPage selectProduct(String productName) {
        for (ProductItem product : productItems) {
            if (product.readName().equalsIgnoreCase(productName)) {
                return product.openProductPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + productName);
    }
}
