package qa.helpers;

import com.microsoft.playwright.Page;
import qa.pageobject.shoppingcart.EstimateShippingForm;
import qa.utils.EstimateShippingData;

public class EstimateShippingFormFactory {

    public static EstimateShippingForm withAllFields(Page page, EstimateShippingData data) {

        EstimateShippingForm estimateShippingForm = new EstimateShippingForm(page);

        estimateShippingForm.selectCountry(data.getCountry());

        if (data.getStateType().contains("dropdownList")) {

            estimateShippingForm.selectState(data.getState());
        }
        else {

            estimateShippingForm.setState(data.getState());
        }

        estimateShippingForm.setCity(data.getCity());
        estimateShippingForm.setPostcode(data.getPostcode());

        return estimateShippingForm;
    }
}
