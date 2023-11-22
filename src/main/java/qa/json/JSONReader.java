package qa.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import qa.records.*;

import java.io.*;
import java.util.stream.IntStream;


public class JSONReader {

    private static final String filePath = "./src/main/resources/data.json";
    private static JSONObject jsonObject;

    private static JSONArray getJSONArray(String key, String node) {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;

        return jsonObject1.getJSONArray(node);
    }

    public static void read() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(filePath);
        Object object = parser.parse(reader);

        jsonObject = new JSONObject(object.toString());
    }

    public static String[] get(String key, String node) {

        JSONArray jsonArray = getJSONArray(key, node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static LinkData[] getLinks(String node) {

        JSONArray jsonArray = getJSONArray("URLs", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new LinkData(
                        jsonArray.getJSONObject(i).getString("link"),
                        jsonArray.getJSONObject(i).getString("url")
                ))
                .toArray(LinkData[]::new);
    }

    public static NewsletterData[] getNewsletterData(String node) {

        JSONArray jsonArray = getJSONArray("newsletter", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new NewsletterData(
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(NewsletterData[]::new);
    }

    public static Credentials[] getCredentials(String node) {

        JSONArray jsonArray = getJSONArray("credentials", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Credentials(
                        jsonArray.getJSONObject(i).getString("email"),
                        jsonArray.getJSONObject(i).getString("password"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(Credentials[]::new);
    }

    public static ProductData[] get(String node) {

        JSONArray jsonArray = getJSONArray("addingToShoppingCart", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new ProductData(
                        jsonArray.getJSONObject(i).getString("category"),
                        jsonArray.getJSONObject(i).getString("productType"),
                        jsonArray.getJSONObject(i).getString("name"),
                        jsonArray.getJSONObject(i).getString("color"),
                        jsonArray.getJSONObject(i).getString("size"),
                        jsonArray.getJSONObject(i).getString("quantity")
                ))
                .toArray(ProductData[]::new);
    }

    public static EstimateShippingData[] getEstimatedShippingData(String node) {

        JSONArray jsonArray = getJSONArray("estimateShippingForm", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new EstimateShippingData(
                        jsonArray.getJSONObject(i).getString("stateType"),
                        jsonArray.getJSONObject(i).getString("country"),
                        jsonArray.getJSONObject(i).getString("state"),
                        jsonArray.getJSONObject(i).getString("city"),
                        jsonArray.getJSONObject(i).getString("postcode")
                ))
                .toArray(EstimateShippingData[]::new);
    }
}
