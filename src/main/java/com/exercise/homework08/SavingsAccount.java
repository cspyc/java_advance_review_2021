package com.exercise.homework08;

/**
 * @author pi
 * @date 2021/03/25 21:24:28
 * @desc 每个月都有利息产生，并且每月三次免手续费的存款或取款
 **/
public class SavingsAccount extends BankAccount {
    private double interestRate;
    private int freeTimes = 3;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setFreeTimes(int freeTimes) {
        this.freeTimes = freeTimes;
    }

    @Override
    public void deposit(double amount) {
        if (this.freeTimes > 0) {
            super.deposit(amount);
            this.freeTimes -= 1;
        } else {
            super.deposit(amount);
            super.payServiceCharge(1);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (this.freeTimes > 0) {
            super.withdraw(amount);
            this.freeTimes -= 1;
        } else {
            super.withdraw(amount);
            super.payServiceCharge(1);
        }
    }

    public double earnMonthlyInterest() {
        double monthlyInterest = this.getBalance() * this.interestRate;
        this.resetFreeTimes();
        return monthlyInterest;
    }

    private void resetFreeTimes() {
        this.freeTimes = 3;
    }
}
