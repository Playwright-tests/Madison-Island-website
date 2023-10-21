package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.pageobject.components.MainMenu;
import qa.pageobject.components.ProductThumbnail;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.ProductShop;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.playwright.PlaywrightLauncher;


public class QuantityFieldTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() {

        shoppingCart = new ShoppingCart(PlaywrightLauncher.getPage());

        MainMenu mainMenu = new MainMenu(PlaywrightLauncher.getPage());

        mainMenu.hoverParent("Women");
        mainMenu.clickItem("Pants & Denim");

        ProductThumbnail productThumbnail = new ProductThumbnail(PlaywrightLauncher.getPage(), "TriBeCa Skinny Jean");
        productThumbnail.clickViewDetailsButton();

        ProductPage productPage = new ProductPage(PlaywrightLauncher.getPage());
        productPage.setProductShop(new ProductShop(PlaywrightLauncher.getPage()));
        productPage.getProductShop()
                .setColor("Black")
                .setSize("30")
                .clickAddToCartButton();
    }

    private String getSubtotal(double price, String quantity) {

        return "$" + String.format("%.2f", price * Integer.parseInt(quantity)).replace(",", ".");
    }

    private void setQuantityField(String quantity) {

        shoppingCart.getTable().getQuantityCell().setQuantity(quantity);
        shoppingCart.getTable().getQuantityCell().clickUpdateButton();
    }

    @Test
    @Parameters({"minValue"})
    public void minValue(String value) {

        setQuantityField(value);

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), getSubtotal(shoppingCart.getTable().getPrice(), value));
    }

    @Test
    public void zeroValue() {

        setQuantityField("0");

        Assert.assertFalse(shoppingCart.getTable().isVisible());
        Assert.assertEquals(shoppingCart.getPageTitleText(), "Shopping Cart is Empty");
    }

    @Test
    @Parameters({"maxValue"})
    public void maxValue(String value) {

        setQuantityField(value);

        Assert.assertTrue(shoppingCart.isErrorMessageVisible());
        //Assert.assertEquals(shoppingCart.getTable().getSubtotal(), getSubtotal(shoppingCart.getTable().getPrice(), value));
    }

    @Test
    @Parameters({"negative"})
    public void negativeNumber(String value) {

        String actualSubtotal = shoppingCart.getTable().getSubtotal();

        setQuantityField(value);

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), actualSubtotal);
    }

    @Test
    @Parameters({"tooLarge"})
    public void tooLargeValue(/*String value*/) {

        setQuantityField("1000");
        Assert.assertTrue(shoppingCart.isErrorMessageVisible());
    }

    @Test(dataProvider = "floatingPointNumber", dataProviderClass = Provider.class)
    public void floatingPointNumber(String quantity) {

        String currentSubtotal = shoppingCart.getTable().getSubtotal();

        setQuantityField(quantity);

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), currentSubtotal);
    }

    @Test(dataProvider = "notANumber", dataProviderClass = Provider.class)
    public void notANumber(String quantity) {

        String currentSubtotal = shoppingCart.getTable().getSubtotal();

        setQuantityField(quantity);

        Assert.assertEquals(shoppingCart.getTable().getSubtotal(), currentSubtotal);
    }
}

