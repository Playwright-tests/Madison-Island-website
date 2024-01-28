package qa.IO;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LocalTestdataProvider {

    private static final Logger logger = LoggerFactory.getLogger(LocalTestdataProvider.class);
    private static final String PATH = "./src/main/resources/";

    public static String fetchTestdata(String fileName) throws FileNotFoundException {

        String fullPath = PATH + fileName + ".json";

        try {
            Reader reader = new FileReader(fullPath);
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(reader);
            logger.info("Downloading testdata locally...");

            return object.toString();

        } catch (IOException | ParseException e) {

            logger.info("Could not load the testdata from path: " + fullPath);
            throw new RuntimeException(e);
        }

    }
}
