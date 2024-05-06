package tests.mainmenu.homedecordropdownlist;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.AccessoriesDropdownList;
import qa.mainmenu.HomeAndDecorDropdownList;
import tests.base.BaseTest;

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
    public void expandingDropdownList() {

        homeAndDecorDropdownList.hoverTriggerElement();
        Assert.assertTrue(homeAndDecorDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(groups = "withExpandedList")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(homeAndDecorDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
