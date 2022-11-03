package com.qaprosoft.carina.demo.web.rozetka.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.ProductFilter;
import org.openqa.selenium.WebDriver;

public abstract class TabletsPageBase extends AbstractPage {

    public TabletsPageBase(WebDriver driver) {
        super(driver);
    }

    //public abstract LaptopsPageBase filterProductsByItem(String filterItem);

    public abstract boolean verifyTabletNames(String searchName);

    public abstract ProductFilter getFilter();

    public abstract boolean verifyTabletPrices(String min, String max);
}
