package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.testdataloader.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class AccountDropdownListDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.ACCOUNT_DROPDOWN_LIST)
    public Object[] accountDropdownList() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.ACCOUNT_DROPDOWN_LIST);
    }
}
