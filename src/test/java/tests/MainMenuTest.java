package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.sections.Header;
import qa.base.BaseTest;
import qa.utils.Pair;


public class MainMenuTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        header = new Header(getPage());
    }

    private void check(String button, Pair<String, String> data) {

        header.getMainMenu().hoverParent(button);
        header.getMainMenu().clickItem(data.getFirst());

        Assert.assertEquals(getPage().url(), data.getSecond(),
                "The page with address \"" + data.getSecond() + "\" has not been opened");
    }

    @Test(dataProvider = "mainMenuWomen", dataProviderClass = Provider.class)
    public void women(Pair<String, String> data) {

        ExtentReportsManager.createTest("Clicking the \"" + data.getFirst() + "\" link in the \"Women\" section",
                "Checking whether the page with the address \"" + data.getSecond() +  "\" opens after clicking the \"" + data.getFirst() + "\" link.");

        check("Women", data);
    }

    @Test(dataProvider = "mainMenuMen", dataProviderClass = Provider.class)
    public void men(Pair<String, String> data) {

        ExtentReportsManager.createTest("Clicking the \"" + data.getFirst() + "\" link in the \"Men\" section",
                "Checking whether the page with the address \"" + data.getSecond() +  "\" opens after clicking the \"" + data.getFirst() + "\" link.");

        check("Men", data);
    }

    @Test(dataProvider = "mainMenuAccessories", dataProviderClass = Provider.class)
    public void accessories(Pair<String, String> data) {

        check("Accessories", data);
    }

    @Test(dataProvider = "mainMenuHomeDecor", dataProviderClass = Provider.class)
    void homeAndDecor(Pair<String, String> data) {

        ExtentReportsManager.createTest("Clicking the \"" + data.getFirst() + "\" link in the \"Home and Decor\" section",
                "Checking whether the page with the address \"" + data.getSecond() +  "\" opens after clicking the \"" + data.getFirst() + "\" link.");

        check("Home & Decor", data);
    }

    @Test(dataProvider = "mainMenuSale", dataProviderClass = Provider.class)
    void sale(Pair<String, String> data) {

        ExtentReportsManager.createTest("Clicking the \"" + data.getFirst() + "\" link in the \"Sale\" section",
                "Checking whether the page with the address \"" + data.getSecond() +  "\" opens after clicking the \"" + data.getFirst() + "\" link.");

        check("Sale", data);
    }

    @Test(dataProvider = "mainMenuVIP", dataProviderClass = Provider.class)
    void vip(String expectedURL) {

        ExtentReportsManager.createTest("Clicking the \"VIP\" link in the \"CONNECT WITH US\" section",
                "Checking whether the page with the address \"" + expectedURL +  "\" opens after clicking the \"VIP\" link.");

        header.getMainMenu().clickVip();

        Assert.assertEquals(getPage().url(), expectedURL,
                "The page with address \"" + expectedURL + "\" has not been opened");
    }
}
