package qa.pageobject.shoppingcart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;
import qa.pageobject.countrydropdownlist.CountryDropdownList;

public class EstimatedShippingAndTaxForm extends BasePage {

    private final Locator stateProvinceField;
    private final Locator stateProvinceDropdownList;
    private final Locator cityField;
    private final Locator zipField;
    private final Locator estimateButton;
    private final Locator requiredCountryMessage;
    private final Locator requiredCityFieldMessage;
    private final Locator requiredZipFieldMessage;
    private final CountryDropdownList countryDropdownList;

    public EstimatedShippingAndTaxForm(Page page) {

        super(page);

        stateProvinceField = page.locator("#region");
        stateProvinceDropdownList = page.locator("#region_id");
        cityField = page.locator("#city");
        zipField = page.locator("#postcode");
        estimateButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Estimate"));
        requiredCountryMessage = page.locator("#advice-validate-select-country");
        requiredCityFieldMessage = page.locator("#advice-required-entry-region_id");
        requiredZipFieldMessage = page.locator("#advice-required-entry-postcode");

        countryDropdownList = new CountryDropdownList(page);
    }

    public CountryDropdownList getCountryDropdownList() {

        return countryDropdownList;
    }

    public void setCity(String city) {

        cityField.fill(city);
    }

    public void setZIP(String ZIP) {

        zipField.fill(ZIP);
    }

    public void setStateOrProvince(String stateOrProvince) {

        stateProvinceField.fill(stateOrProvince);
    }

    public void clickEstimateButton() {

        estimateButton.click();
    }

    public String getStateProvinceFieldText() {

        return stateProvinceField.inputValue();
    }

    public String getCityFieldText() {

        return cityField.inputValue();
    }

    public String getZipFieldText() {

        return zipField.inputValue();
    }

    public String getRequiredCountryMessageText() {

        return requiredCountryMessage.textContent();
    }

    public String getRequiredCityFieldMessage() {

        return requiredCityFieldMessage.textContent();
    }

    public String getRequiredZipFieldMessage() {

        return requiredZipFieldMessage.textContent();
    }

    public boolean isStateProvinceFieldVisible() {

        return stateProvinceField.isVisible();
    }

    public boolean isStateProvinceDropdownListVisible() {

        return stateProvinceDropdownList.isVisible();
    }
}
