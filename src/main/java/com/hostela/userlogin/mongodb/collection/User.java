package com.hostela.userlogin.mongodb.collection;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
@Builder
public class User {
@Id
    private Integer userid;
    private String fName;
    private String lName;
    private String gmail;
    private String phoneNumber;
    private String profilePicture;
    private String password;

}
