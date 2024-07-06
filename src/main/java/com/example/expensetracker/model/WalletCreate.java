package com.example.expensetracker.model;

import lombok.Data;

@Data
public class WalletCreate {

    private String name;

    private double balance;

    @Override
    public String toString() {
        return "WalletCreate{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
