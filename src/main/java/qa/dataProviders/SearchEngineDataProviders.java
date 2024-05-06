package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.testdataloader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class SearchEngineDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.LOWER_UPPER)
    public Object[] lowerUpper() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.LOWER_UPPER);
    }

    @DataProvider(name = DataProviderNames.INCORRECT)
    public Object[] incorrect() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.INCORRECT);
    }
}
