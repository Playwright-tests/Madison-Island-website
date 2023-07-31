package dataProvider;

import org.testng.annotations.DataProvider;
import utils.JSONReader;
import utils.Pair;

import java.util.List;

public class Provider {

    @DataProvider(name = "incorrectEmail")
    public Object[] incorrectEmail() {

        List<Pair<String, String>> data = JSONReader.get("login", "incorrectEmail", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "emptyEmailField")
    public Object[] emptyEmailField() {

        List<Pair<String, String>> data = JSONReader.get("login", "emptyEmailField", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "incorrectPassword")
    public Object[] incorrectPassword() {

        List<Pair<String, String>> data = JSONReader.get("login", "incorrectPassword", new Pair<>("email", "password"));

        return new Object[] {data};
    }

    @DataProvider(name = "emptyPasswordField")
    public Object[] emptyPasswordField() {

        List<Pair<String, String>> data = JSONReader.get("login", "emptyPasswordField", new Pair<>("email", "password"));

        return new Object[] {data};
    }
}
