package com.qaprosoft.carina.demo.web.gui.rozetka.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class='goods-tile__heading ng-star-inserted']")
    private ExtendedWebElement productName;

    @FindBy(css = ".//span[@class='goods-tile__price-value']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//button[@class='buy-button goods-tile__buy-button ng-star-inserted']")
    private ExtendedWebElement productCartBtns;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readName() {
        return productName.getText();
    }

    public ProductPage openProductPage() {
        productName.click();
        return new ProductPage(driver);
    }
}
