package com.qaprosoft.carina.demo.web.rozetka.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductComparisonPageBase extends AbstractPage {

    public ProductComparisonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened(String compareListName);

    public abstract boolean verifyProduct(String productName);
}
