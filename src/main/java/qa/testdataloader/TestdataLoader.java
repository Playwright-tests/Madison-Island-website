package qa.testdataloader;

import org.json.JSONArray;
import org.json.JSONObject;
import qa.records.*;

import java.io.FileNotFoundException;
import java.util.stream.IntStream;

public class TestdataLoader {

    public static Credentials[] getCredentials(String json, String key) throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Credentials(
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("password")
                ))
                .toArray(Credentials[]::new);
    }

    public static LinkData[] getLinkData(String json, String key) throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new LinkData(
                        jsonArray.getJSONObject(i).getString("link"),
                        jsonArray.getJSONObject(i).getString("url")
                ))
                .toArray(LinkData[]::new);
    }

    public static NewsletterData[] getNewsletterData(String json, String key) throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new NewsletterData(jsonArray.getJSONObject(i).getString("email")))
                .toArray(NewsletterData[]::new);
    }

    public static String[] getStrings(String json, String key) throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static QuantityData[] getQuantityData(String json, String key) {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new QuantityData(
                        String.valueOf(jsonArray.getJSONObject(i).getString("quantity")),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(QuantityData[]::new);
    }

    public static ProductData[] getProductData(String json) {

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("products");

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new ProductData(
                        jsonArray.getJSONObject(i).getString("url"),
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("color"),
                        jsonArray.getJSONObject(i).getString("size"),
                        jsonArray.getJSONObject(i).getString("quantity")
                ))
                .toArray(ProductData[]::new);
    }

    public static EstimateShippingAndTaxData[] getEstimateShippingAndTaxData(String source, String key1, String key2) {

        JSONObject jsonObject = new JSONObject(source);
        JSONObject dest = jsonObject.getJSONObject(key1);
        JSONArray jsonArray = dest.getJSONArray(key2);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new EstimateShippingAndTaxData(
                        jsonArray.getJSONObject(i).getString("country"),
                        jsonArray.getJSONObject(i).getString("stateOrProvince"),
                        jsonArray.getJSONObject(i).getString("city"),
                        jsonArray.getJSONObject(i).getString("zip")
                ))
                .toArray(EstimateShippingAndTaxData[]::new);
    }
}
