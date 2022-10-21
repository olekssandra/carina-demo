package com.qaprosoft.carina.demo.web.rozetka.gui.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.ProductComparisonPageBase;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop.ProductComparisonPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CompareList extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(className = "modal__heading")
    private ExtendedWebElement heading;

    @FindBy(className = "comparison-modal__link")
    private List<ExtendedWebElement> comparisonListNames;

    public CompareList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CompareList(WebDriver driver) {
        super(driver);
    }

    public boolean checkComparisonListsContainsList(String listName){
        return comparisonListNames.stream().anyMatch(name-> StringUtils.containsIgnoreCase(name.getText(),listName));
    }

    public ProductComparisonPageBase openComparisonList(String listName){
        comparisonListNames.stream().filter(name-> StringUtils.containsIgnoreCase(name.getText(),listName))
                .findFirst().get().click();
        return initPage(getDriver(), ProductComparisonPageBase.class);
    }
}
