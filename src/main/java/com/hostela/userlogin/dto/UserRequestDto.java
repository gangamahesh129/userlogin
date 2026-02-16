package com.hostela.userlogin.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Data
@NoArgsConstructor
public  class UserRequestDto {

    private Integer userid;

    @NotBlank(message = "first name is missing")
    private String fName;

    @NotBlank(message = "last name is missing")
    private String lName;

    @Email(message = "invalid email format")
    @NotBlank(message = "gmail is missing")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$",
            message = "email must be a valid gmail address"
    )
    private String gmail;

    @NotBlank(message = "phone number is missing")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "invalid phone number format"
    )
    private String phoneNumber;

    private String profilePicture;

    @NotBlank(message = "password is missing")
    private String password;


}
