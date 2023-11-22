package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.components.Promos;
import qa.base.BaseTest;
import qa.records.LinkData;

public class PromosTest extends BaseTest {

    private Promos promos;

    @BeforeMethod
    public void create() {

        promos = new Promos(getPage());
    }

    @Test(dataProvider = "promos", dataProviderClass = Provider.class)
    public void images(LinkData linkData) {

        ExtentReportsManager.createTest("Clicking the \"" + linkData.link() + "\" image in the \"Promos\" section",
                "Checking whether the page with the address \"" + linkData.url() +  "\" opens after clicking the \"" + linkData.link() + "\" image.");

        promos.clickImage(linkData.link());

        Assert.assertEquals(getPage().url(), linkData.url());
    }
}
