package qa.base;

import qa.IO.LocalTestdataProvider;
import qa.IO.MockarooTestdataProvider;
import qa.exceptions.MockarooRequestException;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BaseDataProviders {

    private static String jsonFile;

    public static void loadTestdata(String fileName, String downloadMode) throws FileNotFoundException, MalformedURLException, URISyntaxException, MockarooRequestException {

        jsonFile = switch (downloadMode) {

            case "LOCAL" -> LocalTestdataProvider.fetchTestdata(fileName);
            case "API" -> MockarooTestdataProvider.fetchTestdata(fileName);
            default -> throw new IllegalStateException("Unexpected value: " + downloadMode);
        };
    }

    public static void clear() {

        jsonFile = "";
    }

    protected String getJsonFile() {

        return jsonFile;
    }
}
