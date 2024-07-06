// TransactionController.java
package com.example.expensetracker.controller;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.TransactionCreate;
import com.example.expensetracker.model.Wallet;
import com.example.expensetracker.repository.WalletRepository;
import com.example.expensetracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private WalletRepository walletRepository;

    @PostMapping
    public Transaction createTransaction(@RequestBody TransactionCreate transactionCreate) {
        Wallet wallet = walletRepository.findById(transactionCreate.getWalletId()).orElseThrow(() -> new RuntimeException("From wallet not found"));
        Transaction transaction = new Transaction(
                transactionCreate.getAmount(),
                transactionCreate.getType(),
                wallet
        );
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Long userId) {
        List<Transaction> transactions =  transactionService.getTransactionsByUser(userId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/wallet/{walletId}")
    public ResponseEntity<List<Transaction>> getTransactionsByWallet(@PathVariable Long walletId) {
        List<Transaction> transactions =  transactionService.getTransactionsByWallet(walletId);
        return ResponseEntity.ok(transactions);
    }
}