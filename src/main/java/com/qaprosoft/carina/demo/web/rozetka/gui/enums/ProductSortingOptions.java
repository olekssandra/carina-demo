package com.qaprosoft.carina.demo.web.rozetka.gui.enums;

public enum ProductSortingOptions {
    CHEAP_TO_EXPENSIVE("Від дешевих до дорогих"),
    EXPENSIVE_TO_CHEAP("Від дорогих до дешевих"),
    NEWS("Новинки"),
    BY_RATING("За рейтингом");

    private final String optionName;

    ProductSortingOptions(String sortName) {
        this.optionName = sortName;
    }

    public String getOptionName() {
        return this.optionName;
    }
}
