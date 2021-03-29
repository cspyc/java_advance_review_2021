package com.exercise.homework04;

/**
 * @author pi
 * @date 2021/03/25 17:17:02
 **/
public class Homework04 {
    public static void main(String[] args) {
        Worker tome = new Worker("Tome", 100, 22,1.1);
        tome.printSalary();

        Manager king = new Manager("King", 300, 22,1.3);
        king.setBonus(1000);
        king.printSalary();
    }
}
