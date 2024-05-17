package tests.mainmenu.homedecordropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.HomeAndDecorDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class ExpandingAndCollapsingTest extends BaseTest {

    private HomeAndDecorDropdownList homeAndDecorDropdownList;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        homeAndDecorDropdownList = new HomeAndDecorDropdownList(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        homeAndDecorDropdownList = new HomeAndDecorDropdownList(getPage());
        homeAndDecorDropdownList.hoverTriggerElement();
    }

    @Test(groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Expanding")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Expanding the \"Home & Decor\" dropdown list")
    public void expandingDropdownList() {

        homeAndDecorDropdownList.hoverTriggerElement();
        Assert.assertTrue(homeAndDecorDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(dependsOnMethods = "expandingDropdownList", groups = "withExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Collapsing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Collapsing the \"Home & Decor\" dropdown list")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(homeAndDecorDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
