package tests.base;

import lombok.Setter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import qa.pageobject.header.MainMenu;

public class MainMenuBaseTest extends BaseTest {

    private MainMenu mainMenu;
    @Setter
    private String triggerElement;

    @BeforeMethod(onlyForGroups = "withoutExpandedList")
    public void prepareWithoutExpandedList() {

        mainMenu = new MainMenu(getPage());
    }

    @BeforeMethod(onlyForGroups = "withExpandedList")
    public void prepareWithExpandedList() {

        mainMenu = new MainMenu(getPage());
        mainMenu.hoverTriggerElement(triggerElement);
    }

    protected void actions(String link, String expectedUrl) {

        mainMenu.clickItem(link);
        Assert.assertEquals(getPage().url(), expectedUrl, "Incorrect url");
    }
}
