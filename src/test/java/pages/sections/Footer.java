package pages.sections;

import com.microsoft.playwright.Page;
import pages.components.FooterLinks;
import pages.components.NewsletterForm;
import qa.base.BasePage;

public class Footer extends BasePage {

    FooterLinks footerLinks;
    NewsletterForm newsletterForm;

    public Footer(Page page) {

        super(page);

        footerLinks = new FooterLinks(getPage());
        newsletterForm = new NewsletterForm(getPage());
    }

    public FooterLinks getFooterLinks() {

        return footerLinks;
    }

    public NewsletterForm getNewsletterForm() {

        return newsletterForm;
    }
}
