package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.sections.Header;
import qa.base.BaseTest;

public class SearchEngineTest extends BaseTest {

    private static Header header;

    @BeforeAll
    public static void init() {

        header = new Header(getPage());
    }

    @Test
    public void correctPhrase() {

        header.getSearchEngine().setPhrase("Blouse");
        header.getSearchEngine().clickSearchButton();
    }
}
