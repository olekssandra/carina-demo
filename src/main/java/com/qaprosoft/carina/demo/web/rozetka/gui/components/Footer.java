package com.qaprosoft.carina.demo.web.rozetka.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {

    @FindBy(className = "footer")
    private ExtendedWebElement footerSection;

    @FindBy(css = "ul.socials__list li")
    private ExtendedWebElement socialMediaLinks;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
