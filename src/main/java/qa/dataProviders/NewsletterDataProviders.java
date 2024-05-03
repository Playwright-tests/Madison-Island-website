package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.testdataloader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class NewsletterDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] newsletterCorrectEmail() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL_FORMAT)
    public Object[] newsletterIncorrectEmailFormat() throws FileNotFoundException {

        return ModelsBuilder.getStrings(DataProviderNames.INCORRECT_EMAIL_FORMAT);
    }
}
