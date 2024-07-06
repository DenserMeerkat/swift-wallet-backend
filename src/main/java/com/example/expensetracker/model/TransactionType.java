package com.example.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    INCOME("income"),
    EXPENSE("expense");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TransactionType fromValue(String value) {
        for (TransactionType type : TransactionType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value);
    }
}
