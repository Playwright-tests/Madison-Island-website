package tests.factories;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Factory;
import qa.models.Product;
import qa.support.DataProviderNames;
import qa.support.ModelsBuilder;
import qa.support.TestDataLoader;
import tests.shoppingcart.quantityfield.ValidationTest;

public class ShoppingCartQtyValidationFactory {

    @Factory
    public Object[] createInstance() throws JsonProcessingException {

        TestDataLoader.load("products.json");
        Product[] products = ModelsBuilder.getProduct(DataProviderNames.PRODUCTS);
        return new Object[] { new ValidationTest(products[0])};
    }
}
