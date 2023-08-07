package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.components.Promos;
import qa.base.BaseTest;

public class PromosTest extends BaseTest {

    private Promos promos;

    @BeforeClass
    public void init() {

        promos = new Promos(getPage());
    }

    @Test
    public void homeAndDecorImage() {

        promos.clickHomeAndDecorImage();
        getPage().goBack();
    }

    @Test
    public void shopPrivateSalesImage() {

        promos.clickShopPrivateSalesImage();
        getPage().goBack();
    }

    @Test
    public void travelGearImage() {

        promos.clickTravelGearImage();
        getPage().goBack();
    }
}
