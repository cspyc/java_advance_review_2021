package com.exercise.homework08;

/**
 * @author pi
 * @date 2021/03/25 20:45:17
 **/
public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
       balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void payServiceCharge(double amount) {
        this.balance -= amount;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
