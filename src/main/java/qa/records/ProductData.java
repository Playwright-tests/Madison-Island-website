package qa.records;

import lombok.Getter;

@Getter
public class ProductData {

    private final String url;
    private final String color;
    private final String size;
    private final String quantity;

    public ProductData(String url, String color, String size, String quantity) {

        this.url = url;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }
}
