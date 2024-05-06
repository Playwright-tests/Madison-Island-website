package tests.mainmenu.womendropdownlist;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.WomenDropdownList;
import tests.base.BaseTest;

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
    public void expandingDropdownList() {

        womenDropdownList.hoverTriggerElement();
        Assert.assertTrue(womenDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(groups = "withExpandedList")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(womenDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
