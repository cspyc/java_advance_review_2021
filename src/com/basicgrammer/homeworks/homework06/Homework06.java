package com.basicgrammer.homeworks.homework06;

/**
 * @author Pi
 * @date 2021-04-13 15:26
 */
public class Homework06 {
    public static void main(String[] args) {
        Car car = new Car(41);
        Car.Air car1Air = car.getCarAir();
        car1Air.flow();

        Car car2 = new Car(-10.1);
        Car.Air car2Air = car2.getCarAir();
        car2Air.flow();

        Car car1 = new Car(22.3);
        Car.Air car3Air = car1.getCarAir();
        car3Air.flow();
    }
}
