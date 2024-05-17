package tests.footerlinks;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.CompanyLinks;
import qa.support.URLs;
import tests.base.BaseTest;

@Epic("E2E")
public class CompanyLinksTest extends BaseTest {

    private CompanyLinks companyLinks;

    @BeforeMethod
    public void prepare() {

        companyLinks = new CompanyLinks(getPage());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Feature("The \"About Us\" link")
    public void aboutUsLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickAboutUsLink, companyLinks, URLs.ABOUT_US_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Feature("The \"Contact Us Us\" link")
    public void contactUsLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickContactUsLink, companyLinks, URLs.CONTACT_US_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Feature("The \"Customer Service\" link")
    public void customerServiceLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickCustomerServiceLink, companyLinks, URLs.CUSTOMER_SERVICE_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Links")
    @Tag("Footer")
    @Link(name = "Home page", url = "http://demo-store.seleniumacademy.com/")
    @Feature("The \"Privacy Policy\" link")
    public void privacyPolicyLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickPrivacyPolicyLink, companyLinks, URLs.PRIVACY_POLICY_PAGE);
    }
}
