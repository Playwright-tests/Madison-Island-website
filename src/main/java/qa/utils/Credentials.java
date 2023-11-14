package qa.utils;

public class Credentials {

    public final String email;
    public final String password;


    public Credentials() {

        this.email = null;
        this.password = null;
    }

    public Credentials(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public Credentials(NewsletterData newsletterData) {

        this.email = newsletterData.getEmail();
        this.password = "";
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }
}
