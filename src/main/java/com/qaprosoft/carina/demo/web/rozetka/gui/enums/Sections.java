package com.qaprosoft.carina.demo.web.rozetka.gui.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.LaptopsAndComputersSectionPageBase;

public enum Sections {
    LAPTOPS_AND_COMPUTERS("Ноутбуки та комп’ютери", LaptopsAndComputersSectionPageBase.class);
//    SMARTPHONES_TV_ELECTRONICS("Смартфони, ТВ і Електроніка"),
//    GOODS_FOR_GAMERS("Товари для геймерів"),
//    HOUSEHOLD_APPLIANCES("Побутова техніка"),
//    HOME_GOODS("Товари для дому"),
//    TOOLS_AND_AUTO_GOODS("Інструменти та автотовари"),
//    PLUMBING_AND_REPAIR("Сантехніка та ремонт"),
//    DACHA_GARDEN_VEGETABLE_GARDEN("Дача, сад і город"),
//    SPORTS_AND_HOBBIES("Спорт і захоплення"),
//    CLOTHES_SHOES_AND_ACCESSORIES("Одяг, взуття та прикраси"),
//    BEAUTY_AND_HEALTH("Краса та здоров'я"),
//    GOODS_FOR_CHILDREN("Дитячі товари"),
//    PRODUCTS_FOR_PETS("Зоотовари"),
//    OFFICE_SCHOOL_BOOKS("Офіс, школа, книги"),
//    ALCOHOLIC_BEVERAGES_AND_PRODUCTS("Алкогольні напої та продукти"),
//    PRODUCTS_FOR_BUSINESS_AND_SERVICES("Товари для бізнесу та послуги"),
//    MAIN_SALE_UP_TO_50_PERCENT("Головний розпродаж до -50%");

    private final String sectionName;

    private Class<? extends AbstractPage> sectionPage;

    Sections(String sectionName, Class<? extends AbstractPage> sectionPage){
        this.sectionName = sectionName;
        this.sectionPage = sectionPage;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public Class<? extends AbstractPage> getSectionPage() {
        return this.sectionPage;
    }
}
