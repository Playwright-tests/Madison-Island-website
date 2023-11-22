package qa.helpers;

import com.microsoft.playwright.Page;
import qa.pageobject.shoppingcart.EstimateShippingForm;
import qa.records.EstimateShippingData;

public class EstimateShippingFormFactory {

    public static EstimateShippingForm withAllFields(Page page, EstimateShippingData data) {

        EstimateShippingForm estimateShippingForm = new EstimateShippingForm(page);

        estimateShippingForm.selectCountry(data.country());

        if (data.stateType().contains("dropdownList")) {

            estimateShippingForm.selectState(data.state());
        }
        else {

            estimateShippingForm.setState(data.state());
        }

        estimateShippingForm.setCity(data.city());
        estimateShippingForm.setPostcode(data.postcode());

        return estimateShippingForm;
    }
}
