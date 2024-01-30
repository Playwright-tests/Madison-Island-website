package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import qa.dataProviders.PromosDataProvider;
import qa.enums.DataDownloadMode;
import qa.exceptions.MockarooRequestException;
import qa.support.dataprovidernames.DataProviderNames;
import qa.pageobject.components.Promos;
import qa.base.BaseTest;
import qa.records.LinkData;
import qa.support.testdatafilenames.TestdataFileNames;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class PromosTest extends BaseTest {

    private Promos promos;

    @BeforeSuite
    public void loadTestdata() throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        PromosDataProvider.loadTestdata(TestdataFileNames.LINKS, DataDownloadMode.LOCAL);
    }

    @AfterSuite
    public void clearTestdata() {

        PromosDataProvider.clear();
    }

    @BeforeMethod
    public void create() {

        promos = new Promos(getPage());
    }

    @Test(dataProvider = DataProviderNames.PROMOS, dataProviderClass = PromosDataProvider.class)
    public void images(LinkData linkData) {

        promos.clickImage(linkData.getLink());

        Assert.assertEquals(getPage().url(), linkData.getUrl(),
                "The page with address \"" + linkData.getUrl() + "\" has not been opened");
    }
}
