package com.qaprosoft.carina.demo.web.gui.rozetka.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductSectionPage extends AbstractPage {

    @FindBy(css = "h1.portal__heading.ng-star-inserted")
    private ExtendedWebElement title;

    @FindBy(xpath = "//ul[@class='portal-grid portal-grid_type_1_6']/li")
    private List<ExtendedWebElement> categories;

    public ProductSectionPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://rozetka.com.ua/ua/computers-notebooks/c80253/");
    }

    public String getSectionTitle() {
        return title.getText();
    }

    public ExtendedWebElement findCategory(String name) {
        for (ExtendedWebElement category : categories) {
            if (category.getText().equalsIgnoreCase(name))
                return category;
        }
        throw new RuntimeException("Unable to open category: " + name);
    }

    public CategoryPage openCategoryPage(String categoryName) {
        findCategory(categoryName).click();
        return new CategoryPage(driver);
    }
}
