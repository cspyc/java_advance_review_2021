package com.basicgrammer.collection_.excercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Pi
 * @date 2021-04-21 13:53
 */
@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        //需求：使用ArrayList完成对  对象 Car{name,price}的各种操作
        //add
        //remove
        //contains
        //size
        //isEmpty
        //clear
        //addAll
        //containsAll
        //removeAll
        //使用增强for和迭代器来遍历所有的car，需要重写Car的toString方法

        List cars = new ArrayList();
        cars.add(new Car("宝马", 400000));
        cars.add(new Car("宾利", 50000000));

        //遍历
        System.out.println("=================foreach遍历=================");
        for (Object car : cars) {
            Car c = (Car) car;
            System.out.println(c);
        }

        System.out.println("=================迭代器遍历=================");
        Iterator iterator = cars.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Car car = (Car) next;
            System.out.println(car);
        }

        System.out.println("============方法测试===========");
        System.out.println("=======add==========");
        //add
        cars.add(new Car("五菱汽车", 30000));
        System.out.println(cars);
        //remove
        System.out.println("=======remove==========");
        cars.remove(1);
        System.out.println(cars);
        //contains
        System.out.println("=======contains==========");
        boolean flag = cars.contains(new Car("宝马", 400000));
        System.out.println("是否存在宝马汽车：" + flag);
        //size
        System.out.println("数组元素个数：" + cars.size());
        //isEmpty
        //clear
        //addAll
        //containsAll
        //removeAll

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
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
