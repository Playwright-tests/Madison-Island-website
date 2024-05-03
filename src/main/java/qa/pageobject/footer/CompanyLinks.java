package qa.pageobject.footer;

import com.microsoft.playwright.Page;

public class CompanyLinks extends FooterLinksSection {

    public CompanyLinks(Page page) {

        super(page);
    }

    public void clickAboutUsLink() {

        clickLink("About Us");
    }

    public void clickContactUsLink() {

        clickLink("Contact Us");
    }

    public void clickCustomerServiceLink() {

        clickLink("Customer Service");
    }

    public void clickPrivacyPolicyLink() {

        clickLink("Privacy Policy");
    }
}
