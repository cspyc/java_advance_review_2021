package com.basicgrammer.homeworks.homework03;

/**
 * @author Pi
 * @date 2021-04-13 14:18
 */
public class Homework03 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculator() {
            @Override
            public double work(double n1, double n2) {

                return n1 * n2;
            }
        }, 10, 8);
    }
}
