package qa.models;

import lombok.Getter;

@Getter
public class ProductData {

    private final String url;
    private final String name;
    private final String color;
    private final String size;
    private final String quantity;

    public ProductData() {

        this.url = null;
        this.name = null;
        this.color = null;
        this.size = null;
        this.quantity = null;
    }

    public ProductData(String url, String name, String color, String size, String quantity) {

        this.url = url;
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }
}
