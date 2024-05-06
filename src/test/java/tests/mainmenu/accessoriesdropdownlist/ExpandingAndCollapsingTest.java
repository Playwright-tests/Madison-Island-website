package tests.mainmenu.accessoriesdropdownlist;

import com.microsoft.playwright.Mouse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.AccessoriesDropdownList;
import tests.base.BaseTest;

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
    public void expandingDropdownList() {

        accessoriesDropdownList.hoverTriggerElement();
        Assert.assertTrue(accessoriesDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(groups = "withExpandedList")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(accessoriesDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
