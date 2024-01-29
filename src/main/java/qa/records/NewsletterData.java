package qa.records;

import lombok.Getter;

@Getter
public class NewsletterData {

    private final String email;

    public NewsletterData(String email) {

        this.email = email;
    }
}
