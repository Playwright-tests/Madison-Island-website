package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.testdataloader.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class SearchEngineDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws FileNotFoundException {

        return TestdataLoader.getStrings(getJsonFile(), DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.LOWER_UPPER)
    public Object[] lowerUpper() throws FileNotFoundException {

        return TestdataLoader.getStrings(getJsonFile(), DataProviderNames.LOWER_UPPER);
    }

    @DataProvider(name = DataProviderNames.INCORRECT)
    public Object[] incorrect() throws FileNotFoundException {

        return TestdataLoader.getStrings(getJsonFile(), DataProviderNames.INCORRECT);
    }
}
