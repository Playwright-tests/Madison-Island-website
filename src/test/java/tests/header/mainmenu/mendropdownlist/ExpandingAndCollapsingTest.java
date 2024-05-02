package tests.header.mainmenu.mendropdownlist;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.mainmenu.MenDropdownList;
import tests.base.BaseTest;

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
    public void expandingDropdownList() {

        menDropdownList.hoverTriggerElement();
        Assert.assertTrue(menDropdownList.isListVisible(), "The dropdown list has not been expanded");
    }

    @Test(groups = "withExpandedList")
    public void collapsingDropdownList() {

        getPage().mouse().move(0, -100);
        Assert.assertFalse(menDropdownList.isListVisible(), "The dropdown list has not been collapsed");
    }
}
