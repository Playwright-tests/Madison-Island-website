package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.sections.Header;
import qa.base.BaseTest;

public class MainMenuTest extends BaseTest {

    private static Header header;


    @BeforeAll
    public static void init() {

        header = new Header(getPage());
    }

    private void clickElementList(String navHeader, String locator) {

        header.getMainMenu().setDropdownList(locator);

        for (int i = 0; i < header.getMainMenu().getDropdownListCount(); i++) {

            header.getMainMenu().clickElementList(navHeader, i);
            //mainMenu.clickElementList(navHeader, i);
        }
    }

    @Test
    public void womenDropdownList() {

        clickElementList("Women", "li.nav-1>ul");
    }

    @Test
    public void menDropdownList() {

        clickElementList("Men", "li.nav-2>ul");
    }

    @Test
    public void accessoriesDropdownList() {

        clickElementList("Accessories", "li.nav-3>ul");
    }

    @Test
    void homeAndDecorDropdownList() {

        clickElementList("Home & Decor", "li.nav-4>ul");
    }

    @Test
    void saleDropdownList() {

        clickElementList("Sale", "li.nav-5>ul");
    }

    @Test
    void vipDropdownList() {

        clickElementList("VIP", "li.nav-6>ul");
    }
}
