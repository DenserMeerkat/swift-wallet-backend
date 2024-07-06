// AuthController.java
package com.example.expensetracker.controller;

import com.example.expensetracker.model.EmailPassword;
import com.example.expensetracker.model.User;
import com.example.expensetracker.model.UserCreate;
import com.example.expensetracker.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody UserCreate user) {
        User createUser = new User(user.getName(), user.getEmail(), user.getPassword());
        User newUser = authService.signUp(createUser);
        System.out.println(newUser);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody EmailPassword user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User newUser = authService.signIn(email, password);
        System.out.println(newUser);
        return ResponseEntity.ok(newUser);
    }
}