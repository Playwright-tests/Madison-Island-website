package tests.mainmenu.womendropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.WomenDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class ExpandingAndCollapsingTest extends BaseTest {

    private WomenDropdownList womenDropdownList;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        womenDropdownList = new WomenDropdownList(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        womenDropdownList = new WomenDropdownList(getPage());
        womenDropdownList.hoverTriggerElement();
    }

    @Test(groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Expanding")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Expanding the \"Women\" dropdown list")
    public void expandingDropdownList() {

        womenDropdownList.hoverTriggerElement();
        Assert.assertTrue(womenDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(dependsOnMethods = "expandingDropdownList", groups = "withExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Collapsing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Collapsing the \"Women\" dropdown list")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(womenDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
