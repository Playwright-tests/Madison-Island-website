package tests.shoppingcart.quantityfield;

import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import qa.dataProviders.QuantityFieldDataProviders;
import qa.helpers.ShoppingCartActions;
import qa.models.Product;
import qa.support.DataProviderNames;
import tests.base.BaseTest;
import qa.support.URLs;
import qa.pageobject.shoppingcart.ShoppingCart;


public class ValidationTest extends BaseTest {

    private final Product product;
    private ShoppingCart shoppingCart;

    public ValidationTest(Product product) {

        this.product = product;
    }

    @BeforeMethod
    public void prepare() {

        goToPage(URLs.ELIZABETH_KNIT_PAGE);
        ShoppingCartActions.addToCart(getPage(), product);
        getPage().waitForURL(URLs.SHOPPING_CART);

        shoppingCart = new ShoppingCart(getPage());
        shoppingCart.getTable().findRows();
    }

    private void actions(String quantity) {

        shoppingCart.getTable().getQuantityField(0)
                        .clickQuantityField()
                        .setQuantity(quantity);

        shoppingCart.getTable().clickUpdateCartButton(0);
    }
@Ignore
    @Test
    public void min() {

        actions("1");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), "1", "Incorrect quantity");
    }
@Ignore
    @Test
    public void aboveMin() {

        actions("2");
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), "2", "Incorrect quantity");
    }
@Ignore
    @Test
    public void belowMax() {

        String quantity = String.valueOf(Integer.parseInt(product.getMaxQuantity()) - 1);
        actions(quantity);
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), quantity, "Incorrect quantity");
    }
@Ignore
    @Test
    public void max() {

        actions(product.getMaxQuantity());
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getQuantity(), product.getMaxQuantity(), "Incorrect quantity");
    }
@Ignore
    @Test
    public void aboveMax() {

        actions(String.valueOf(Integer.parseInt(product.getMaxQuantity()) + 1));

        try {
            getPage().waitForSelector(shoppingCart.getTable().getItemErrorMessageSelector(), new Page.WaitForSelectorOptions().setTimeout(2000));
        } catch (Exception e) {
            Assert.fail("The item error message is not displayed");
        }

        Assert.assertTrue(shoppingCart.getTable().getItemErrorMessageText()
                .contains("The requested quantity for \"" + product.getName() + "\" is not available."),
                "Incorrect message content");
    }

    @Test(dataProvider = DataProviderNames.NEGATIVE, dataProviderClass = QuantityFieldDataProviders.class)
    public void negative(String quantity) {

        actions(quantity);

        Assert.assertFalse(shoppingCart.getTable().getQuantityField(0).getValidationMessage().isEmpty(),"No validation message");
    }

    @Test(dataProvider = DataProviderNames.FLOATING_POINT, dataProviderClass = QuantityFieldDataProviders.class)
    public void floatingPoint(String quantity) {

        actions(quantity);

        Assert.assertFalse(shoppingCart.getTable().getQuantityField(0).getValidationMessage().isEmpty(),"No validation message");
    }

    @Test(dataProvider = DataProviderNames.NOT_NUMBER, dataProviderClass = QuantityFieldDataProviders.class)
    public void notNumber(String quantity) {

        actions(quantity);

        Assert.assertFalse(shoppingCart.getTable().getQuantityField(0).getValidationMessage().isEmpty(),"No validation message");
    }
}
