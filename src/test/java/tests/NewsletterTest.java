package tests;

import qa.dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.extentreportsmanager.ExtentReportsManager;
import qa.pageobject.sections.Footer;
import qa.base.BaseTest;
import qa.records.NewsletterData;


public class NewsletterTest extends BaseTest {

    private Footer footer;
    private final String homePageUrl = "http://demo-store.seleniumacademy.com/";
    private final String subPageUrl = "http://demo-store.seleniumacademy.com/newsletter/subscriber/new/";

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

        check(newsletterData.email(), subPageUrl);
    }

    @Test(dataProvider = "validationEmailField", dataProviderClass = Provider.class)
    public void validationEmailField(NewsletterData newsletterData) {

        ExtentReportsManager.createTest("\"" + newsletterData.email() + "\" as an incorrect email",
                "Checking whether a message about incorrect email format is displayed");

        check(newsletterData.email(), homePageUrl);

        Assert.assertNotEquals(footer.getNewsletterForm().getValidationMessage(), "",
                "No validation message");
        Assert.assertEquals(footer.getNewsletterForm().getValidationMessage(), newsletterData.validationMessage(),
                "Incorrect message content");
    }

    @Test(dataProvider = "newsletterEmptyEmailField", dataProviderClass = Provider.class)
    public void emptyEmailField(NewsletterData newsletterData) {

        ExtentReportsManager.createTest("Blank \"Email Address\" field",
                "Checking whether a message about an empty \"Email Address\" field is displayed");

        check(newsletterData.email(), homePageUrl);

        Assert.assertEquals(footer.getNewsletterForm().getAdviceRequiredEmailText(), newsletterData.validationMessage(),
                "Incorrect message content");
    }
}
