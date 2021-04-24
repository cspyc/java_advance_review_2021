package com.basicgrammer.homeworks.homework06;

/**
 * @author Pi
 * @date 2021-04-13 15:24
 */
public class Car {
    private double temperature;

    class Air {
        public void flow() {
            if (temperature < 0) {
                System.out.println("空调吹暖风.....");
            } else if (temperature > 40) {
                System.out.println("空调吹冷风......");
            } else {
                System.out.println("空调未启动");
            }
        }
    }

    public Air getCarAir(){
        return new Air();
    }
    public Car(double temperature) {
        this.temperature = temperature;
    }
}
