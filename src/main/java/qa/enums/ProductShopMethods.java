package qa.enums;

public enum ProductShopMethods {

    ALL("All"),
    SET_COLOR("setColor"),
    SET_SIZE("setSize"),
    SET_QUANTITY("setQuantity");

    private final String name;

    ProductShopMethods(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
