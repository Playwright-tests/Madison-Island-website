package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.json.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

public class ProductPageQuantityDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.BELOW_MIN)
    public Object[] belowMin() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.BELOW_MIN);
    }

    @DataProvider(name = DataProviderNames.MIN)
    public Object[] min() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.MIN);
    }

    @DataProvider(name = DataProviderNames.ABOVE_MIN)
    public Object[] aboveMin() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.ABOVE_MIN);
    }

    @DataProvider(name = DataProviderNames.BELOW_MAX)
    public Object[] belowMax() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.BELOW_MAX);
    }

    @DataProvider(name = DataProviderNames.MAX)
    public Object[] max() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.MAX);
    }

    @DataProvider(name = DataProviderNames.ABOVE_MAX)
    public Object[] aboveMax() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.ABOVE_MAX);
    }

    @DataProvider(name = DataProviderNames.NEGATIVE)
    public Object[] negative() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.NEGATIVE);
    }

    @DataProvider(name = DataProviderNames.FLOATING_POINT)
    public Object[] floatingPoint() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.FLOATING_POINT);
    }

    @DataProvider(name = DataProviderNames.NOT_NUMBER)
    public Object[] notNumber() {

        return TestdataLoader.getQuantityData(getJsonFile(), DataProviderNames.NOT_NUMBER);
    }
}
