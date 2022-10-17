package com.qaprosoft.carina.demo.web.gui.rozetka.enums;

public enum ComputersSectionCategories {
    LAPTOPS("Ноутбуки"),
    COMPUTERS_NETTOPS_MONOBLOCS("Комп'ютери, неттопи, моноблоки"),
    MONITORS("Монітори"),
    GAMING("Gaming"),
    TABLETS("Планшети"),
    CABLES_AND_ADAPTERS("Кабелі та адаптери"),
    COMPUTER_COMPONENTS("Комп'ютерні комплектуючі"),
    NETWORK_EQUIPMENT("Мережеве обладнання"),
    HEADPHONES_AND_ACCESSORIES("Навушники та аксесуари"),
    KEYBOARDS_AND_MICE("Клавіатури та миші"),
    ACCESSORIES_FOR_ELECTRONICS("Аксесуари для електроніки"),
    OFFICE_EQUIPMENT("Офісна техніка"),
    ACOUSTIC_SYSTEMS("Акустичні системи"),
    SOFTWARE("Програмне забезпечення"),
    GRAPHICS_TABLETS("Графічні планшети"),
    MICROPHONES("Мікрофони"),
    SERVER_EQUIPMENT("Серверне обладнання"),
    INTERACTIVE_EQUIPMENT("Інтерактивне обладнання");

    private final String categoryName;


    ComputersSectionCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    }
