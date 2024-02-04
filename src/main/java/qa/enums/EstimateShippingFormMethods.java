package qa.enums;

public enum EstimateShippingFormMethods {

    ALL("All"),
    SET_CITY("setCity"),
    SET_ZIP("setZIP"),
    SET_STATE_OR_PROVINCE("setStateOrProvince");

    private final String name;

    EstimateShippingFormMethods(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
