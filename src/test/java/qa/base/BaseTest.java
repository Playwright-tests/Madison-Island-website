package qa.base;

import org.testng.annotations.BeforeTest;
import utils.JSONReader;
import playwright.PlaywrightLauncher;

public class BaseTest {

    @BeforeTest
    public void launch() {

        PlaywrightLauncher.launch();

        JSONReader.read();
    }
}
