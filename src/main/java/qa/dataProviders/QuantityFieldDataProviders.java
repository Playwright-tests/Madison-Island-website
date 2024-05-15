package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.support.ModelsBuilder;
import qa.support.DataProviderNames;

import java.io.FileNotFoundException;

public class QuantityFieldDataProviders {

    @DataProvider(name = DataProviderNames.FLOATING_POINT)
    public Object[] floatingPoint() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.FLOATING_POINT);
    }

    @DataProvider(name = DataProviderNames.NOT_NUMBER)
    public Object[] notANumber() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.NOT_NUMBER);
    }

    @DataProvider(name = DataProviderNames.NEGATIVE)
    public Object[] negative() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.NEGATIVE);
    }
}
