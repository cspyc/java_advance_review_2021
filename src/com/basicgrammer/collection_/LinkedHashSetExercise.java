package com.basicgrammer.collection_;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Pi
 * @date 2021-04-18 20:11
 */
@SuppressWarnings({"all"})
public class LinkedHashSetExercise {

    public static void main(String[] args) {
        Set cars = new LinkedHashSet();
        cars.add(new Car("GT86", 10000.00));
        cars.add(new Car("Honda", 10000));
        cars.add(new Car("GT86", 10000.00));
        System.out.println(cars);
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car cat = (Car) o;
        return Double.compare(cat.price, price) == 0 && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
