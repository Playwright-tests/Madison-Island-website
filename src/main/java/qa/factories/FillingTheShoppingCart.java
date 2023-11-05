package qa.factories;

import qa.pageobject.components.MainMenu;
import qa.pageobject.components.ProductThumbnail;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.ProductShop;
import qa.playwright.PlaywrightLauncher;

public class FillingTheShoppingCart {

    public static void fill(String parent, String item, String title, String color, String size) {

        MainMenu mainMenu = new MainMenu(PlaywrightLauncher.getPage());

        mainMenu.hoverParent(parent);
        mainMenu.clickItem(item);

        ProductThumbnail productThumbnail = new ProductThumbnail(PlaywrightLauncher.getPage(), title);
        productThumbnail.clickViewDetailsButton();

        ProductPage productPage = new ProductPage(PlaywrightLauncher.getPage());
        productPage.setProductShop(new ProductShop(PlaywrightLauncher.getPage()));
        productPage.getProductShop()
                .setColor(color)
                .setSize(size)
                .clickAddToCartButton();
    }
}
