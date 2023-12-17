package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataProvider.Provider;
import qa.enums.ProductShopMethods;
import qa.helpers.ProductShopHandler;
import qa.pageobject.productpage.ProductPage;
import qa.records.ProductData;
import qa.enums.URLs;
import java.lang.reflect.InvocationTargetException;

public class ProductPageQuantityFieldTest extends BaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() {

        productPage = new ProductPage(getPage());
    }

    private void fill(ProductData data) throws InvocationTargetException, IllegalAccessException {

        goToPage(data.url());

        productPage.setProductShop(ProductShopHandler.set(getPage(), data, ProductShopMethods.ALL));
        productPage.getProductShop().clickAddToCartButton();
    }
    @Test(dataProvider = "QF_min", dataProviderClass = Provider.class)
    public void min(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART.getName());
    }

    @Test(dataProvider = "QF_aboveMin", dataProviderClass = Provider.class)
    public void aboveMin(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertEquals(getPage().url(), URLs.SHOPPING_CART.getName());
    }

    @Test(dataProvider = "QF_belowMax", dataProviderClass = Provider.class)
    public void belowMax(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertTrue(productPage.isErrorMessageVisible());
        Assert.assertTrue(productPage.getErrorMessage().contains(data.message()));
    }

    @Test(dataProvider = "QF_max", dataProviderClass = Provider.class)
    public void max(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertTrue(productPage.isErrorMessageVisible());
        Assert.assertTrue(productPage.getErrorMessage().contains(data.message()));
    }

    @Test(dataProvider = "QF_belowMin", dataProviderClass = Provider.class)
    public void belowMin(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertTrue(productPage.isErrorMessageVisible());
        Assert.assertTrue(productPage.getErrorMessage().contains(data.message()));
    }

    @Test(dataProvider = "QF_aboveMax", dataProviderClass = Provider.class)
    public void aboveMax(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertTrue(productPage.isErrorMessageVisible());
        Assert.assertTrue(productPage.getErrorMessage().contains(data.message()));
    }

    @Test(dataProvider = "QF_floatingPoint", dataProviderClass = Provider.class)
    public void floatingPoint(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName());
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty());
        Assert.assertEquals(productPage.getProductShop().getQuantityValidationMessage(), data.validationMessage());
    }

    @Test(dataProvider = "QF_notANumber", dataProviderClass = Provider.class)
    public void notANumber(ProductData data) throws InvocationTargetException, IllegalAccessException {

        fill(data);

        Assert.assertNotEquals(getPage().url(), URLs.SHOPPING_CART.getName());
        Assert.assertFalse(productPage.getProductShop().getQuantityValidationMessage().isEmpty());
        Assert.assertEquals(productPage.getProductShop().getQuantityValidationMessage(), data.validationMessage());
    }
}
