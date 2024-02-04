package tests.shoppingcart.estimatedform;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.EstimateShippingDataProviders;
import qa.enums.EstimateShippingFormMethods;
import qa.enums.URLs;
import qa.helpers.EstimateShippingHandler;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.EstimatedShippingAndTaxForm;
import qa.records.EstimateShippingAndTaxData;
import qa.support.dataprovidernames.DataProviderNames;

import java.lang.reflect.InvocationTargetException;

public class FillingFormTest extends BaseTest {

    private EstimatedShippingAndTaxForm estimatedShippingAndTaxForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();

        estimatedShippingAndTaxForm = new EstimatedShippingAndTaxForm(getPage());
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = EstimateShippingDataProviders.class)
    public void correct(EstimateShippingAndTaxData data) throws InvocationTargetException, IllegalAccessException {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry(data.getCountry());
        EstimateShippingHandler.set(estimatedShippingAndTaxForm, data, EstimateShippingFormMethods.ALL);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_CITY, dataProviderClass = EstimateShippingDataProviders.class)
    public void incorrectCity(EstimateShippingAndTaxData data) throws InvocationTargetException, IllegalAccessException {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry(data.getCountry());
        EstimateShippingHandler.set(estimatedShippingAndTaxForm, data, EstimateShippingFormMethods.ALL);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_ZIP, dataProviderClass = EstimateShippingDataProviders.class)
    public void incorrectZip(EstimateShippingAndTaxData data) throws InvocationTargetException, IllegalAccessException {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry(data.getCountry());
        EstimateShippingHandler.set(estimatedShippingAndTaxForm, data, EstimateShippingFormMethods.ALL);
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = EstimateShippingDataProviders.class)
    public void cityNotSelected(EstimateShippingAndTaxData data) throws InvocationTargetException, IllegalAccessException, InterruptedException {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry("");
        EstimateShippingHandler.set(estimatedShippingAndTaxForm, data, EstimateShippingFormMethods.ALL);
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = EstimateShippingDataProviders.class)
    public void blankCityField(EstimateShippingAndTaxData data) throws InvocationTargetException, IllegalAccessException {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry(data.getCountry());
        EstimateShippingHandler.set(estimatedShippingAndTaxForm, data, EstimateShippingFormMethods.SET_CITY);
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = EstimateShippingDataProviders.class)
    public void blankZipField(EstimateShippingAndTaxData data) throws InvocationTargetException, IllegalAccessException {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry(data.getCountry());
        EstimateShippingHandler.set(estimatedShippingAndTaxForm, data, EstimateShippingFormMethods.SET_ZIP);
    }
}
