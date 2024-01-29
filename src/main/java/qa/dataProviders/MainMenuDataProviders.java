package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.json.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class MainMenuDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.WOMEN)
    public Object[] mainMenuWomen() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.WOMEN);
    }

    @DataProvider(name = DataProviderNames.MEN)
    public Object[] mainMenuMen() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.MEN);
    }

    @DataProvider(name = DataProviderNames.ACCESSORIES)
    public Object[] mainMenuAccessories() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.ACCESSORIES);
    }

    @DataProvider(name = DataProviderNames.HOME_DECOR)
    public Object[] mainMenuHomeDecor() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.HOME_DECOR);
    }

    @DataProvider(name = DataProviderNames.SALE)
    public Object[] mainMenuSale() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.SALE);
    }

    @DataProvider(name = DataProviderNames.VIP)
    public Object[] mainMenuVIP() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.VIP);
    }
}
