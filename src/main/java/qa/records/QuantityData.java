package qa.records;

import lombok.Getter;

@Getter
public class QuantityData {

    private final String quantity;
    private final String message;

    public QuantityData(String quantity, String message) {

        this.quantity = quantity;
        this.message = message;
    }
}
