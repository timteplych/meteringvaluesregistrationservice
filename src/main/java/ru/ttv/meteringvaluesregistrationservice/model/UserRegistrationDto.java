package ru.ttv.meteringvaluesregistrationservice.model;

import lombok.Getter;
import lombok.Setter;
import ru.ttv.meteringvaluesregistrationservice.constraint.FieldMatch;

import javax.validation.constraints.NotEmpty;

/**
 * @author Teplykh Timofey  10.03.2019
 */
@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
@Getter
@Setter
public class UserRegistrationDto {
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

}
