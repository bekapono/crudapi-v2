package com.crudapiv2;


import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable {

    // No-arg constructor
    public User() {}

    // full constructor
    public User(String username, String email, String firstname, String lastname, String password) {
        this.username= username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    // Attributes - Column identifiers
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name" ,unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username;}

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) {this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) {this.phone = phone; }
}
