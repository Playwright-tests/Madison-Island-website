package tests.accountdropdownlist;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.header.AccountDropdownList;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("Expanding and collapsing the \"Account\" dropdown list")
public class ExpandingAndCollapsingTest extends BaseTest {

    private AccountDropdownList accountDropdownList;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        accountDropdownList = new AccountDropdownList(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        accountDropdownList = new AccountDropdownList(getPage());
        accountDropdownList.clickTriggerElement();
    }

    @Test(groups = "withoutExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Expanding")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("Expanding the \"Account\" dropdown list")
    public void expandingList() {

        clickAndCheckDropdownState(AccountDropdownList::clickTriggerElement, accountDropdownList, WaitForSelectorState.VISIBLE,
                accountDropdownList.getListSelector(), "expanded");
    }

    @Test(dependsOnMethods = "expandingList", groups = "withExpandedList")
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Dropdown list")
    @Tag("Collapsing")
    @Tag("Menu")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Description("Collapsing the \"Account\" dropdown list")
    public void collapsingList() {

        clickAndCheckDropdownState(AccountDropdownList::clickTriggerElement, accountDropdownList, WaitForSelectorState.HIDDEN,
                accountDropdownList.getListSelector(), "collapsed");
    }
}
