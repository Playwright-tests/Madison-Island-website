package qa.records;

import lombok.Getter;

@Getter
public class EstimateShippingAndTaxData {

    private final String country;
    private final String stateOrProvince;
    private final String city;
    private final String zip;
    public EstimateShippingAndTaxData(String country, String stateOrProvince, String city, String zip) {

        this.country = country;
        this.stateOrProvince = stateOrProvince;
        this.city = city;
        this.zip = zip;
    }
}
