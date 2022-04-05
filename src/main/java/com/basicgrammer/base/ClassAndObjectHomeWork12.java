package com.basicgrammer.base;

public class ClassAndObjectHomeWork12{
    public static void main(String[] args){
        //需求：创建一个Employee类，属性有(名字，性别，年龄，职位，薪水)，提供3个构造方法，可以初始化(1)(名字，性别，年龄，职位，薪水)；(2)(名字，性别，年龄)；(3)(职位，薪水)
        // 要求充分复用构造器
    }
}

class Employee{
    private String name;
    private char gender;
    private int age;
    private String position;
    private double salary;

    //复用构造器
    public Employee(String position,double salary){
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name,char gender,int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String name,char gender,int age,String position,double salary) {
        this(name,gender,age);
        this.position = position;
        this.salary = salary;

    } 

   
}