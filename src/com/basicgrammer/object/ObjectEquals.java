package com.basicgrammer.object;

/**
 * @author pi
 * @date 2021/03/24 20:55:58
 **/
public class ObjectEquals {
    public static void main(String[] args) {
        Person p1 = new Person("Tim",20,'男');

        Person p2 = new Person("Tom",20,'男');
        System.out.println(p1.equals(p2));
    }
}
