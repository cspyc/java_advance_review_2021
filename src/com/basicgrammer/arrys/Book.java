package com.basicgrammer.arrys;

/**
 * @author Pi
 * @date 2021-04-16 20:48
 */
public class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" + this.name + "," + this.price + "}";
    }
}
