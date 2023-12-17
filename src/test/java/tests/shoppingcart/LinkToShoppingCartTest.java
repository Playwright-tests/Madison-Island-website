package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.sections.Header;

public class LinkToShoppingCartTest extends BaseTest {

    @Test
    public void clickingTheLink() throws InterruptedException {

        ExtentReportsManager.createTest("Clicking the \"Cart\" link",
                "Checking whether the mini cart opens after clicking the \"Cart\" link.");

        Header header = new Header(getPage());
        header.clickShoppingCartLink();

        Assert.assertTrue(header.getMinicartWrapper().isVisible());
    }
}
