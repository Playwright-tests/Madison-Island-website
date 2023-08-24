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

    @DataProvider(name = "footerCompany")
    public Object[] footerCompany() {

        String[] data = JSONReader.get("URLs", "footer_1");

        return new Object[] {data};
    }

    @DataProvider(name = "footerQuickLinks")
    public Object[] footerQuickLinks() {

        String[] data = JSONReader.get("URLs", "footer_2");

        return new Object[] {data};
    }

    @DataProvider(name = "footerAccount")
    public Object[] footerAccount() {

        String[] data = JSONReader.get("URLs", "footer_3");

        return new Object[] {data};
    }

    @DataProvider(name = "footerConnectWithUs")
    public Object[] footerConnectWithUs() {

        String[] data = JSONReader.get("URLs", "footer_4");

        return new Object[] {data};
    }
}
