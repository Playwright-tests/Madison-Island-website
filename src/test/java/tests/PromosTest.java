package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.PromosDataProvider;
import qa.support.dataprovidernames.DataProviderNames;
import qa.pageobject.middlesection.Promos;
import qa.base.BaseTest;
import qa.records.LinkData;

public class PromosTest extends BaseTest {

    private Promos promos;

    @BeforeMethod
    public void create() {

        promos = new Promos(getPage());
    }

    @Test(dataProvider = DataProviderNames.PROMOS, dataProviderClass = PromosDataProvider.class)
    public void images(LinkData linkData) {

        promos.clickImage(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
