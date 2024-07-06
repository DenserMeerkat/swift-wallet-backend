package com.example.expensetracker.model;

import lombok.Data;

@Data
public class UserCreate {
    private String name;

    private String email;

    private String password;
}
