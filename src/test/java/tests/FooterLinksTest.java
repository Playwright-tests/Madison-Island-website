package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.sections.Footer;
import qa.base.BaseTest;

public class FooterLinksTest extends BaseTest {

    private static Footer footer;

    public FooterLinksTest() { }

    @BeforeAll
    public static void init() {

        footer = new Footer(getPage());
    }

    /*@Test
    public void incorrectNewsletterName() {

        footer.setNewsletterName("@#$#324");
    }*/

    private void clickElementLink(String[] links) {

        for (String link : links) {

            footer.getFooterLinks().clickElementList(link);
            getPage().goBack();
        }
    }

    @Test
    public void companySection() {

        String[] links = { "About Us", "Contact Us", "Customer Service", "Privacy Policy" };
        clickElementLink(links);
    }

    @Test
    public void quickLinksSection() {

        String[] links = { "Site Map", "Search Terms", "Advanced Search" };
        clickElementLink(links);
    }

    @Test
    public void accountSection() {

        String[] links = { "My Account", "Orders and Returns" };
        clickElementLink(links);
    }

    @Test
    public void connectWithUsSection() {

        String[] links = { "Facebook", "Twitter", "Youtube", "Pinterest", "RSS" };
        clickElementLink(links);
    }
}
