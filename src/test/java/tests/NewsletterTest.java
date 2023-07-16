package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.sections.Footer;
import qa.base.BaseTest;

public class NewsletterTest extends BaseTest {

    private static Footer footer;

    @BeforeAll
    public static void init() {

        footer = new Footer(getPage());
    }

    @Test
    public void incorrectName() {

        footer.getNewsletterForm().setName("@@#$");
    }

    @Test
    public void emptyNameField() {

        footer.getNewsletterForm().setName("");
    }

    @Test
    public void correctName() {

        footer.getNewsletterForm().setName("Paul");
    }
}
