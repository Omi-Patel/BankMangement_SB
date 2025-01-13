package com.ompatel.bankManagement.model;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_number;
    @Column
    private String account_name;
    @Column
    private Double balance;

    public Account(){}

    public Account(Long account_number, String account_name, Double balance) {
        this.account_number = account_number;
        this.account_name = account_name;
        this.balance = balance;
    }

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
