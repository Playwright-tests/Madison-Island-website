package qa.json;

import org.json.JSONArray;
import org.json.JSONObject;
import qa.records.Credentials;
import qa.records.LinkData;
import qa.records.NewsletterData;
import qa.records.QuantityData;

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

    public static String[] getPhrases(String json, String key) throws FileNotFoundException {

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
}
