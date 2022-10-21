package com.qaprosoft.carina.demo.web.rozetka.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.Header;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.Sections;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();

    public abstract AbstractPage openLaptopsAndComputersSectionPage(Sections section);
}
