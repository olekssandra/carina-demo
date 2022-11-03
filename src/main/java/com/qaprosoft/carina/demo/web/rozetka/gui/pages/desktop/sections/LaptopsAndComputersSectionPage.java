package com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop.sections;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.enums.ComputersSectionCategories;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.LaptopsAndComputersSectionPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LaptopsAndComputersSectionPageBase.class)
public class LaptopsAndComputersSectionPage extends LaptopsAndComputersSectionPageBase implements ICustomTypePageFactory {

    @FindBy(css = "h1.portal__heading.ng-star-inserted")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='tile-cats']")
    private List<ExtendedWebElement> categories;

    @FindBy(xpath = "//div[@class='tile-cats']")
    private ExtendedWebElement firstCategory;

    public LaptopsAndComputersSectionPage(WebDriver driver) {
        super(driver);
        setPageURL("computers-notebooks/c80253/");
    }

    @Override
    public AbstractPage openCategoryPage(ComputersSectionCategories computerCategory) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(firstCategory.getBy()), 5);
        categories.stream().filter(category -> category.getText().equalsIgnoreCase(computerCategory.getCategoryName()))
                .findFirst().get().click();
        return initPage(driver, computerCategory.getCategoryPage());
    }
}
