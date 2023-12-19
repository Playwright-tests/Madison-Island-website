package qa.dataProvider;

import org.testng.annotations.DataProvider;
import qa.json.JSONReader;


public class Provider {

    @DataProvider(name = "accountDropdownList")
    public Object[] accountDropdownList() {

        return JSONReader.getLinks("accountDropdownList");
    }

    @DataProvider(name = "CR_correct")
    public Object[] CR_correct() {

        return JSONReader.getCredentials("correct");
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

        return JSONReader.getLinks("mainMenuVIP");
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

        return JSONReader.getProductData("correct");
    }

    @DataProvider(name = "QF_min")
    public Object[] QF_min() {

        return JSONReader.getProductData("min");
    }

    @DataProvider(name = "QF_aboveMin")
    public Object[] QF_aboveMin() {

        return JSONReader.getProductData("aboveMin");
    }

    @DataProvider(name = "QF_belowMax")
    public Object[] QF_belowMax() {

        return JSONReader.getProductData("belowMax");
    }

    @DataProvider(name = "QF_belowMaxSC")
    public Object[] QF_belowMaxSC() {

        return JSONReader.getProductData("belowMaxSC");
    }

    @DataProvider(name = "QF_max")
    public Object[] QF_max() {

        return JSONReader.getProductData("max");
    }

    @DataProvider(name = "QF_maxSC")
    public Object[] QF_maxSC() {

        return JSONReader.getProductData("maxSC");
    }

    @DataProvider(name = "QF_belowMin")
    public Object[] QF_belowMin() {

        return JSONReader.getProductData("belowMin");
    }

    @DataProvider(name = "QF_aboveMax")
    public Object[] QF_aboveMax() {

        return JSONReader.getProductData("aboveMax");
    }

    @DataProvider(name = "QF_aboveMaxSC")
    public Object[] QF_aboveMaxSC() {

        return JSONReader.getProductData("aboveMaxSC");
    }

    @DataProvider(name = "QF_negativeSC")
    public Object[] QF_negativeSC() {

        return JSONReader.getProductData("negativeSC");
    }

    @DataProvider(name = "QF_floatingPoint")
    public Object[] QF_floatingPoint() {

        return JSONReader.getProductData("floatingPoint");
    }

    @DataProvider(name = "QF_notANumber")
    public Object[] QF_notANumber() {

        return JSONReader.getProductData("notANumber");
    }

    @DataProvider(name = "QF_blank")
    public Object[] QF_blank() {

        return JSONReader.getProductData("withoutQuantity");
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
