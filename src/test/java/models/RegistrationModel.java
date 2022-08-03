package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@Builder
public class RegistrationModel {

    private String zipCode;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

}
