package com.exercise.homework05;

/**
 * @author pi
 * @date 2021/03/25 19:20:24
 **/
public class Homework05 {
    public static void main(String[] args) {
        Worker tom = new Worker("Tom",1000);
        tom.setSalMonth(13);
        tom.printAnnual();

        Peasant mary = new Peasant("Mary", 500);
        mary.printAnnual();

        Teacher karry = new Teacher("Karry", 1500, 100, 50);
        karry.printAnnual();

        Scientist tim = new Scientist("Tim", 5000);
        tim.setBonus(10000);
        tim.printAnnual();

        Waiter jacky = new Waiter("Jacky", 1100);
        jacky.printAnnual();
    }
}
