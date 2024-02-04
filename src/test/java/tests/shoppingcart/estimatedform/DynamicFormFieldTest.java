package tests.shoppingcart.estimatedform;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProviders.CountriesDataProviders;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.EstimatedShippingAndTaxForm;
import qa.support.dataprovidernames.DataProviderNames;

public class DynamicFormFieldTest extends BaseTest {

    private EstimatedShippingAndTaxForm estimatedShippingAndTaxForm;

    @BeforeMethod
    public void create() {

        goToPage(URLs.ELIZABETH_KNIT_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getPage()).clickAddToCartButton();

        estimatedShippingAndTaxForm = new EstimatedShippingAndTaxForm(getPage());
    }

    @Test(dataProvider = DataProviderNames.FIELD, dataProviderClass = CountriesDataProviders.class)
    public void stateProvinceFieldVisibility(String country) {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry(country);

        Assert.assertTrue(estimatedShippingAndTaxForm.isStateProvinceFieldVisible(),
                "The \"STATE/PROVINCE\" field is not visible");
    }

    @Test(dataProvider = DataProviderNames.DROPDOWN_LIST, dataProviderClass = CountriesDataProviders.class)
    public void stateProvinceDropdownListVisibility(String country) {

        estimatedShippingAndTaxForm.getCountryDropdownList().selectCountry(country);

        Assert.assertTrue(estimatedShippingAndTaxForm.isStateProvinceDropdownListVisible(),
                "The \"STATE/PROVINCE\" dropdown list is not visible");
    }
}
