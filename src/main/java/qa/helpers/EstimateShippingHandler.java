package qa.helpers;

import qa.enums.EstimateShippingFormMethods;
import qa.pageobject.shoppingcart.EstimatedShippingAndTaxForm;
import qa.records.EstimateShippingAndTaxData;
import qa.utils.MethodsRetriever;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EstimateShippingHandler {

    private static String[] toArray(EstimateShippingAndTaxData data) {

        return new String[]{ data.getCity(), data.getStateOrProvince(), data.getZip() };
    }

    public static void set(EstimatedShippingAndTaxForm form, EstimateShippingAndTaxData data, EstimateShippingFormMethods excluded) throws InvocationTargetException, IllegalAccessException {

        MethodsRetriever<EstimatedShippingAndTaxForm> retriever = new MethodsRetriever<>(EstimatedShippingAndTaxForm.class);
        Method[] methods = retriever.getMethods();
        String[] estimateData = toArray(data);

        for (int i = 0; i < methods.length; i++) {

            if (!methods[i].getName().equalsIgnoreCase(excluded.getName())) {

                methods[i].invoke(form, estimateData[i]);
            }
        }
    }
}
