package objectModels;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public RegistrationModel() {
    }

    public RegistrationModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

