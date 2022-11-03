package com.qaprosoft.carina.demo.web.rozetka.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.ProductFilter;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop.ProductPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop.categories.LaptopsPage;
import org.openqa.selenium.WebDriver;

public abstract class LaptopsPageBase extends AbstractPage {

    public LaptopsPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract ProductPageBase selectProduct(String productName);

    //public abstract LaptopsPageBase filterProductsByItem(String filterItem);
    public abstract ProductFilter getFilter();

    public abstract boolean verifyProductTitles(String searchName);


    public abstract boolean isRequestResultEmpty();

    public abstract LaptopsPageBase sortProductsByOption(String sortOption);

    public abstract boolean verifyProductPrices(String option);

    public abstract ProductPageBase openFirstProduct();

    public abstract String getFirstProductName();
}
