package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.sections.Footer;
import qa.base.BaseTest;
import utils.Pair;
import static playwright.PlaywrightLauncher.*;

public class FooterLinksTest extends BaseTest {

    private Footer footer;

    public FooterLinksTest() { }

    @BeforeMethod
    public void create() {

        footer = new Footer(getPage());
    }

    private void check(String link, String expectedURL) {

        footer.getFooterLinks().clickElementList(link);
        Assert.assertEquals(getPage().url(), expectedURL);
    }

    @Test(dataProvider = "footerCompany", dataProviderClass = Provider.class)
    public void companySection(Pair<String, String> data) {

        check(data.getFirst(), data.getSecond());
    }

    @Test(dataProvider = "footerQuickLinks", dataProviderClass = Provider.class)
    public void quickLinksSection(Pair<String, String> data) {

        check(data.getFirst(), data.getSecond());
    }

    @Test(dataProvider = "footerAccount", dataProviderClass = Provider.class)
    public void accountSection(Pair<String, String> data) {

        check(data.getFirst(), data.getSecond());
    }

    @Test(dataProvider = "footerConnectWithUs", dataProviderClass = Provider.class)
    public void connectWithUsSection(Pair<String, String> data) {

        check(data.getFirst(), data.getSecond());
    }
}
