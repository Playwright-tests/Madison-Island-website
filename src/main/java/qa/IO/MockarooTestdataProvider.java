package qa.IO;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.exceptions.MockarooRequestException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class MockarooTestdataProvider {

    private static final Logger logger = LoggerFactory.getLogger(MockarooTestdataProvider.class);
    private static final String URL = "https://my.api.mockaroo.com/";
    private static final String API_KEY = "---";

    private static Object getString(InputStream inputStream) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        return jsonParser.parse(new InputStreamReader(inputStream));
    }

    public static String fetchTestdata(String name) throws URISyntaxException, MalformedURLException, MockarooRequestException {

        String fullUrl = URL + name + ".json?key=" + API_KEY;
        URI uri = new URI(fullUrl);

        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
            httpURLConnection.setRequestMethod("GET");

            logger.info("Downloading testdata from the Mockaroo API...");

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return getString(httpURLConnection.getInputStream()).toString();
            } else {
                throw new MockarooRequestException("Mockaroo request failed with status code: " + httpURLConnection.getResponseCode());
            }

        } catch (IOException | ParseException e) {
            logger.info("Invalid url: " + fullUrl);
            throw new RuntimeException(e);
        }
    }
}
