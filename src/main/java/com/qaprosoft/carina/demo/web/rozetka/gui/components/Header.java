package com.qaprosoft.carina.demo.web.rozetka.gui.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.LaptopsPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(className = "header__logo")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "(//div[@class='header-layout']//button)[1]")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(id = "fat-menu")
    private ExtendedWebElement catalogButton;

    @FindBy(xpath = "//input[@name='search']")
    private ExtendedWebElement search;

    @FindBy(css = "button.button_color_green.search-form__submit.ng-star-inserted")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "button.header__button.ng-star-inserted.header__button--active")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "button.header__button.ng-star-inserted.header__button--active span")
    private ExtendedWebElement productCounter;

    @FindBy(css = "button[aria-label='Списки порівнянь']")
    private ExtendedWebElement compareListIcon;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CartFrame clickCartIcon() {
        cartIcon.click();
        return new CartFrame(driver);
    }

    public void typeProductNameToSearch(String productName) {
        search.type(productName);
    }

    public LaptopsPageBase searchProduct(String productName) {
        typeProductNameToSearch(productName);
        searchButton.click();
        return initPage(getDriver(), LaptopsPageBase.class);
    }

    public CompareList clickCompareListIcon() {
        compareListIcon.click();
        return new CompareList(driver);
    }
}
