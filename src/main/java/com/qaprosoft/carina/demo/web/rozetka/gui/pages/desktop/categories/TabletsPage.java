package com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop.categories;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.ProductFilter;
import com.qaprosoft.carina.demo.web.rozetka.gui.components.ProductItem;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.TabletsPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TabletsPageBase.class)
public class TabletsPage extends TabletsPageBase {

    @FindBy(css = "h1.catalog-heading.ng-star-inserted")
    private ExtendedWebElement title;

    @FindBy(xpath = "//ul[@class='catalog-grid ng-star-inserted']/li")
    private List<ProductItem> productItems;

    @FindBy(xpath = "//ul[@class='catalog-grid ng-star-inserted']/li")
    private ExtendedWebElement firstProductItem;

    @FindBy(css = "rz-filter-stack.ng-star-inserted")
    private ProductFilter filter;

    public TabletsPage(WebDriver driver) {
        super(driver);
        setPageURL("tablets/c130309/");
    }

    @Override
    public boolean verifyTabletNames(String searchName) {
        return productItems.stream().allMatch(product -> StringUtils.containsIgnoreCase(product.readName(), searchName));
    }

    @Override
    public ProductFilter getFilter() {
        return filter;
    }

    @Override
    public boolean verifyTabletPrices(String min, String max) {
        List<Integer> pricesList = productItems.stream().map(productItem -> Integer.parseInt(StringUtils.deleteWhitespace(productItem.readPrice()))).collect(Collectors.toList());
        return pricesList.stream().allMatch(price -> price >= Integer.parseInt(min) && price <= Integer.parseInt(max));
    }
}
