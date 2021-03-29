package com.exercise.homework08;

/**
 * @author pi
 * @date 2021/03/25 21:36:07
 **/
public class Homework08 {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.3);
        savingsAccount.deposit(100);
        savingsAccount.deposit(200);
        savingsAccount.withdraw(300);
        savingsAccount.withdraw(100);
        System.out.println("余额:" + savingsAccount.getBalance());//899
        System.out.println("月利率" + savingsAccount.earnMonthlyInterest());
        savingsAccount.withdraw(99);
        System.out.println("余额:" + savingsAccount.getBalance());//899
    }
}
