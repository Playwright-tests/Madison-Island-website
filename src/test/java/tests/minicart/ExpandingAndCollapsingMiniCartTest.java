package tests.minicart;

import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.minicart.MiniCart;
import qa.support.URLs;
import tests.base.BaseTest;
import qa.pageobject.sections.Header;

@Epic("E2E")
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
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Expanding")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Expanding the mini cart")
    public void expandingMiniCart() {

        clickAndCheckDropdownState(Header::clickShoppingCartLink, header, WaitForSelectorState.VISIBLE,
                miniCart.getWrapperSelector(), "expanded");
    }

    @Test(dependsOnMethods = "expandingMiniCart", groups = "withExpandedMiniCart")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Collapsing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Collapsing the mini cart")
    public void collapsingMiniCart() {

        clickAndCheckDropdownState(Header::clickShoppingCartLink, header, WaitForSelectorState.HIDDEN,
                miniCart.getWrapperSelector(), "collapsed");
    }
}
