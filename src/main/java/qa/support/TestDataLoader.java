package qa.support;

import lombok.Getter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestDataLoader {

    private static final Logger logger = LoggerFactory.getLogger(TestDataLoader.class);
    private static final String PATH = "./src/test/resources/testdata/";
    @Getter
    private static String source;

    public static void load(String fileName) {

        String fullPath = PATH + fileName;

        try {
            Reader reader = new FileReader(fullPath);
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(reader);
            logger.info("Downloading testdata locally...");
            source = object.toString();

        } catch (IOException | ParseException e) {

            logger.info("Could not load the testdata from path: {}", fullPath);
            throw new RuntimeException(e);
        }

    }
}
