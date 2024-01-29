package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.json.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;

import java.io.FileNotFoundException;

public class NewsletterDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] newsletterCorrectEmail() throws FileNotFoundException {

        return TestdataLoader.getNewsletterData(getJsonFile(), DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL_FORMAT)
    public Object[] newsletterIncorrectEmailFormat() throws FileNotFoundException {

        return TestdataLoader.getNewsletterData(getJsonFile(), DataProviderNames.INCORRECT_EMAIL_FORMAT);
    }
}
