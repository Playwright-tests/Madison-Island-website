package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.components.Promos;
import qa.base.BaseTest;
import qa.utils.Pair;


public class PromosTest extends BaseTest {

    private Promos promos;

    @BeforeMethod
    public void create() {

        promos = new Promos(getPage());
    }

    @Test(dataProvider = "promos", dataProviderClass = Provider.class)
    public void images(Pair<String, String> data) {

        promos.clickImage(data.getFirst());

        Assert.assertEquals(getPage().url(), data.getSecond());
    }
}
