package com.mycompany.banking_management;

public class Account {
    private int accountNumber;
    private String accountName;
    private double balance;

    public Account(int accountNumber,String accountName,double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public  void withDraw(double amount){
        this.balance = this.balance - amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public String getAccountName(String accountName){
        return this.accountName;
    }
}
