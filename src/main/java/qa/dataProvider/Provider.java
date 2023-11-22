package qa.dataProvider;

import org.testng.annotations.DataProvider;
import qa.json.JSONReader;


public class Provider {

    @DataProvider(name = "accountDropdownList")
    public Object[] accountDropdownList() {

        return JSONReader.getLinks("accountDropdownList");
    }

    @DataProvider(name = "incorrectEmail")
    public Object[] incorrectEmail() {

        return JSONReader.getCredentials("incorrectEmail");
    }

    @DataProvider(name = "emptyEmailField")
    public Object[] emptyEmailField() {

        return JSONReader.getCredentials("emptyEmailField");
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() {

        return JSONReader.getCredentials("incorrectPassword");
    }

    @DataProvider(name = "emptyPasswordField")
    public Object[] emptyPasswordField() {

        return JSONReader.getCredentials("emptyPasswordField");
    }

    @DataProvider(name = "credentialsValidationEmailField")
    public Object[] credentialsValidationEmailField() {

        return JSONReader.getCredentials("validationEmailField");
    }

    @DataProvider(name = "mainMenuWomen")
    public Object[] mainMenuWomen() {

        return JSONReader.getLinks("mainMenuWomen");
    }

    @DataProvider(name = "mainMenuMen")
    public Object[] mainMenuMen() {

        return JSONReader.getLinks("mainMenuMen");
    }

    @DataProvider(name = "mainMenuAccessories")
    public Object[] mainMenuAccessories() {

        return JSONReader.getLinks("mainMenuAccessories");
    }

    @DataProvider(name = "mainMenuHomeDecor")
    public Object[] mainMenuHomeDecor() {

        return JSONReader.getLinks("mainMenuHomeDecor");
    }

    @DataProvider(name = "mainMenuSale")
    public Object[] mainMenuSale() {

        return JSONReader.getLinks("mainMenuSale");
    }

    @DataProvider(name = "mainMenuVIP")
    public Object[] mainMenuVIP() {

        return JSONReader.getLinks("mainMenuVip");
    }

    @DataProvider(name = "sideMenu")
    public Object[] sideMenu() {

        return JSONReader.getLinks("sideMenu");
    }

    @DataProvider(name = "footerCompany")
    public Object[] footerCompany() {

        return JSONReader.getLinks("footerCompany");

    }

    @DataProvider(name = "footerQuickLinks")
    public Object[] footerQuickLinks() {

        return JSONReader.getLinks("footerQuickLinks");
    }

    @DataProvider(name = "footerAccount")
    public Object[] footerAccount() {

        return JSONReader.getLinks("footerAccount");
    }

    @DataProvider(name = "footerConnectWithUs")
    public Object[] footerConnectWithUs() {

        return JSONReader.getLinks("footerConnectWithUs");
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

    @DataProvider(name = "validationEmailField")
    public Object[] validationEmailField() {

        return JSONReader.getNewsletterData("validationEmailField");
    }

    @DataProvider(name = "newsletterCorrectEmail")
    public Object[] newsletterCorrectEmail() {

        return JSONReader.getNewsletterData("correctEmail");
    }

    @DataProvider(name = "newsletterEmptyEmailField")
    public Object[] newsletterEmptyEmailField() {

        return JSONReader.getNewsletterData("emptyEmailField");
    }

    @DataProvider(name = "promos")
    public Object[] promos() {

        return JSONReader.getLinks("promos");
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

    @DataProvider(name = "incorrectCouponCode")
    public Object[] incorrectCouponCode() {

        return JSONReader.get("couponCode", "incorrect");
    }

    @DataProvider(name = "ESF_correct")
    public Object[] ESF_correct() {

        return JSONReader.getEstimatedShippingData("correct");
    }

    @DataProvider(name = "ESF_incorrectState")
    public Object[] ESF_incorrectState() {

        return JSONReader.getEstimatedShippingData("incorrectState");
    }

    @DataProvider(name = "ESF_incorrectCity")
    public Object[] ESF_incorrectCity() {

        return JSONReader.getEstimatedShippingData("incorrectCity");
    }

    @DataProvider(name = "ESF_incorrectPostcode")
    public Object[] ESF_incorrectPostcode() {

        return JSONReader.getEstimatedShippingData("incorrectPostcode");
    }

    @DataProvider(name = "ESF_withoutState")
    public Object[] ESF_withoutState() {

        return JSONReader.getEstimatedShippingData("withoutState");
    }

    @DataProvider(name = "ESF_withoutCity")
    public Object[] ESF_withoutCity() {

        return JSONReader.getEstimatedShippingData("withoutCity");
    }

    @DataProvider(name = "ESF_withoutPostcode")
    public Object[] ESF_withoutPostcode() {

        return JSONReader.getEstimatedShippingData("withoutPostcode");
    }
}
