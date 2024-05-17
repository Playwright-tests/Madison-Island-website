package tests.mainmenu.mendropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.mainmenu.MenDropdownList;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class ExpandingAndCollapsingTest extends BaseTest {

    private MenDropdownList menDropdownList;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        menDropdownList = new MenDropdownList(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        menDropdownList = new MenDropdownList(getPage());
        menDropdownList.hoverTriggerElement();
    }

    @Test(groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Expanding")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Expanding the \"Men\" dropdown list")
    public void expandingDropdownList() {

        menDropdownList.hoverTriggerElement();
        Assert.assertTrue(menDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(dependsOnMethods = "expandingDropdownList", groups = "withExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Collapsing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Collapsing the \"Men\" dropdown list")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(menDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
