package com.qaprosoft.carina.demo.web.rozetka.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.CartFrame;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.Header;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

    public abstract CartFrame clickBuyButton();

    public abstract String getBuyProductBtnText();

    public abstract boolean isPageOpened(String productName);

    public abstract void addProductToCompareList();

    public abstract boolean isCompareFramePresent();

    public abstract String getProductTitle();
}
