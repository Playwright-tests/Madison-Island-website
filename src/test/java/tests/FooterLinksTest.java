package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import qa.dataProviders.FooterDataProviders;
import qa.enums.DataDownloadMode;
import qa.exceptions.MockarooRequestException;
import qa.support.dataprovidernames.DataProviderNames;
import qa.pageobject.sections.Footer;
import qa.base.BaseTest;
import qa.records.LinkData;
import qa.support.testdatafilenames.TestdataFileNames;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class FooterLinksTest extends BaseTest {

    private Footer footer;

    @BeforeSuite
    public void loadTestdata() throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        FooterDataProviders.loadTestdata(TestdataFileNames.LINKS, DataDownloadMode.LOCAL);
    }

    @AfterSuite
    public void clearTestdata() {

        FooterDataProviders.clear();
    }

    @BeforeMethod
    public void create() {

        footer = new Footer(getPage());
    }

    private void check(LinkData linkData) {

        footer.getFooterLinks().clickElementList(linkData.getLink());
        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }

    @Test(dataProvider = DataProviderNames.COMPANY, dataProviderClass = FooterDataProviders.class)
    public void companySection(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = DataProviderNames.QUICK_LINKS, dataProviderClass = FooterDataProviders.class)
    public void quickLinksSection(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = DataProviderNames.ACCOUNT, dataProviderClass = FooterDataProviders.class)
    public void accountSection(LinkData linkData) {

        check(linkData);
    }

    @Test(dataProvider = DataProviderNames.CONNECT_WITH_US, dataProviderClass = FooterDataProviders.class)
    public void connectWithUsSection(LinkData linkData) {

        check(linkData);
    }
}
