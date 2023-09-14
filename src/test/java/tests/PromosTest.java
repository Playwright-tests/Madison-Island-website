package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.components.Promos;
import qa.base.BaseTest;
import java.util.function.Consumer;

public class PromosTest extends BaseTest {

    private Promos promos;

    @BeforeClass
    public void init() {

        promos = new Promos(getPage());
    }

    private void check(String URL, Consumer<Promos> consumer) {

        consumer.accept(promos);

        String currentURL = getPage().url();

        getPage().goBack();
        Assert.assertEquals(currentURL, URL);
    }

    @Test(dataProvider = "promosHomeDecor", dataProviderClass = Provider.class)
    public void homeAndDecorImage(String[] URL) {

        check(URL[0], Promos::clickHomeAndDecorImage);
    }

    @Test(dataProvider = "promosShopPrivateSales", dataProviderClass = Provider.class)
    public void shopPrivateSalesImage(String[] URL) {

        check(URL[0], Promos::clickShopPrivateSalesImage);
    }

    @Test(dataProvider = "promosTravelGear", dataProviderClass = Provider.class)
    public void travelGearImage(String[] URL) {

        check(URL[0], Promos::clickTravelGearImage);
    }
}
