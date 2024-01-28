package qa.IO;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.exceptions.MockarooRequestException;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Service {

    private static final Logger logger = LoggerFactory.getLogger(Service.class);
    public static String fetchTestdata(String name) throws FileNotFoundException {

        try {
            return MockarooTestdataProvider.fetchTestdata(name);
        } catch (MockarooRequestException e) {
            logger.warn("Using the local testdata");
            return LocalTestdataProvider.fetchTestdata(name);
        } catch (URISyntaxException | MalformedURLException e) {
            logger.error("Could not load the testdata");
            throw new RuntimeException(e);
        }
    }
}
