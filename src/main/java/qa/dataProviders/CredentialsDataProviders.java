package qa.dataProviders;

import org.testng.annotations.DataProvider;
import qa.base.BaseDataProviders;
import qa.testdataloader.TestdataLoader;
import qa.support.dataprovidernames.DataProviderNames;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CredentialsDataProviders extends BaseDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws IOException {

        return TestdataLoader.getCredentials(getJsonFile(), DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL)
    public Object[] incorrectEmail() throws IOException {

        return TestdataLoader.getCredentials(getJsonFile(), DataProviderNames.INCORRECT_EMAIL);
    }

    @DataProvider(name = DataProviderNames.BLANK_EMAIL_FIELD)
    public Object[] blankEmailField() throws IOException {

        return TestdataLoader.getCredentials(getJsonFile(), DataProviderNames.BLANK_EMAIL_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PASSWORD)
    public Object[] incorrectPassword() throws IOException {

        return TestdataLoader.getCredentials(getJsonFile(), DataProviderNames.INCORRECT_PASSWORD);
    }

    @DataProvider(name = DataProviderNames.BLANK_PASSWORD_FIELD)
    public Object[] blankPasswordField() throws IOException {

        return TestdataLoader.getCredentials(getJsonFile(), DataProviderNames.BLANK_PASSWORD_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL_FORMAT)
    public Object[] incorrectEmailFormat() throws FileNotFoundException {

        return TestdataLoader.getCredentials(getJsonFile(), DataProviderNames.INCORRECT_EMAIL_FORMAT);
    }
}
