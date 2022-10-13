package com.qaprosoft.carina.demo.web.gui.rozetka.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.CartFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(className = "product__title")
    private ExtendedWebElement productTitle;

    @FindBy(className = "product-prices__big")
    private ExtendedWebElement productPrice;
    @FindBy(css = "button.buy-button.button--with-icon.button--green.button--medium.ng-star-inserted")
    private ExtendedWebElement buyProductBtn;

    @FindBy(className = "modal__holder_show_animation")
    private CartFrame cartFrame;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://rozetka.com.ua/ua/apple_macbook_air_13_m1_256gb_2020_silver/p245161903/");
    }

    public CartFrame clickBuyButton() {
        buyProductBtn.click();
        return new CartFrame(driver);
    }

    public ExtendedWebElement getBuyProductBtn() {
        return this.buyProductBtn;
    }
}
