package pageobject.components;

import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class Promos extends BasePage {

    public Promos(Page page) {

        super(page);
    }

    public void clickImage(String altText) {

        getPage().getByAltText(altText).click();
    }
}
