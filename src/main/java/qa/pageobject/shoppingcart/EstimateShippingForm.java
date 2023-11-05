package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class EstimateShippingForm extends BasePage {

    private final Locator countryDropdownList;
    private final Locator stateField;
    private final Locator stateDropdownList;
    private final Locator cityField;
    private final Locator postcodeField;
    private final Locator estimateButton;

    public EstimateShippingForm(Page page) {

        super(page);

        countryDropdownList = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Country *"));
        stateField = page.locator("#region");
        stateDropdownList = page.locator("#region_id");
        cityField = page.locator("#city");
        postcodeField = page.locator("#postcode");
        estimateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Estimate"));
    }

    public void selectCountry(String country) {

        countryDropdownList.selectOption(country);
    }

    public void selectState(String state) {

        stateDropdownList.selectOption(state);
    }

    public void setState(String state) {

        stateField.fill(state);
    }

    public void setCity(String city) {

        cityField.fill(city);
    }

    public void setPostcode(String postcode) {

        postcodeField.fill(postcode);
    }

    public void clickEstimateButton() {

        estimateButton.click();
    }
}
