package tests.newsletter;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.URLs;
import tests.base.BaseTest;
import qa.pageobject.footer.NewsletterForm;

@Epic("E2E")
public class InputTextValidationTest extends BaseTest {

    private NewsletterForm newsletterForm;

    @BeforeMethod
    public void prepare() {

        newsletterForm = new NewsletterForm(getPage());
    }

    @Test
    @Owner("Paweł Aksman")
    @Tag("Login form")
    @Tag("Fields")
    @Tag("Inputs")
    @Link(name = "Login page", url = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verification of the newsletter field text input")
    public void emailField() {

        String email = "example@gmail.com";
        Allure.parameter("Email", email);
        newsletterForm.setEmail(email);

        Assert.assertEquals(newsletterForm.getEmailFieldText(), email,
                "Incorrect input content");
    }
}
