package tests;

import dataProvider.Provider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.productpage.ProductPage;
import pageobject.components.MainMenu;
import pageobject.components.ProductThumbnail;
import qa.base.BaseTest;
import utils.ProductData;

import static playwright.PlaywrightLauncher.*;

public class AddingToShoppingCartTest extends BaseTest {

    private void openProductPage(String category, String type, String name) {

        MainMenu mainMenu = new MainMenu(getPage());
        ProductThumbnail productThumbnail = new ProductThumbnail(getPage(), name);

        mainMenu.hoverParent(category);
        mainMenu.clickWomenItem(type);
        productThumbnail.clickViewDetailsButton();
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void correct(ProductData data) {

        openProductPage(data.getCategory(), data.getProductType(), data.getName());

        ProductPage productPage = new ProductPage(getPage());

        productPage.getProductShop().setColor(data.getColor());
        productPage.getProductShop().setSize(data.getSize());
        productPage.getProductShop().setQuantity(data.getQuantity());
        productPage.getProductShop().clickAddToCartButton();
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void colorNotSelected(ProductData data) {

        openProductPage(data.getCategory(), data.getProductType(), data.getName());

        ProductPage productPage = new ProductPage(getPage());

        productPage.getProductShop().setSize(data.getSize());
        productPage.getProductShop().setQuantity(data.getQuantity());
        productPage.getProductShop().clickAddToCartButton();

        Assert.assertTrue(productPage.getProductShop().isRequiredColorMessageVisible());
    }

    @Test(dataProvider = "correctProductData", dataProviderClass = Provider.class)
    public void sizeNotSelected(ProductData data) {

        openProductPage(data.getCategory(), data.getProductType(), data.getName());

        ProductPage productPage = new ProductPage(getPage());

        productPage.getProductShop().setColor(data.getColor());
        productPage.getProductShop().setQuantity(data.getQuantity());
        productPage.getProductShop().clickAddToCartButton();

        Assert.assertTrue(productPage.getProductShop().isRequiredSizeMessageVisible());
    }
}
