package com.fuelngo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "applicationusers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email_address;
    private String username;
    private String password;

    public User() {
    }

    public User(String email_address, String username, String password) {
        this.email_address = email_address;
        this.username = username;
        this.password = password;
    }
}
