package tests.footer.newsletter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.NewsletterDataProviders;
import qa.enums.URLs;
import qa.pageobject.sections.Footer;
import qa.base.BaseTest;
import qa.records.NewsletterData;
import qa.support.dataprovidernames.DataProviderNames;

public class NewsletterTest extends BaseTest {

    private Footer footer;

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
