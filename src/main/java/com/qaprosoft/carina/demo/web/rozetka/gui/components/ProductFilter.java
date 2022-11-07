package com.qaprosoft.carina.demo.web.rozetka.gui.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductFilter extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement filterLink;

    @FindBy(css = "div[data-filter-name='producer'] a")
    private ExtendedWebElement filterBrandLink;

    @FindBy(css = "div[data-filter-name='producer'] input[placeholder='Пошук']")
    private ExtendedWebElement brandSearch;

    @FindBy(xpath = "//div[@class='slider-filter__inner']/input[1]")
    private ExtendedWebElement minPrice;

    @FindBy(xpath = "//div[@class='slider-filter__inner']/input[2]")
    private ExtendedWebElement maxPrice;

    @FindBy(xpath = "//div[@class='slider-filter__inner']/button")
    private ExtendedWebElement submitBtn;

    public ProductFilter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AbstractPage filterProductsByItem(String filterItem, Class<? extends AbstractPage> categoryPage) {
        filterLink.format(filterItem).click();
        return initPage(getDriver(), categoryPage);
    }

    public AbstractPage filterProductsByPrice(String min, String max, Class<? extends AbstractPage> categoryPage) {
        minPrice.type(min);
        maxPrice.type(max);
        submitBtn.click();
        return initPage(getDriver(), categoryPage);
    }

    public boolean searchBrand(String brandName) {
        brandSearch.type(brandName);
        return StringUtils.containsIgnoreCase(filterBrandLink.getText(), brandName);
    }
}
