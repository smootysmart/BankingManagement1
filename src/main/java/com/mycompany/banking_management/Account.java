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

    public static void deposit(double amount){

    }

    public static void withDraw(double amount){

    }

    public static double getBalance(){
        return 0;
    }

    public static int getAccountNumber(){
        return 0;
    }

    public static String getAccountName(String accountName){
        return accountName;
    }
}
