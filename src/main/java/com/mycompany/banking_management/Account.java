package com.mycompany.banking_management;

public class Account {
    private int number;
    private String name;
    private double balance;

    public Account(int number, String name, double balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance += amount;

    }
    public void withdraw(double amount){
        this.balance -= amount;

    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return number;
    }

    public String getAccountName() {
        return name;
    }
}