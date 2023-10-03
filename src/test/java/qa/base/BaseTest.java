package qa.base;

import org.testng.annotations.*;
import utils.JSONReader;
import playwright.PlaywrightLauncher;

public class BaseTest {

    @BeforeClass
    public void init() {

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
