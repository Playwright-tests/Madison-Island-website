package tests.mainmenu.accessoriesdropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.AccessoriesDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class ExpandingAndCollapsingTest extends BaseTest {

    private AccessoriesDropdownList accessoriesDropdownList;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        accessoriesDropdownList = new AccessoriesDropdownList(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        accessoriesDropdownList = new AccessoriesDropdownList(getPage());
        accessoriesDropdownList.hoverTriggerElement();
    }

    @Test(groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Expanding")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Expanding the \"Accessories\" dropdown list")
    public void expandingDropdownList() {

        accessoriesDropdownList.hoverTriggerElement();
        Assert.assertTrue(accessoriesDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(dependsOnMethods = "expandingDropdownList", groups = "withExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Collapsing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Collapsing the \"Accessories\" dropdown list")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(accessoriesDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
