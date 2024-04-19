package com.appsdeveloperblog.mobileappws.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestModel {
    @NotNull(message = "firstName cannot be empty")
    private String firstName;
    @NotNull(message = "lastName cannot be empty")
    private String lastName;
    @NotNull(message = "emailId cannot be empty")
    @Email
    private String emailId;
    @NotNull(message = "password cannot be empty")
    @Size(min = 2,max = 6,message = "password should be between 2 and 6 characters")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
