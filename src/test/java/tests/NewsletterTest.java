package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.sections.Footer;
import playwright.PlaywrightLauncher;
import qa.base.BaseTest;
import static playwright.PlaywrightLauncher.*;

public class NewsletterTest extends BaseTest {

    private Footer footer;
    private final String subPageUrl = "http://demo-store.seleniumacademy.com/newsletter/subscriber/new/";

    @BeforeMethod
    public void create() {

        footer = new Footer(PlaywrightLauncher.getPage());
    }

    private void check(String email, String expectedURL) {

        footer.getNewsletterForm().setEmail(email);
        footer.getNewsletterForm().clickSubscribeButton();

        Assert.assertEquals(getPage().url(), expectedURL);
    }

    @Test(dataProvider = "newsletterCorrectEmail", dataProviderClass = Provider.class)
    public void correctEmail(String email) {

        check(email, subPageUrl);
    }

    @Test(dataProvider = "newsletterIncorrectEmail", dataProviderClass = Provider.class)
    public void incorrectEmail(String email) {

        check(email, getUrl());
    }

    @Test
    public void emptyEmailField() {

        check("", getUrl());

        Assert.assertEquals(footer.getNewsletterForm().getAdviceRequiredEmailText(), "This is a required field.");
    }
}
