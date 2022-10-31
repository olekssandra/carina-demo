package com.qaprosoft.carina.demo.web.rozetka.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class='cart-product__title']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//button[@class='button button_color_white button_size_medium cart-counter__button'][2]")
    private ExtendedWebElement addProductBtn;

    @FindBy(xpath = ".(//button[@class='button button_color_white button_size_medium cart-counter__button'])[1]")
    private ExtendedWebElement removeProductBtn;

    @FindBy(id = "cartProductActions0")
    private ExtendedWebElement productActionsBtn;

    @FindBy(className = "context-menu-actions__button")
    private ExtendedWebElement deleteBtn;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readName() {
        return productTitle.getText();
    }

    public void clickAddProductBtn() {
        addProductBtn.click();
    }

    public void clickProductActionsBtn() {
        productActionsBtn.click();
    }

    public void clickDeleteBtn() {
        deleteBtn.click();
    }
}
