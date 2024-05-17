package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.support.ModelsBuilder;
import qa.support.DataProviderNames;

import java.io.FileNotFoundException;

public class CountriesDataProviders {

    @DataProvider(name = DataProviderNames.FIELD)
    public Object[] field() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.FIELD);
    }

    @DataProvider(name = DataProviderNames.DROPDOWN_LIST)
    public Object[] dropdownList() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.DROPDOWN_LIST);
    }
}
