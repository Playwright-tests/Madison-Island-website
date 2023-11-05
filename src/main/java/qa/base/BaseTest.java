package qa.base;

import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import qa.utils.JSONReader;
import qa.playwright.PlaywrightLauncher;

import java.io.IOException;

public class BaseTest {

    @BeforeClass
    public void init() throws IOException, ParseException {

        JSONReader.read();
    }

    @BeforeMethod
    public void launch() {

        PlaywrightLauncher.launch();
    }

    @AfterMethod
    public void tearDown() {

        PlaywrightLauncher.close();
    }
}
