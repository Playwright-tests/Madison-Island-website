package qa.models;

import lombok.Getter;

@Getter
public class Product {

    private String url;
    private String name;
    private String color;
    private String size;
    private String quantity;

    public Product() {  }
}
