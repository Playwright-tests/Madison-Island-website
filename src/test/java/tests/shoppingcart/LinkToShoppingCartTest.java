package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.sections.Header;

public class LinkToShoppingCartTest extends BaseTest {

    @Test
    public void clickingTheLink() {

        Header header = new Header(getPage());
        header.clickShoppingCartLink();

        Assert.assertTrue(header.getMinicartWrapper().isVisible());
    }
}
