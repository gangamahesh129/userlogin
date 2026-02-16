package com.hostela.userlogin.dto;

import lombok.Data;

@Data

public  class UserDto {

    private Integer userid;
    private String fName;
    private String lName;
    private String gmail;
    private String phoneNumber;
    private String profilePicture;
    private String password;

}
