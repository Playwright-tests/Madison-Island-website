package qa.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import qa.models.*;

import java.io.FileNotFoundException;
import java.util.stream.IntStream;

public class ModelsBuilder {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static JSONArray getJSONArray(String key) {

        JSONObject jsonObject = new JSONObject(TestDataLoader.getSource());
        return jsonObject.getJSONArray(key);
    }

    private static  <T> T[] getObjects(String key, Class<T> clazz) throws JsonProcessingException {

        JSONArray jsonArray = getJSONArray(key);

        T[] objects = (T[]) java.lang.reflect.Array.newInstance(clazz, jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++) {
            objects[i] = objectMapper.readValue(jsonArray.getJSONObject(i).toString(), clazz);
        }

        return objects;
    }

    public static Credentials[] getCredentials(String key) throws JsonProcessingException {

        return getObjects(key, Credentials.class);
    }

    public static String[] getStrings(String key) throws FileNotFoundException {

        JSONObject jsonObject = new JSONObject(TestDataLoader.getSource());
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(jsonArray::getString)
                .toArray(String[]::new);
    }

    public static Product[] getProduct(String key) throws JsonProcessingException {

        return getObjects(key, Product.class);
    }
}
