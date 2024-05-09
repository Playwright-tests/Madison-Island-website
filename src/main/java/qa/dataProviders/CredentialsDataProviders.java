package qa.dataProviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.ModelsBuilder;
import qa.support.DataProviderNames;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CredentialsDataProviders {

    @DataProvider(name = DataProviderNames.CORRECT)
    public Object[] correct() throws IOException {

        return ModelsBuilder.getCredentials(DataProviderNames.CORRECT);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL)
    public Object[] incorrectEmail() throws IOException {

        return ModelsBuilder.getCredentials(DataProviderNames.INCORRECT_EMAIL);
    }

    @DataProvider(name = DataProviderNames.BLANK_EMAIL_FIELD)
    public Object[] blankEmailField() throws IOException {

        return ModelsBuilder.getCredentials(DataProviderNames.BLANK_EMAIL_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_PASSWORD)
    public Object[] incorrectPassword() throws IOException {

        return ModelsBuilder.getCredentials(DataProviderNames.INCORRECT_PASSWORD);
    }

    @DataProvider(name = DataProviderNames.BLANK_PASSWORD_FIELD)
    public Object[] blankPasswordField() throws IOException {

        return ModelsBuilder.getCredentials(DataProviderNames.BLANK_PASSWORD_FIELD);
    }

    @DataProvider(name = DataProviderNames.INCORRECT_EMAIL_FORMAT)
    public Object[] incorrectEmailFormat() throws FileNotFoundException, JsonProcessingException {

        return ModelsBuilder.getCredentials(DataProviderNames.INCORRECT_EMAIL_FORMAT);
    }
}
