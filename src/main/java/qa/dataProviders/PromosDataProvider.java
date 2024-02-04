package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.testdataloader.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class PromosDataProvider extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.PROMOS)
    public Object[] promos() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.PROMOS);
    }
}
