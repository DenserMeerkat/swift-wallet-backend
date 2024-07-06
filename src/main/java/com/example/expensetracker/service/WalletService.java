// WalletService.java
package com.example.expensetracker.service;

import com.example.expensetracker.model.User;
import com.example.expensetracker.model.Wallet;
import com.example.expensetracker.model.WalletCreate;
import com.example.expensetracker.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(User user, WalletCreate walletCreate) {

        Wallet wallet = new Wallet(
            walletCreate.getName(),
            walletCreate.getBalance()
        );
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    public List<Wallet> getWalletsByUser(Long userId) {
        return walletRepository.findByUserId(userId);
    }
}
