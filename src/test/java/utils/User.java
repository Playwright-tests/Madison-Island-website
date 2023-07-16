package utils;

public class User {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String emailAddress;
    private final String password;
    private final String confirmedPassword;

    public User(String firstName, String middleName, String lastName, String emailAddress, String password, String confirmedPassword) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getMiddleName() {

        return middleName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public String getPassword() {

        return password;
    }

    public String getConfirmedPassword() {

        return confirmedPassword;
    }
}
