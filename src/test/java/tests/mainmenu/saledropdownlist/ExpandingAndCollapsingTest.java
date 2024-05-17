package tests.mainmenu.saledropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.SaleDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class ExpandingAndCollapsingTest extends BaseTest {

    private SaleDropdownList saleDropdownList;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        saleDropdownList = new SaleDropdownList(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        saleDropdownList = new SaleDropdownList(getPage());
        saleDropdownList.hoverTriggerElement();
    }

    @Test(groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Expanding")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Expanding the \"Sale\" dropdown list")
    public void expandingDropdownList() {

        saleDropdownList.hoverTriggerElement();
        Assert.assertTrue(saleDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(dependsOnMethods = "expandingDropdownList", groups = "withExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Collapsing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Collapsing the \"Sale\" dropdown list")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(saleDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
