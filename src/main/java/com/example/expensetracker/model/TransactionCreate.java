package com.example.expensetracker.model;

import javax.persistence.*;

import lombok.Data;

@Data
public class TransactionCreate {
    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private long walletId;
}
