package com.qaprosoft.carina.demo.web.rozetka.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CartFrame extends AbstractUIObject {

    @FindBy(xpath = "//ul[@class='cart-list ng-star-inserted']/li")
    private List<CartItem> cartItems;

    @FindBy(xpath = "//ul[@class='cart-list ng-star-inserted']/li")
    private ExtendedWebElement firstCartItem;

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
        waitUntil(ExpectedConditions.visibilityOfElementLocated(finalPrice.getBy()), 3);
        return finalPrice.getText();
    }

    public CartItem findCartItem(String name) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(firstCartItem.getBy()), 5);
        return cartItems.stream().filter(item -> item.readName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    public CartFrame increaseProductQuantity(String productName) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(firstCartItem.getBy()), 5);
        findCartItem(productName).clickAddProductBtn();
        return new CartFrame(driver);
    }

    public CartFrame removeProductFromCart(String productName) {
        CartItem productItem = findCartItem(productName);
        productItem.clickProductActionsBtn();
        productItem.clickDeleteBtn();
        return new CartFrame(driver);
    }

    public boolean idEmptyCartTitlePresent() {
        return this.emptyCartTitle.isElementPresent();
    }
}
