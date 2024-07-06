// Transaction.java
package com.example.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    @JsonIgnore
    private Wallet wallet;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Transaction(double amount, TransactionType type, Wallet wallet) {
        this.amount = amount;
        this.type = type;
        this.wallet = wallet;
        this.createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount='" + amount + '\'' +
                ", type=" + type +
                ", walletId=" + (wallet != null ? wallet.getId() : "null") +
                ", createdAt=" + createdAt +
                '}';
    }
}

