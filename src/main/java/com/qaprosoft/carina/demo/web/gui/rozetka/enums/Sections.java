package com.qaprosoft.carina.demo.web.gui.rozetka.enums;

public enum Sections {
    LAPTOPS_AND_COMPUTERS("Ноутбуки та комп’ютери"),
    SMARTPHONES_TV_ELECTRONICS("Смартфони, ТВ і Електроніка"),
    GOODS_FOR_GAMERS("Товари для геймерів"),
    HOUSEHOLD_APPLIANCES("Побутова техніка"),
    HOME_GOODS("Товари для дому"),
    TOOLS_AND_AUTO_GOODS("Інструменти та автотовари"),
    PLUMBING_AND_REPAIR("Сантехніка та ремонт"),
    DACHA_GARDEN_VEGETABLE_GARDEN("Дача, сад і город"),
    SPORTS_AND_HOBBIES("Спорт і захоплення"),
    CLOTHES_SHOES_AND_ACCESSORIES("Одяг, взуття та прикраси"),
    BEAUTY_AND_HEALTH("Краса та здоров'я"),
    GOODS_FOR_CHILDREN("Дитячі товари"),
    PRODUCTS_FOR_PETS("Зоотовари"),
    OFFICE_SCHOOL_BOOKS("Офіс, школа, книги"),
    ALCOHOLIC_BEVERAGES_AND_PRODUCTS("Алкогольні напої та продукти"),
    PRODUCTS_FOR_BUSINESS_AND_SERVICES("Товари для бізнесу та послуги"),
    MAIN_SALE_UP_TO_50_PERCENT("Головний розпродаж до -50%");

    private final String sectionName;

    Sections(String sectionName){
        this.sectionName = sectionName;
    }

    public String getSectionName(){
        return this.sectionName;
    }
}
