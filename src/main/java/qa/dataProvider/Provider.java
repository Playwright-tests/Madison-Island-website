package qa.dataProvider;

import org.testng.annotations.DataProvider;
import qa.utils.JSONReader;
import qa.utils.Pair;

public class Provider {

    @DataProvider(name = "accountDropdownList")
    public Object[] accountDropdownList() {

        return JSONReader.get("URLs", "accountDropdownList", new Pair<>("button", "url"));
    }

    @DataProvider(name = "incorrectEmail")
    public Object[] incorrectEmail() {

        return JSONReader.get("login", "incorrectEmail", new Pair<>("email", "password"));
    }

    @DataProvider(name = "emptyEmailField")
    public Object[] emptyEmailField() {

        return JSONReader.get("login", "emptyEmailField", new Pair<>("email", "password"));
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() {

        return JSONReader.get("login", "incorrectPassword", new Pair<>("email", "password"));
    }

    @DataProvider(name = "emptyPasswordField")
    public Object[] emptyPasswordField() {

        return JSONReader.get("login", "emptyPasswordField", new Pair<>("email", "password"));
    }

    @DataProvider(name = "mainMenuWomen")
    public Object[] mainMenuWomen() {

        return JSONReader.get("URLs", "mainMenuWomen", new Pair<>("button", "url"));
    }

    @DataProvider(name = "mainMenuMen")
    public Object[] mainMenuMen() {

        return JSONReader.get("URLs", "mainMenuMen", new Pair<>("button", "url"));
    }

    @DataProvider(name = "mainMenuAccessories")
    public Object[] mainMenuAccessories() {

        return JSONReader.get("URLs", "mainMenuAccessories", new Pair<>("button", "url"));
    }

    @DataProvider(name = "mainMenuHomeDecor")
    public Object[] mainMenuHomeDecor() {

        return JSONReader.get("URLs", "mainMenuHomeDecor", new Pair<>("button", "url"));
    }

    @DataProvider(name = "mainMenuSale")
    public Object[] mainMenuSale() {

        return JSONReader.get("URLs", "mainMenuSale", new Pair<>("button", "url"));
    }

    @DataProvider(name = "mainMenuVIP")
    public Object[] mainMenuVIP() {

        return JSONReader.get("URLs", "mainMenuVIP");
    }

    @DataProvider(name = "footerCompany")
    public Object[] footerCompany() {

        return JSONReader.get("URLs", "footerCompany", new Pair<>("link", "url"));

    }

    @DataProvider(name = "footerQuickLinks")
    public Object[] footerQuickLinks() {

        return JSONReader.get("URLs", "footerQuickLinks", new Pair<>("link", "url"));
    }

    @DataProvider(name = "footerAccount")
    public Object[] footerAccount() {

        return JSONReader.get("URLs", "footerAccount", new Pair<>("link", "url"));
    }

    @DataProvider(name = "footerConnectWithUs")
    public Object[] footerConnectWithUs() {

        return JSONReader.get("URLs", "footerConnectWithUs", new Pair<>("link", "url"));
    }

    @DataProvider(name = "searchEngineCorrectPhrase")
    public Object[] searchEngineCorrectPhrase() {

        return JSONReader.get("searchEngine", "correctPhrase");
    }

    @DataProvider(name = "searchEngineCorrectPhraseUpperLower")
    public Object[] searchEngineCorrectPhraseUpperLower() {

        return JSONReader.get("searchEngine", "correctPhraseUpperLower");
    }

    @DataProvider(name = "searchEngineIncorrectPhrase")
    public Object[] searchEngineIncorrectPhrase() {

        return JSONReader.get("searchEngine", "incorrectPhrase");
    }

    @DataProvider(name = "newsletterIncorrectEmail")
    public Object[] newsletterIncorrectEmail() {

        return JSONReader.get("newsletter", "incorrectEmail");
    }

    @DataProvider(name = "newsletterCorrectEmail")
    public Object[] newsletterCorrectEmail() {

        return JSONReader.get("newsletter", "correctEmail");
    }

    @DataProvider(name = "promos")
    public Object[] promos() {

        return JSONReader.get("URLs", "promos", new Pair<>("altText", "url"));
    }

    @DataProvider(name = "correctProductData")
    public Object[] correctProductData() {

        return JSONReader.get("correctData");
    }

    @DataProvider(name = "incorrectQuantityValue")
    public Object[] incorrectQuantityValue() {

        return JSONReader.get("incorrectQuantityValue");
    }

    @DataProvider(name = "incorrectQuantityFormat")
    public Object[] incorrectQuantityFormat() {

        return JSONReader.get("incorrectQuantityFormat");
    }

    @DataProvider(name = "blankQuantityField")
    public Object[] blankQuantityField() {

        return JSONReader.get("blankQuantityField");
    }

    @DataProvider(name = "floatingPointNumber")
    public Object[] floatingPointNumber() {

        return JSONReader.get("quantityField", "floatingPointNumber");
    }

    @DataProvider(name = "notANumber")
    public Object[] notANumber() {

        return JSONReader.get("quantityField", "notANumber");
    }
}
