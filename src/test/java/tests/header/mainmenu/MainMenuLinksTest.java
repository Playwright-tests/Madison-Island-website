package tests.header.mainmenu;

import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.MainMenuBaseTest;

public class MainMenuLinksTest extends MainMenuBaseTest {


    @Test(groups = "withoutExpandedList")
    public void womenLink() {

        actionsForLinks("Women", URLs.WOMEN_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void menLink() {

        actionsForLinks("Men", URLs.MEN_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void accessoriesLink() {

        actionsForLinks("Accessories", URLs.ACCESSORIES_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void homeAndDecorLink() {

        actionsForLinks("Home & Decor", URLs.HOME_DECOR_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void saleLink() {

        actionsForLinks("Sale", URLs.SALE_PAGE);
    }

    @Test(groups = "withoutExpandedList")
    public void vipLink() {

        actionsForLinks("VIP", URLs.VIP_PAGE);
    }
}
