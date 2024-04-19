package com.appsdeveloperblog.photoapp.api.users.PhotoAppApiUsers.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @NotNull(message = "First name cannot be null")
    @Size(min = 2,message = "it should be minimum of 2 chars")
    public String firstname;
    @NotNull(message = "last name cannot be null")
    @Size(min = 2,message = "it should be minimum of 2 chars")
    public String lastname;
    @NotNull(message = "password cannot be null")
    @Size(min = 2,max = 4,message = "it should be minimum of 2 chars and max is 4")
    public String password;
    @NotNull(message = "email cannot be null")
    @Email
    public String emailid;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
}
