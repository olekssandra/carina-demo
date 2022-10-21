package com.qaprosoft.carina.demo.web.rozetka.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.ComputersSectionCategories;
import org.openqa.selenium.WebDriver;

public abstract class LaptopsAndComputersSectionPageBase extends AbstractPage {

    public LaptopsAndComputersSectionPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage openCategoryPage(ComputersSectionCategories computerCategory);
}
