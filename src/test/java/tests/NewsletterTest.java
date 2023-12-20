package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.sections.Footer;
import qa.base.BaseTest;
import qa.records.NewsletterData;


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

    @Test(dataProvider = "newsletterCorrectEmail", dataProviderClass = Provider.class)
    public void correctEmail(NewsletterData newsletterData) {

        ExtentReportsManager.createTest("Signing up for the newsletter using valid email",
                "Checking whether the user will be subscribed to the newsletter using the correct email");

        check(newsletterData.getEmail(), URLs.NEWSLETTER_SUBSCRIPTION_PAGE.getName());
    }

    @Test(dataProvider = "validationEmailField", dataProviderClass = Provider.class)
    public void validationEmailField(NewsletterData newsletterData) {

        ExtentReportsManager.createTest("\"" + newsletterData.getEmail() + "\" as an incorrect email",
                "Checking whether a message about incorrect email format is displayed");

        check(newsletterData.getEmail(), URLs.HOME_PAGE.getName());

        Assert.assertNotEquals(footer.getNewsletterForm().getValidationMessage(), "",
                "No validation message");
        Assert.assertEquals(footer.getNewsletterForm().getValidationMessage(), newsletterData.getValidationMessage(),
                "Incorrect message content");
    }

    @Test(dataProvider = "newsletterEmptyEmailField", dataProviderClass = Provider.class)
    public void emptyEmailField(NewsletterData newsletterData) {

        ExtentReportsManager.createTest("Blank \"Email Address\" field",
                "Checking whether a message about an empty \"Email Address\" field is displayed");

        check(newsletterData.getEmail(), URLs.HOME_PAGE.getName());

        Assert.assertEquals(footer.getNewsletterForm().getAdviceRequiredEmailText(), newsletterData.getValidationMessage(),
                "Incorrect message content");
    }
}
