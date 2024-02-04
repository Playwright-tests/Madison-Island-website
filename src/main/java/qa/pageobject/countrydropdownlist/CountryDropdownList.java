package qa.pageobject.countrydropdownlist;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class CountryDropdownList extends BasePage {

    private Locator list;

    public CountryDropdownList(Page page) {

        super(page);

        list = page.locator("#country");
    }

    public void selectCountry(String country) {

        list.selectOption(country);
    }
}
