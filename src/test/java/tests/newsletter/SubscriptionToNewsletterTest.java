package tests.newsletter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.NewsletterDataProviders;
import qa.pageobject.footer.NewsletterForm;
import qa.support.URLs;
import tests.base.BaseTest;
import qa.support.dataprovidernames.DataProviderNames;

public class SubscriptionToNewsletterTest extends BaseTest {

    private NewsletterForm newsletterForm;

    @BeforeMethod
    public void prepare() {

        newsletterForm = new NewsletterForm(getPage());
    }

    private void actions(String email, String expectedURL) {

        newsletterForm
                .setEmail(email)
                .clickSubscribeButton();

        Assert.assertEquals(getPage().url(), expectedURL,
                "Incorrect url");
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = NewsletterDataProviders.class)
    public void correctEmail(String email) {

        actions(email, URLs.NEWSLETTER_SUBSCRIPTION_PAGE);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_EMAIL_FORMAT, dataProviderClass = NewsletterDataProviders.class)
    public void incorrectEmailFormat(String email) {

        actions(email, URLs.HOME_PAGE);

        Assert.assertNotEquals(newsletterForm.getValidationMessage(), "",
                "No validation message");
    }

    @Test
    public void emptyEmailField() {

        newsletterForm.clickSubscribeButton();

        Assert.assertNotEquals(newsletterForm.getAdviceRequiredEmailText(), "",
                "Incorrect message content");
    }
}
