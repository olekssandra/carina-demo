package com.qaprosoft.carina.demo.web.gui.rozetka.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartFrame extends AbstractUIObject {

    @FindBy(xpath = "//ul[@class='cart-list ng-star-inserted']/li")
    private List<CartItem> cartItems;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span[1]")
    private ExtendedWebElement finalPrice;

    @FindBy(className = "cart-receipt__submit")
    private ExtendedWebElement submitOrderBtn;

    @FindBy(className = "modal__close")
    private ExtendedWebElement closeBtn;

    @FindBy(css = "button[data-testid='continue-shopping-link']")
    private ExtendedWebElement continueShoppingBtn;

    @FindBy(className = "cart-dummy__heading")
    private ExtendedWebElement emptyCartTitle;

    public CartFrame(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartFrame(WebDriver driver) {
        super(driver);
    }

    public void closeCartFrame() {
        closeBtn.click();
    }

    public void clickContinueShoppingBtn() {
        continueShoppingBtn.click();
    }

    public String getFinalPrice() {
        return finalPrice.getText();
    }

    public CartItem findCartItem(String name) {
        for (CartItem item : cartItems) {
            if (item.readName().equalsIgnoreCase(name))
                return item;
        }
        throw new RuntimeException("Unable to find an item: " + name);
    }

    public void increaseProductQuantity(String productName) {
        findCartItem(productName).clickAddProductBtn();
    }

    public void removeProductFromCart(String productName) {
        CartItem productItem = findCartItem(productName);
        productItem.clickProductActionsBtn();
        productItem.clickDeleteBtn();
    }

    public boolean idEmptyCartTitlePresent() {
        return this.emptyCartTitle.isElementPresent();
    }
}
