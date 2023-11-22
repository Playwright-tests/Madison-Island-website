package tests.shoppingcart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.helpers.EstimateShippingFormFactory;
import qa.helpers.FillingTheShoppingCart;
import qa.pageobject.shoppingcart.EstimateShippingForm;
import qa.records.EstimateShippingData;

public class EstimateShippingFormTests extends BaseTest {

    @BeforeMethod
    public void create() {

        FillingTheShoppingCart.fill(getPage(), "Women", "Pants & Denim", "TriBeCa Skinny Jean", "Black", "30");
    }

    private void fill(EstimateShippingData data) {

        EstimateShippingForm estimateShippingForm = EstimateShippingFormFactory.withAllFields(getPage(), data);
        estimateShippingForm.clickEstimateButton();
    }

    @Test(dataProvider = "ESF_correct", dataProviderClass = Provider.class)
    public void correctData(EstimateShippingData data) {

        fill(data);
    }

    @Test(dataProvider = "ESF_incorrectState", dataProviderClass = Provider.class)
    public void incorrectState(EstimateShippingData data) {

        fill(data);
    }

    @Test(dataProvider = "ESF_incorrectCity", dataProviderClass = Provider.class)
    public void incorrectCity(EstimateShippingData data) {

        fill(data);
    }

    @Test(dataProvider = "ESF_incorrectPostcode", dataProviderClass = Provider.class)
    public void incorrectPostcode(EstimateShippingData data) {

        fill(data);
    }

    @Test(dataProvider = "ESF_withoutState", dataProviderClass = Provider.class)
    public void blankStateField(EstimateShippingData data) {

        fill(data);
    }

    @Test(dataProvider = "ESF_withoutCity", dataProviderClass = Provider.class)
    public void blankCityField(EstimateShippingData data) {

        fill(data);
    }

    @Test(dataProvider = "ESF_withoutPostcode", dataProviderClass = Provider.class)
    public void blankPostcodeField(EstimateShippingData data) {

        fill(data);
    }
}
