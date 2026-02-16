package com.hostela.userlogin.dto;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public  class UserDto {

    @Nonnull()
    private Integer userid;
    private String fName;
    private String lName;
    private String gmail;
    private String phoneNumber;
    private String profilePicture;
    private String password;

}
