package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.testdataloader.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class CouponCodeDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.INCORRECT)
    public Object[] lowerUpper() throws FileNotFoundException {

        return TestdataLoader.getStrings(getJsonFile(), DataProviderNames.INCORRECT);
    }
}
