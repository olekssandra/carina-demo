package com.qaprosoft.carina.demo.web.gui.rozetka.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.ProductPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.categories.LaptopsPage;
import org.openqa.selenium.WebDriver;

public abstract class LaptopsPageBase extends AbstractPage {
    public LaptopsPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract ProductPage selectProduct(String productName);

    public abstract LaptopsPage filterByBrand(String brandName);

    public abstract boolean verifyProductTitles(String searchName);

    public abstract boolean searchBrand(String brandName);

    public abstract boolean isRequestResultEmpty();
}
