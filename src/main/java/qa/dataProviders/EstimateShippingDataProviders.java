package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.support.dataprovidernames.DataProviderNames;
import qa.support.dataprovidernames.formfieldtype.FormFieldType;
import qa.testdataloader.TestdataLoader;

public class EstimateShippingDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() {

        return TestdataLoader.getEstimateShippingAndTaxData(getJsonFile(), FormFieldType.FIELD, DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_CITY)
    public Object[] incorrectCity() {

        return TestdataLoader.getEstimateShippingAndTaxData(getJsonFile(), FormFieldType.FIELD, DataProviderNames.INCORRECT_CITY);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_ZIP)
    public Object[] incorrectZip() {

        return TestdataLoader.getEstimateShippingAndTaxData(getJsonFile(), FormFieldType.FIELD, DataProviderNames.INCORRECT_ZIP);
    }
}
