package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.sections.Footer;
import qa.base.BaseTest;

public class FooterLinksTest extends BaseTest {

    private static Footer footer;

    public FooterLinksTest() { }

    @BeforeClass
    public void init() {

        footer = new Footer(getPage());
    }

    private void check(String[] links, String[] expectedResults) {

        Assert.assertEquals(links.length, expectedResults.length);

        for (int i = 0; i < links.length; i++) {

            footer.getFooterLinks().clickElementList(links[i]);
            String currentURL = getPage().url();

            getPage().goBack();
            Assert.assertEquals(currentURL, expectedResults[i]);
        }
    }

    @Test(dataProvider = "footerCompany", dataProviderClass = Provider.class)
    public void companySection(String[] data) {

        String[] links = { "About Us", "Contact Us", "Customer Service", "Privacy Policy" };
        check(links, data);
    }

    @Test(dataProvider = "footerQuickLinks", dataProviderClass = Provider.class)
    public void quickLinksSection(String[] data) {

        String[] links = { "Site Map", "Search Terms", "Advanced Search" };
        check(links, data);
    }

    @Test(dataProvider = "footerAccount", dataProviderClass = Provider.class)
    public void accountSection(String[] data) {

        String[] links = { "My Account", "Orders and Returns" };
        check(links, data);
    }

    @Test(dataProvider = "footerConnectWithUs", dataProviderClass = Provider.class)
    public void connectWithUsSection(String[] data) {

        String[] links = { "Facebook", "Twitter", "Youtube", "Pinterest"};
        check(links, data);
    }
}
