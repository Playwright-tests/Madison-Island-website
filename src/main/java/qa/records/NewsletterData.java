package qa.records;

import lombok.Getter;

@Getter
public class NewsletterData {

    private final String email;
    private final String validationMessage;
    public NewsletterData(String email, String validationMessage) {

        this.email = email;
        this.validationMessage = validationMessage;
    }
}
