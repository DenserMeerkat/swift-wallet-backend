package com.example.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    public Wallet(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transactions = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", userId=" + (user != null ? user.getId() : "null") +
                '}';
    }
}