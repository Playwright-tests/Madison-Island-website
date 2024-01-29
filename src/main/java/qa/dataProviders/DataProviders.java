package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.json.JSONReader;
import qa.json.TestdataLoader;
import qa.support.jsonfilenames.Newsletter;
import qa.support.dataprovidernames.DataProviderNames;
import qa.support.jsonfilenames.Login;

import java.io.FileNotFoundException;
import java.io.IOException;


public class DataProviders {

    @DataProvider(name = DataProviderNames.ACCOUNT_DROPDOWN_LIST)
    public Object[] accountDropdownList() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.ACCOUNT_DROPDOWN_LIST);
    }

    @DataProvider(name = "CR_correct")
    public Object[] CR_correct() throws IOException {

        return new Object[]{TestdataLoader.getCredentials(Login.CORRECT)};
    }

    @DataProvider(name = "incorrectEmail")
    public Object[] incorrectEmail() throws IOException {

        return new Object[]{TestdataLoader.getCredentials(Login.INCORRECT_EMAIL)};
    }

    @DataProvider(name = "emptyEmailField")
    public Object[] emptyEmailField() throws IOException {

        return new Object[]{TestdataLoader.getCredentials(Login.BLANK_EMAIL_FIELD)};
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() throws IOException {

        return new Object[]{TestdataLoader.getCredentials(Login.INCORRECT_PASSWORD)};
    }

    @DataProvider(name = "emptyPasswordField")
    public Object[] emptyPasswordField() throws IOException {

        return new Object[]{TestdataLoader.getCredentials(Login.BLANK_PASSWORD_FIELD)};
    }

    @DataProvider(name = "credentialsValidationEmailField")
    public Object[] credentialsValidationEmailField() throws FileNotFoundException {

        return TestdataLoader.getCredentialsArray(Login.INCORRECT_EMAIL_FORMAT);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_WOMEN)
    public Object[] mainMenuWomen() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.MAIN_MENU_WOMEN);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_MEN)
    public Object[] mainMenuMen() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.MAIN_MENU_MEN);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_ACCESSORIES)
    public Object[] mainMenuAccessories() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.MAIN_MENU_ACCESSORIES);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_HOME_DECOR)
    public Object[] mainMenuHomeDecor() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.MAIN_MENU_HOME_DECOR);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_SALE)
    public Object[] mainMenuSale() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.MAIN_MENU_SALE);
    }

    @DataProvider(name = DataProviderNames.MAIN_MENU_VIP)
    public Object[] mainMenuVIP() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.MAIN_MENU_VIP);
    }

    @DataProvider(name = "sideMenu")
    public Object[] sideMenu() {

        return JSONReader.getLinks("sideMenu");
    }

    @DataProvider(name = DataProviderNames.FOOTER_COMPANY)
    public Object[] footerCompany() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.FOOTER_COMPANY);

    }

    @DataProvider(name = DataProviderNames.FOOTER_QUICK_LINKS)
    public Object[] footerQuickLinks() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.FOOTER_QUICK_LINKS);
    }

    @DataProvider(name = DataProviderNames.FOOTER_ACCOUNT)
    public Object[] footerAccount() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.FOOTER_ACCOUNT);
    }

    @DataProvider(name = DataProviderNames.FOOTER_CONNECT_WITH_US)
    public Object[] footerConnectWithUs() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.FOOTER_CONNECT_WITH_US);
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

    @DataProvider(name = DataProviderNames.NEWSLETTER_INCORRECT_EMAIL_FORMAT)
    public Object[] newsletterIncorrectEmailFormat() throws FileNotFoundException {

        return TestdataLoader.getNewsletterDataArray(Newsletter.INCORRECT_EMAIL_FORMAT);
    }

    @DataProvider(name = DataProviderNames.NEWSLETTER_CORRECT_EMAIL)
    public Object[] newsletterCorrectEmail() throws FileNotFoundException {

        return TestdataLoader.getNewsletterDataArray(Newsletter.CORRECT);
    }

    @DataProvider(name = DataProviderNames.PROMOS)
    public Object[] promos() throws FileNotFoundException {

        return TestdataLoader.getLinkDataArray(DataProviderNames.PROMOS);
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
