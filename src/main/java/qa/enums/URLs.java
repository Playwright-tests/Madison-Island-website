package qa.enums;

public enum URLs {

    HOME_PAGE("http://demo-store.seleniumacademy.com/"),
    ELIZABETH_KNIT_PRODUCT_PAGE("http://demo-store.seleniumacademy.com/women/tops-blouses/elizabeth-knit-top-493.html"),
    SHOPPING_CART("http://demo-store.seleniumacademy.com/checkout/cart/"),
    LOGIN_PAGE("http://demo-store.seleniumacademy.com/customer/account/login/");

    private final String name;

    URLs(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
