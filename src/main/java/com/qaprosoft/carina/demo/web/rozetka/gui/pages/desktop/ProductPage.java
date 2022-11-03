package com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.CartFrame;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.CompareList;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.Header;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(className = "header-layout")
    private Header header;

    @FindBy(className = "product__title")
    private ExtendedWebElement productTitle;

    @FindBy(className = "product-prices__big")
    private ExtendedWebElement productPrice;

    @FindBy(className = "product__buy")
    private ExtendedWebElement buyProductBtn;

    @FindBy(className = "modal__holder_show_animation")
    private CartFrame cartFrame;

    @FindBy(css = "button.compare-button")
    private ExtendedWebElement compareBtn;

    @FindBy(className = "modal__holder")
    private CompareList compareFrame;

    @FindBy(xpath = "(//img[@class='picture-container__picture'])[1]")
    private ExtendedWebElement img;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    @Override
    public CartFrame clickBuyButton() {
        buyProductBtn.click();
        if(!isCartFramePresent())
            buyProductBtn.click();
        return new CartFrame(driver);
    }

    @Override
    public String getBuyProductBtnText() {
        return this.buyProductBtn.getText();
    }

    @Override
    public boolean isPageOpened(String productName) {
        return productTitle.isElementWithTextPresent(productName);
    }

    @Override
    public void addProductToCompareList() {
        compareBtn.hover();
        compareBtn.click();
    }

    @Override
    public boolean isCompareFramePresent() {
        return compareFrame.isUIObjectPresent();
    }

    @Override
    public boolean isCartFramePresent() {
        return cartFrame.isUIObjectPresent();
    }

    @Override
    public String getProductTitle() {
        return productTitle.getText();
    }
}
