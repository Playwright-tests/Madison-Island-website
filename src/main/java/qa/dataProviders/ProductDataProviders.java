package qa.dataProviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.DataProviderNames;
import qa.support.ModelsBuilder;

public class ProductDataProviders {

    @DataProvider(name = DataProviderNames.PRODUCTS)
    public Object[] productAttributes() throws JsonProcessingException {

        return ModelsBuilder.getProduct(DataProviderNames.PRODUCTS);
    }
}
