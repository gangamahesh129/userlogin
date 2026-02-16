package com.hostela.userlogin.jpamodel;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "fname")
    private String fName;

    @Column(name = "lname")
    private String lName;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "profilepicture")
    private String profilePicture;

    @Column(name = "password")
    private String password;


}
