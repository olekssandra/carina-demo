package com.qaprosoft.carina.demo.web.rozetka.gui.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.LaptopsPageBase;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.common.TabletsPageBase;
import com.qaprosoft.carina.demo.web.rozetka.gui.pages.desktop.categories.TabletsPage;

public enum ComputersSectionCategories {
    LAPTOPS("Ноутбуки", LaptopsPageBase.class),
//    COMPUTERS_NETTOPS_MONOBLOCS("Комп'ютери, неттопи, моноблоки"),
//    MONITORS("Монітори"),
//    GAMING("Gaming"),
    TABLETS("Планшети", TabletsPageBase.class);
//    CABLES_AND_ADAPTERS("Кабелі та адаптери"),
//    COMPUTER_COMPONENTS("Комп'ютерні комплектуючі"),
//    NETWORK_EQUIPMENT("Мережеве обладнання"),
//    HEADPHONES_AND_ACCESSORIES("Навушники та аксесуари"),
//    KEYBOARDS_AND_MICE("Клавіатури та миші"),
//    ACCESSORIES_FOR_ELECTRONICS("Аксесуари для електроніки"),
//    OFFICE_EQUIPMENT("Офісна техніка"),
//    ACOUSTIC_SYSTEMS("Акустичні системи"),
//    SOFTWARE("Програмне забезпечення"),
//    GRAPHICS_TABLETS("Графічні планшети"),
//    MICROPHONES("Мікрофони"),
//    SERVER_EQUIPMENT("Серверне обладнання"),
//    INTERACTIVE_EQUIPMENT("Інтерактивне обладнання");
    private final String categoryName;

    private final Class<? extends AbstractPage> categoryPage;

    ComputersSectionCategories(String categoryName, Class<? extends AbstractPage> categoryPage) {
        this.categoryName = categoryName;
        this.categoryPage = categoryPage;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Class<? extends AbstractPage> getCategoryPage() {
        return this.categoryPage;
    }
}
