package qa.utils;

public class EstimateShippingData {

    private final String stateType;
    private final String country;
    private final String state;
    private final String city;
    private final String postcode;

    public EstimateShippingData(String stateType, String country, String state, String city, String postcode) {

        this.stateType = stateType;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postcode = postcode;
    }

    public String getStateType() {
        return stateType;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }
}
