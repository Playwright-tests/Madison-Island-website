package qa.pageobject.footer;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class CompanyLinks extends FooterLinksSection {

    public CompanyLinks(Page page) {

        super(page);
    }

    @Step("Click the \"About Us\" link")
    public void clickAboutUsLink() {

        clickLink("About Us");
    }

    @Step("Click the \"Contact Us\" link")
    public void clickContactUsLink() {

        clickLink("Contact Us");
    }

    @Step("Click the \"Customer Service\" link")
    public void clickCustomerServiceLink() {

        clickLink("Customer Service");
    }

    @Step("Click the \"Privacy Policy\" link")
    public void clickPrivacyPolicyLink() {

        clickLink("Privacy Policy");
    }
}
