// WalletController.java
package com.example.expensetracker.controller;

import com.example.expensetracker.model.User;
import com.example.expensetracker.model.Wallet;
import com.example.expensetracker.model.WalletCreate;
import com.example.expensetracker.service.UserService;
import com.example.expensetracker.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}")
    public Wallet createWallet(@PathVariable Long userId, @RequestBody WalletCreate wallet) {
        User user = userService.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return walletService.createWallet(user, wallet);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Wallet>> getWalletsByUser(@PathVariable Long userId) {
        List<Wallet> wallets =  walletService.getWalletsByUser(userId);
        return ResponseEntity.ok(wallets);
    }
}