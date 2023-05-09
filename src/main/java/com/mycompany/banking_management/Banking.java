package com.mycompany.banking_management;

import java.util.Random;
import java.util.Scanner;

public class Banking {

    public static void main(String[] args) {
        int option = 0, number;
        double balance;
        Bank bank = new Bank("EasyMoney");
        Account account;
        String name;
        Scanner scan = new Scanner(System.in);
        
        while (option != 6) {
            System.out.println("Main Menu");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposite");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            option = scan.nextInt();
            scan.nextLine();

            switch(option){
                case 1:
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter Account Name: ");
                    name = scan.nextLine();
                    System.out.println("Enter Initial Balance: ");
                    balance = scan.nextDouble();
                    number = generateAccountNumber();
    
                    account = new Account(number,name, balance);
                    bank.openAccount(account);
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    break;
            }
            System.out.println();
        }

    }
    public static int generateAccountNumber(){
        Random rand = new Random();
        int number = 100000 + rand.nextInt(900000);
        return number;
    }
}
