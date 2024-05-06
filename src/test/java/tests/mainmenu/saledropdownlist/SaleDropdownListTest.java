package tests.mainmenu.saledropdownlist;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.SaleDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

public class SaleDropdownListTest extends BaseTest {

    private SaleDropdownList saleDropdownList;

    @BeforeMethod
    public void prepare() {

        saleDropdownList = new SaleDropdownList(getPage());
        saleDropdownList.hoverTriggerElement();
    }

    @Test
    public void viewAllSaleLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickViewAllSaleLink, saleDropdownList, URLs.SALE_PAGE);
    }

    @Test
    public void womenLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickWomenLink, saleDropdownList, URLs.SALE_WOMEN_PAGE);
    }

    @Test
    public void menLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickMenLink, saleDropdownList, URLs.SALE_MEN_PAGE);
    }

    @Test
    public void accessories() {

        clickAndVerifyPageUrl(SaleDropdownList::clickAccessoriesLink, saleDropdownList, URLs.SALE_ACCESSORIES_PAGE);
    }

    @Test
    public void homeAndDecorLink() {

        clickAndVerifyPageUrl(SaleDropdownList::clickHomeAndDecorLink, saleDropdownList, URLs.SALE_HOME_DECOR_PAGE);
    }
}
