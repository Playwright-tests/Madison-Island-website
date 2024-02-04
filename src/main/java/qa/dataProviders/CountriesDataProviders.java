package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.json.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class CountriesDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.FIELD)
    public Object[] field() throws FileNotFoundException {

        return TestdataLoader.getStrings(getJsonFile(), DataProviderNames.FIELD);
    }

    @DataProvider(name = DataProviderNames.DROPDOWN_LIST)
    public Object[] dropdownList() throws FileNotFoundException {

        return TestdataLoader.getStrings(getJsonFile(), DataProviderNames.DROPDOWN_LIST);
    }
}
