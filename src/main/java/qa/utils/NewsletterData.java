package qa.utils;

public class NewsletterData {

    private final String email;
    private final String validationMessage;


    public NewsletterData() {

        this.email = null;
        this.validationMessage = null;
    }

    public NewsletterData(String email, String validationMessage) {

        this.email = email;
        this.validationMessage = validationMessage;
    }

    public String getEmail() {

        return email;
    }

    public String getValidationMessage() {

        return validationMessage;
    }
}
