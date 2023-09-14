package dataProvider;

import org.testng.annotations.DataProvider;
import utils.JSONReader;
import utils.Pair;

import java.util.List;

public class Provider {

    @DataProvider(name = "incorrectEmail")
    public Object[] incorrectEmail() {

        List<Pair<String, String>> data = JSONReader.get("login", "incorrectEmail", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "emptyEmailField")
    public Object[] emptyEmailField() {

        List<Pair<String, String>> data = JSONReader.get("login", "emptyEmailField", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() {

        List<Pair<String, String>> data = JSONReader.get("login", "incorrectPassword", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "emptyPasswordField")
    public Object[] emptyPasswordField() {

        List<Pair<String, String>> data = JSONReader.get("login", "emptyPasswordField", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "mainMenuWomen")
    public Object[] mainMenuWomen() {

        String[] data = JSONReader.get("URLs", "mainMenuWomen");

        return new Object[] {data};
    }

    @DataProvider(name = "mainMenuMen")
    public Object[] mainMenuMen() {

        String[] data = JSONReader.get("URLs", "mainMenuMen");

        return new Object[] {data};
    }

    @DataProvider(name = "mainMenuAccessories")
    public Object[] mainMenuAccessories() {

        String[] data = JSONReader.get("URLs", "mainMenuAccessories");

        return new Object[] {data};
    }

    @DataProvider(name = "mainMenuHomeDecor")
    public Object[] mainMenuHomeDecor() {

        String[] data = JSONReader.get("URLs", "mainMenuHomeDecor");

        return new Object[] {data};
    }

    @DataProvider(name = "mainMenuSale")
    public Object[] mainMenuSale() {

        String[] data = JSONReader.get("URLs", "mainMenuSale");

        return new Object[] {data};
    }

    @DataProvider(name = "mainMenuVIP")
    public Object[] mainMenuVIP() {

        String[] data = JSONReader.get("URLs", "mainMenuVIP");

        return new Object[] {data};
    }

    @DataProvider(name = "footerCompany")
    public Object[] footerCompany() {

        String[] data = JSONReader.get("URLs", "footer_1");

        return new Object[] {data};
    }

    @DataProvider(name = "footerQuickLinks")
    public Object[] footerQuickLinks() {

        String[] data = JSONReader.get("URLs", "footer_2");

        return new Object[] {data};
    }

    @DataProvider(name = "footerAccount")
    public Object[] footerAccount() {

        String[] data = JSONReader.get("URLs", "footer_3");

        return new Object[] {data};
    }

    @DataProvider(name = "footerConnectWithUs")
    public Object[] footerConnectWithUs() {

        String[] data = JSONReader.get("URLs", "footer_4");

        return new Object[] {data};
    }

    @DataProvider(name = "searchEngineCorrectPhrase")
    public Object[] searchEngineCorrectPhrase() {

        String[] data = JSONReader.get("searchEngine", "correctPhrase");

        return new Object[] {data};
    }

    @DataProvider(name = "searchEngineCorrectPhraseUpperLower")
    public Object[] searchEngineCorrectPhraseUpperLower() {

        String[] data = JSONReader.get("searchEngine", "correctPhraseUpperLower");

        return new Object[] {data};
    }

    @DataProvider(name = "searchEngineIncorrectPhrase")
    public Object[] searchEngineIncorrectPhrase() {

        String[] data = JSONReader.get("searchEngine", "incorrectPhrase");

        return new Object[] {data};
    }
}
