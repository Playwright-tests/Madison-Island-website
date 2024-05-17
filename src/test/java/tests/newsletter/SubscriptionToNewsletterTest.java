package tests.newsletter;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataProviders.NewsletterDataProviders;
import qa.pageobject.footer.NewsletterForm;
import qa.support.URLs;
import tests.base.BaseTest;
import qa.support.DataProviderNames;

@Epic("E2E")
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

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = NewsletterDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Subscribing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Subscribing to the newsletter using correct email")
    public void correctEmail(String email) {

        Allure.parameter("Email", email);
        actions(email, URLs.NEWSLETTER_SUBSCRIPTION_PAGE);
    }

    @Test(priority = 2, dataProvider = DataProviderNames.INCORRECT_EMAIL_FORMAT, dataProviderClass = NewsletterDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Subscribing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("Attempting to subscribe to the newsletter using an incorrect email format")
    public void incorrectEmailFormat(String email) {

        Allure.parameter("Email", email);
        actions(email, URLs.HOME_PAGE);

        Assert.assertNotEquals(newsletterForm.getValidationMessage(), "",
                "No validation message");
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Newsletter form")
    @Tag("Subscribing")
    @Link(name = "Home page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.MINOR)
    @Description("Attempting to subscribe to the newsletter without providing input for the email field")
    public void emptyEmailField() {

        newsletterForm.clickSubscribeButton();

        Assert.assertNotEquals(newsletterForm.getAdviceRequiredEmailText(), "",
                "Incorrect message content");
    }
}
