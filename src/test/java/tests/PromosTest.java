package tests;

import qa.dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.localtestdata.LocalTestdata;
import qa.pageobject.components.Promos;
import qa.base.BaseTest;
import qa.records.LinkData;

public class PromosTest extends BaseTest {

    private Promos promos;

    @BeforeMethod
    public void create() {

        promos = new Promos(getPage());
    }

    @Test(dataProvider = LocalTestdata.PROMOS, dataProviderClass = DataProviders.class)
    public void images(LinkData linkData) {

        promos.clickImage(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
