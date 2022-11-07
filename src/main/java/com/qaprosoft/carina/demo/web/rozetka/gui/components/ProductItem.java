package com.qaprosoft.carina.demo.web.rozetka.gui.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.ProductPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//span[@class='goods-tile__title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//span[@class='goods-tile__price-value']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//div[@class='goods-tile__prices']//button")
    private ExtendedWebElement productCartBtn;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readName() {
        return productName.getText();
    }

    public String readPrice() {
        return productPrice.getText();
    }

    public ProductPageBase openProductPage() {
        productName.click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
