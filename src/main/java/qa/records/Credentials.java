package qa.records;

import lombok.Getter;

@Getter
public class Credentials {

    private final String email;
    private final String password;
    private final String message;

    public Credentials(String email, String password, String message) {

        this.email = email;
        this.password = password;
        this.message = message;
    }
}
