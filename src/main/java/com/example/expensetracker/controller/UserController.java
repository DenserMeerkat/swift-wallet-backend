// UserController.java
package com.example.expensetracker.controller;

import com.example.expensetracker.model.User;
import com.example.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public Optional<User> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}