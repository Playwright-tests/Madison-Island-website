package qa.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import qa.IO.LocalTestdataProvider;
import qa.IO.Service;
import qa.testdatanames.LocalTestdata;
import qa.records.Credentials;
import qa.records.LinkData;
import qa.records.NewsletterData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.IntStream;

public class TestdataLoader {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static Credentials getCredentials(String name) throws IOException {

        String data = Service.fetchTestdata(name);
        JSONObject jsonObject = new JSONObject(data);

        return objectMapper.readValue(jsonObject.toString(), Credentials.class);
    }

    public static Credentials[] getCredentialsArray(String name) throws FileNotFoundException {

        String data = Service.fetchTestdata(name);
        JSONArray jsonArray = new JSONArray(data);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> {
                    try {
                        return objectMapper.readValue(jsonArray.getJSONObject(i).toString(), Credentials.class);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toArray(Credentials[]::new);
    }

    public static LinkData[] getLinkDataArray(String key) throws FileNotFoundException {

        String data = LocalTestdataProvider.fetchTestdata(LocalTestdata.LINKS);
        JSONObject jsonObject = new JSONObject(data);

        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> {
                    try {
                        return objectMapper.readValue(jsonArray.getJSONObject(i).toString(), LinkData.class);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toArray(LinkData[]::new);
    }

    public static NewsletterData[] getNewsletterDataArray(String name) throws FileNotFoundException {

        String data = Service.fetchTestdata(name);
        JSONArray jsonArray = new JSONArray(data);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> {
                    try {
                        return objectMapper.readValue(jsonArray.getJSONObject(i).toString(), NewsletterData.class);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toArray(NewsletterData[]::new);
    }
}
