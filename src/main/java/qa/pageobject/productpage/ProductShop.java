package qa.pageobject.productpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;
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
        requiredColorMessage = page.locator(".validation-advice");
        requiredSizeMessage = page.locator(".validation-advice");

        quantityField = new QuantityField(page, page.locator("#qty"));
    }

    @Step("Click the color picker")
    public ProductShop setColor(String color) {

        getPage().getByAltText(color).click();
        return this;
    }

    @Step("Click the size picker")
    public ProductShop setSize(String size) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(size).setExact(true)).click();
        return this;
    }

    public ProductShop setQuantity(String quantity) {

        quantityField.setQuantity(quantity);
        return this;
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

    @Step("Click the \"Add to Cart\" button")
    public void clickAddToCartButton() {

        addToCartButton.click();
    }

    public Locator getRequiredColorMessageLocator() {

        return requiredColorMessage;
    }

    public Locator getRequiredSizeMessageLocator() {

        return requiredSizeMessage;
    }

    public String getRequiredColorMessage() {

        return requiredColorMessage.textContent();
    }

    public String getRequiredSizeMessage() {

        return requiredSizeMessage.textContent();
    }
}
