package tests.header.minicart;

import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.minicart.MiniCart;
import tests.base.BaseTest;
import qa.pageobject.sections.Header;

public class ExpandingAndCollapsingMiniCartTest extends BaseTest {

    private Header header;
    private MiniCart miniCart;

    @BeforeMethod(onlyForGroups = "withoutExpandedMiniCart")
    public void prepareWithoutExpandedWrapper() {

        header = new Header(getPage());
        miniCart = new MiniCart(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedMiniCart")
    public void prepareWithExpandedWrapper() {

        header = new Header(getPage());
        miniCart = new MiniCart(getPage());
        header.clickShoppingCartLink();
    }

    @Test(groups = "withoutExpandedMiniCart")
    public void expandingMiniCart() {

        clickAndCheckDropdownState(Header::clickShoppingCartLink, header, WaitForSelectorState.VISIBLE,
                miniCart.getWrapperSelector(), "expanded");
    }

    @Test(groups = "withExpandedMiniCart")
    public void collapsingMiniCart() {

        clickAndCheckDropdownState(Header::clickShoppingCartLink, header, WaitForSelectorState.HIDDEN,
                miniCart.getWrapperSelector(), "collapsed");
    }
}
