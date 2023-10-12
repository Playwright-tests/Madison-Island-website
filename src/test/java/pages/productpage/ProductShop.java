package pages.productpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class ProductShop extends BasePage {

    private final Locator price;
    private final Locator quantityField;
    private final Locator addToCartButton;
    public ProductShop(Page page) {

        super(page);

        price = page.locator("#product-price-421");
        quantityField = page.locator("#qty");
        addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
    }

    public void setColor(String color) {

        getPage().getByAltText(color).click();
    }

    public void setSize(String size) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(size).setExact(true)).click();
    }

    public void setQuantity(String quantity) {

        quantityField.fill(quantity);
    }

    public String getPrice() {

        return price.textContent();
    }

    public String getQuantity() {

        return quantityField.textContent();
    }

    public void clickAddToCartButton() {

        addToCartButton.click();
    }
}
