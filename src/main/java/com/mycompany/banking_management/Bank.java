package com.mycompany.banking_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nitro5
 */
public class Bank {
    private String name;
    public Bank(){

    }
    public Bank(String name) {
        this.name = name;
    }

    public void openAccount(Account account){
        Connection connection = BankingConnection.connect();
        String sql = "INSERT INTO account(accNumber,accName,accBalance)"
                    + "VALUES(?,?,?)";
        PreparedStatement preparedstament;
        try {
            preparedstament = connection.prepareStatement(sql);
            preparedstament.setInt(1, account.getAccountNumber());
            preparedstament.setString(2, account.getAccountName());
            preparedstament.setDouble(3, account.getBalance());
            preparedstament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeAccount(int number){
        Connection connection = BankingConnection.connect();
        String sql = "DELETE FROM account "
                    + "WHERE accNumber=?";
        PreparedStatement preparedstament;
        try {
            preparedstament = connection.prepareStatement(sql);
            preparedstament.setInt(1, number);
            preparedstament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void depositMoney(int number,double amount){
        Account account = getAccount(number);
        account.deposit(amount);
        Connection connection = BankingConnection.connect();
        String sql = "UPDATE account SET accBalance=? "
                    + "WHERE accNumber=?";
        PreparedStatement preparedstament;
        try {
            preparedstament = connection.prepareStatement(sql);
            preparedstament.setDouble(1, account.getBalance());
            preparedstament.setInt(2, account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            preparedstament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void withdrawMoney(int number,double amount){
        Account account = getAccount(number);
        account.withdraw(amount);
        Connection connection = BankingConnection.connect();
        String sql = "UPDATE account SET accBalance=? "
                    + "WHERE accNumber=?";
        PreparedStatement preparedstament;
        try {
            preparedstament = connection.prepareStatement(sql);
            preparedstament.setDouble(1, account.getBalance());
            preparedstament.setInt(2, account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            preparedstament.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void saveAccount(Account account){

    }
    public void listAccount(){
        Connection connection = BankingConnection.connect();
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM account";
            ResultSet results = statement.executeQuery(sql);
            while(results.next()){
                System.out.println(results.getString(1)+ " " +results.getString(2)+ " "+
                        results.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    public Account getAccount(int number){
        Connection connection = BankingConnection.connect();
        String sql = "SELECT * FROM account WHERE accNumber=?";
        PreparedStatement preparedstament;
        Account account = null;
        try {
            preparedstament = connection.prepareStatement(sql);
            preparedstament.setInt(1, number);
            ResultSet result = preparedstament.executeQuery();
            result.next();
            String accName = result.getString(2);
            double balance = result.getDouble(3);
            account = new Account(number,accName,balance);
            while(result.next()){
                System.out.println(result.getString(1)+ " " +result.getString(2)+ " "+
                        result.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
}