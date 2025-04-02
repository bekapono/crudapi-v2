package com.crudapiv2.dto;

public class UserRequestDTO {

    // Key Fields
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String password;

    // constructors
    public UserRequestDTO(String username, String email, String firstname, String lastname, String password) {
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    // getters only, no setters so state can't be altered after creation.
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getPassword() { return password; }
}
