package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import pages.sections.Footer;
import qa.base.BaseTest;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.function.Consumer;

public class NewsletterTest extends BaseTest {

    private static Footer footer;

    @BeforeClass
    public static void init() {

        footer = new Footer(getPage());
    }

    private void check(String[] emails, Consumer<Footer> consumer) {

        for (String email: emails) {

            footer.getNewsletterForm().setEmail(email);
            footer.getNewsletterForm().clickSubscribeButton();

            consumer.accept(footer);
        }
    }

    @Test(dataProvider = "newsletterIncorrectEmail", dataProviderClass = Provider.class)
    public void incorrectName(String[] emails) {


    }

    @Test(dataProvider = "newsletterEmptyEmailField", dataProviderClass = Provider.class)
    public void emptyNameField(String[] emails) {

        check(emails, (Footer f)->{assertThat(f.getNewsletterForm().getAdviceRequiredEmail()).isVisible();});
    }

    @Test(dataProvider = "newsletterCorrectEmail", dataProviderClass = Provider.class)
    public void correctName(String[] emails) {

        check(emails, (Footer f)->{Assert.assertEquals(f.getNewsletterForm().getEmailFieldText(), "");});
    }
}
