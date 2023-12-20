package qa.records;

import lombok.Getter;

@Getter
public class ProductData {

    private final String url;
    private final String color;
    private final String size;
    private final String quantity;
    private final String message;
    private final String validationMessage;
    public  ProductData(String url, String color, String size, String quantity, String message, String validationMessage) {

        this.url = url;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.message = message;
        this.validationMessage = validationMessage;
    }
}
