package qa.pageobject.sections;

import com.microsoft.playwright.Page;
import qa.pageobject.components.FooterLinks;
import qa.pageobject.components.NewsletterForm;
import qa.base.BasePage;

public class Footer extends BasePage {

    private final FooterLinks footerLinks;
    private final NewsletterForm newsletterForm;

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
