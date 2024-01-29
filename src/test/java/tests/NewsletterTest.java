package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.NewsletterDataProviders;
import qa.enums.DataDownloadMode;
import qa.enums.URLs;
import qa.exceptions.MockarooRequestException;
import qa.pageobject.sections.Footer;
import qa.base.BaseTest;
import qa.records.NewsletterData;
import qa.support.dataprovidernames.DataProviderNames;
import qa.support.testdatafilenames.TestdataFileNames;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class NewsletterTest extends BaseTest {

    private Footer footer;

    @BeforeSuite
    public void loadTestdata() throws MalformedURLException, FileNotFoundException, URISyntaxException, MockarooRequestException {

        NewsletterDataProviders.loadTestdata(TestdataFileNames.NEWSLETTER, DataDownloadMode.LOCAL);
    }

    @AfterSuite
    public void clearTestdata() {

        NewsletterDataProviders.clear();
    }

    @BeforeMethod
    public void create() {

        footer = new Footer(getPage());
    }

    private void check(String email, String expectedURL) {

        footer.getNewsletterForm().setEmail(email);
        footer.getNewsletterForm().clickSubscribeButton();

        Assert.assertEquals(getPage().url(), expectedURL,
                "Incorrect url");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = NewsletterDataProviders.class)
    public void correctEmail(NewsletterData newsletterData) {

        check(newsletterData.getEmail(), URLs.NEWSLETTER_SUBSCRIPTION_PAGE.getName());
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_EMAIL_FORMAT, dataProviderClass = NewsletterDataProviders.class)
    public void incorrectEmailFormat(NewsletterData newsletterData) {

        check(newsletterData.getEmail(), URLs.HOME_PAGE.getName());

        Assert.assertNotEquals(footer.getNewsletterForm().getValidationMessage(), "",
                "No validation message");
    }

    @Test
    public void emptyEmailField() {

        footer.getNewsletterForm().clickSubscribeButton();

        Assert.assertNotEquals(footer.getNewsletterForm().getAdviceRequiredEmailText(), "",
                "Incorrect message content");
    }
}
