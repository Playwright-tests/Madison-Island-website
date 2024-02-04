package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.testdataloader.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class FooterDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.COMPANY)
    public Object[] footerCompany() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.COMPANY);

    }

    @DataProvider(name = DataProviderNames.QUICK_LINKS)
    public Object[] footerQuickLinks() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.QUICK_LINKS);
    }

    @DataProvider(name = DataProviderNames.ACCOUNT)
    public Object[] footerAccount() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.ACCOUNT);
    }

    @DataProvider(name = DataProviderNames.CONNECT_WITH_US)
    public Object[] footerConnectWithUs() throws FileNotFoundException {

        return TestdataLoader.getLinkData(getJsonFile(), DataProviderNames.CONNECT_WITH_US);
    }
}
