package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.json.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class SideMenuDataProviders extends BaseDataProviders {

    @DataProvider(name = "sideMenu")
    public Object[] sideMenu() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.SIDE_MENU);
    }
}
