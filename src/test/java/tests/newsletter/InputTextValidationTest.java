package tests.newsletter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.pageobject.footer.NewsletterForm;

public class InputTextValidationTest extends BaseTest {

    private NewsletterForm newsletterForm;

    @BeforeMethod
    public void prepare() {

        newsletterForm = new NewsletterForm(getPage());
    }

    @Test
    public void emailField() {

        String email = "example@gmail.com";
        newsletterForm.setEmail(email);

        Assert.assertEquals(newsletterForm.getEmailFieldText(), email,
                "Incorrect input content");
    }
}
