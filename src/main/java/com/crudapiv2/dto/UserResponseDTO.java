package com.crudapiv2.dto;

public class UserResponseDTO {
    // dto defines what's API returns when someone calls any endpoint sends user
    //  data back to the client.

    // Key Fields
    private final String username;
    private final String email;
    private final String firstname;
    private final String lastname;

    // Object will be immutable, hence need constructor to set fields.
    public UserResponseDTO(String username, String email, String firstname, String lastname) {
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;


    }

    // getters only, no setters so state can't be altered after creation.
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
}
