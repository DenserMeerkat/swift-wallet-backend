// TransactionService.java
package com.example.expensetracker.service;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.User;
import com.example.expensetracker.model.Wallet;
import com.example.expensetracker.repository.TransactionRepository;
import com.example.expensetracker.repository.UserRepository;
import com.example.expensetracker.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Transaction> getTransactionsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Transaction> userTransactions = new ArrayList<>();

        for (Wallet wallet : user.getWallets()) {
            List<Transaction> transactions = transactionRepository.findByWalletId(wallet.getId());
            userTransactions.addAll(transactions);
        }

        return userTransactions;
    }

    public Transaction createTransaction(Transaction transaction) {
        transaction.setCreatedAt(new Date());
        Wallet wallet = walletRepository.findById(transaction.getWallet().getId())
                .orElseThrow(() -> new RuntimeException("From wallet not found"));
        wallet.setBalance(wallet.getBalance() - transaction.getAmount());
        walletRepository.save(wallet);

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByWallet(Long walletId) {
        return transactionRepository.findByWalletId(walletId);
    }
}