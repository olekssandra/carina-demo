package com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.ProductComparisonPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductComparisonPageBase.class)
public class ProductComparisonPage extends ProductComparisonPageBase {

    @FindBy(className = "comparison__heading")
    private ExtendedWebElement compareListTitle;

    @FindBy(css = "ul.products-grid li a")
    private List<ExtendedWebElement> comparedProductsNames;

    public ProductComparisonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String compareListName) {
        return compareListTitle.isElementWithTextPresent("Порівнюємо " + compareListName.toLowerCase());
    }

    @Override
    public boolean verifyProduct(String productName) {
        System.out.println(productName);
        System.out.println(comparedProductsNames.get(0).getText());
        return comparedProductsNames.stream().anyMatch(name -> StringUtils.equalsIgnoreCase(name.getText(), productName));
    }
}
