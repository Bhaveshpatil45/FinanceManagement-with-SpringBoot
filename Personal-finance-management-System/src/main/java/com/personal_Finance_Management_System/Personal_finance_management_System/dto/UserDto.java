package com.personal_Finance_Management_System.Personal_finance_management_System.dto;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;

public class UserDto {

    private String username;
    private String password;
    private String email;

    public UserDto() {};

    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
