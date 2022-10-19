package com.qaprosoft.carina.demo.web.gui.rozetka.pages.categories;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.common.LaptopsPageBase;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.ProductItem;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.ProductPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.sections.LaptopsAndComputersSectionPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LaptopsPageBase.class)
public class LaptopsPage extends LaptopsPageBase {

    @FindBy(css = "h1.catalog-heading.ng-star-inserted")
    private ExtendedWebElement title;
    @FindBy(xpath = "//ul[@class='catalog-grid ng-star-inserted']/li")
    private List<ProductItem> productItems;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement filterLink;

    @FindBy(css = "div[data-filter-name='producer'] a")
    private ExtendedWebElement filterBrandLink;

    @FindBy(css = "div[data-filter-name='producer'] input[placeholder='Пошук']")
    private ExtendedWebElement brandSearch;

    public LaptopsPage(WebDriver driver) {
        super(driver);
        setPageURL("notebooks/c80004/");
    }

    @Override
    public ProductPage selectProduct(String productName) {
        for (ProductItem product : productItems) {
            if (product.readName().equalsIgnoreCase(productName)) {
                return product.openProductPage();
            }
        }
        throw new RuntimeException("Unable to open product: " + productName);
    }

    @Override
    public LaptopsPage filterByBrand(String brandName) {
        filterLink.format(brandName).click();
        return new LaptopsPage(driver);
    }

    @Override
    public boolean verifyProductTitles(String searchName) {
        return productItems.stream().allMatch(product->StringUtils.containsIgnoreCase(product.readName(),searchName));
    }

    @Override
    public boolean searchBrand(String brandName) {
        brandSearch.type(brandName);
        return StringUtils.containsIgnoreCase(filterBrandLink.getText(),brandName);
    }

    @Override
    public boolean isRequestResultEmpty(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='catalog-grid ng-star-inserted']/li")), 5);
        System.out.println(productItems.size());
        return productItems.isEmpty();
    }
}
