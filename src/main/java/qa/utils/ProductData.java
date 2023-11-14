package qa.utils;

public class ProductData {

    private String category;
    private String productType;
    private String name;
    private String color;
    private String size;
    private String quantity;

    public ProductData() { }
    public ProductData(String category, String productType, String name, String color, String size, String quantity) {

        this.category = category;
        this.productType = productType;
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getProductType() {
        return productType;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getQuantity() {
        return quantity;
    }
}
