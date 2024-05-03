package tests.footer.links;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.CompanyLinks;
import qa.support.URLs;
import tests.base.BaseTest;

public class CompanyLinksTest extends BaseTest {

    private CompanyLinks companyLinks;

    @BeforeMethod
    public void prepare() {

        companyLinks = new CompanyLinks(getPage());
    }

    @Test
    public void aboutUsLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickAboutUsLink, companyLinks, URLs.ABOUT_US_PAGE);
    }

    @Test
    public void contactUsLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickContactUsLink, companyLinks, URLs.CONTACT_US_PAGE);
    }

    @Test
    public void customerServiceLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickCustomerServiceLink, companyLinks, URLs.CUSTOMER_SERVICE_PAGE);
    }

    @Test
    public void privacyPolicyLink() {

        clickAndVerifyPageUrl(CompanyLinks::clickPrivacyPolicyLink, companyLinks, URLs.PRIVACY_POLICY_PAGE);
    }
}
