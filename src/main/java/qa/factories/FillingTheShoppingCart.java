package qa.factories;

import com.microsoft.playwright.Page;
import qa.pageobject.components.MainMenu;
import qa.pageobject.components.ProductThumbnail;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.ProductShop;


public class FillingTheShoppingCart {

    public static void fill(Page page, String parent, String item, String title, String color, String size) {

        MainMenu mainMenu = new MainMenu(page);

        mainMenu.hoverParent(parent);
        mainMenu.clickItem(item);

        ProductThumbnail productThumbnail = new ProductThumbnail(page, title);
        productThumbnail.clickViewDetailsButton();

        ProductPage productPage = new ProductPage(page);
        productPage.setProductShop(new ProductShop(page));
        productPage.getProductShop()
                .setColor(color)
                .setSize(size)
                .clickAddToCartButton();
    }
}
