package qa.pageobject.productpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;
import qa.pageobject.shoppingcart.QuantityField;

public class ProductShop extends BasePage {

    private final Locator productName;
    private final Locator price;
    private final Locator addToCartButton;
    private final Locator requiredColorMessage;
    private final Locator requiredSizeMessage;
    private final QuantityField quantityField;

    public ProductShop(Page page) {

        super(page);

        productName = page.locator(".product-name").nth(1);
        price = page.locator(".price-box").nth(1);
        addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart"));
        requiredColorMessage = page.locator("#advice-required-entry-attribute92");
        requiredSizeMessage = page.locator("#advice-required-entry-attribute180");

        quantityField = new QuantityField(page, page.locator("#qty"));
    }

    public void setSize(String size) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(size).setExact(true)).click();
    }

    public void setQuantity(String quantity) {

        quantityField.setQuantity(quantity);
    }

    public String getQuantityValidationMessage() {

        return quantityField.getValidationMessage();
    }

    public String getProductName() {

        return productName.textContent().trim();
    }

    public String getPrice() {

        return price.textContent().trim();
    }

    public String getQuantity() {

        return quantityField.getQuantity();
    }

    public void clickAddToCartButton() {

        addToCartButton.click();
    }

    public boolean isRequiredColorMessageVisible() {

        return requiredColorMessage.isVisible();
    }

    public boolean isRequiredSizeMessageVisible() {

        return requiredSizeMessage.isVisible();
    }

    public String getRequiredColorMessage() {

        return requiredColorMessage.textContent();
    }

    public String getRequiredSizeMessage() {

        return requiredSizeMessage.textContent();
    }
}
