package qa.base;

import qa.IO.LocalTestdataProvider;
import qa.IO.MockarooTestdataProvider;
import qa.enums.DataDownloadMode;
import qa.exceptions.MockarooRequestException;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BaseDataProviders {

    private static String jsonFile;

    public static void loadTestdata(String fileName, DataDownloadMode mode) throws FileNotFoundException, MalformedURLException, URISyntaxException, MockarooRequestException {

        jsonFile = switch (mode) {

            case LOCAL -> LocalTestdataProvider.fetchTestdata(fileName);
            case API -> MockarooTestdataProvider.fetchTestdata(fileName);
        };
    }

    public static void clear() {

        jsonFile = "";
    }

    protected String getJsonFile() {

        return jsonFile;
    }
}
