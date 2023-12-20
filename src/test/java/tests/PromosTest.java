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

        ExtentReportsManager.createTest("Clicking the \"" + linkData.getLink() + "\" image in the \"Promos\" section",
                "Checking whether the page with the address \"" + linkData.getUrl() +  "\" opens after clicking the \"" + linkData.getLink() + "\" image.");

        promos.clickImage(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
