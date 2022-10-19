package com.qaprosoft.carina.demo.web.gui.rozetka.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.rozetka.components.Header;
import com.qaprosoft.carina.demo.web.gui.rozetka.enums.Sections;
import com.qaprosoft.carina.demo.web.gui.rozetka.pages.sections.LaptopsAndComputersSectionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(className = "header-layout")
    private Header header;

    @FindBy(xpath = "//ul[@class='menu-categories menu-categories_type_main']//a")
    private List<ExtendedWebElement> sectionLinks;

    @FindBy(xpath = "//div[@class='simple-slider__holder']//li")
    private List<ExtendedWebElement> sliderItems;

    @FindBy(xpath = "(//section[@class='main-goods ng-star-inserted'])[1]//li")
    private List<ExtendedWebElement> promotionalOffersItems;

    @FindBy(css = "div>rz-service-links[cssclass='side'] a")
    private List<ExtendedWebElement> sidebarServiceLinks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public AbstractPage openLaptopsAndComputersSectionPage(Sections section) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//a")), 5);
        sectionLinks.stream().filter(sectionLink->sectionLink.getText().equalsIgnoreCase(section.getSectionName()))
                .findFirst().get().click();
        return initPage(driver, section.getSectionPage());
    }
}
