package com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.Header;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.Sections;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements ICustomTypePageFactory {

    @FindBy(className = "header-layout")
    private Header header;

    @FindBy(xpath = "//ul[@class='menu-categories menu-categories_type_main']//a")
    private List<ExtendedWebElement> sectionLinks;

    @FindBy(xpath = "//ul[@class='menu-categories menu-categories_type_main']//a")
    private ExtendedWebElement firstSection;

    @FindBy(xpath = "//div[@class='simple-slider__holder']//li")
    private List<ExtendedWebElement> sliderItems;

    @FindBy(xpath = "(//section[@class='main-goods ng-star-inserted'])[1]//li")
    private List<ExtendedWebElement> promotionalOffersItems;

    @FindBy(css = "div>rz-service-links[cssclass='side'] a")
    private List<ExtendedWebElement> sidebarServiceLinks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public AbstractPage openLaptopsAndComputersSectionPage(Sections section) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(firstSection.getBy()), 5);
        sectionLinks.stream().filter(sectionLink -> sectionLink.getText().equalsIgnoreCase(section.getSectionName()))
                .findFirst().get().click();
        return initPage(driver, section.getSectionPage());
    }
}
