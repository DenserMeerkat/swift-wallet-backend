package com.example.expensetracker.model;

import lombok.Getter;

@Getter
public class EmailPassword {
    private String email;
    private String password;

    public EmailPassword() {
    }

    public EmailPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
