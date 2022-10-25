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

    @FindBy(className = "//button[@class='header__button ng-tns-c94-1']")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(id = "fat-menu")
    private ExtendedWebElement catalogButton;

    @FindBy(xpath = "//input[@name='search']")
    private ExtendedWebElement search;

    @FindBy(css = "button.button_color_green.search-form__submit.ng-star-inserted")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//ul[@class='lang lang-header ng-star-inserted']/li")
    private List<ExtendedWebElement> languageItems;

    @FindBy(xpath = "//span[@class='lang__link lang__link--active ng-star-inserted']/text()")
    private ExtendedWebElement currentLanguage;

    @FindBy(xpath = "//a[@class='help-zsu header-actions__component']")
    private ExtendedWebElement comeBackAliveLink;

    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--user']//button")
    private ExtendedWebElement userIcon;

    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--cart']//button")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//span[@class='counter counter--green ng-star-inserted']")
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
