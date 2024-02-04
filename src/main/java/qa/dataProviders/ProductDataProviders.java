package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.testdataloader.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

public class ProductDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.PRODUCT_ATTRIBUTES)
    public Object[] productAttributes() {

        return TestdataLoader.getProductData(getJsonFile());
    }
}
