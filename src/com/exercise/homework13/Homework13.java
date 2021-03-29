package com.exercise.homework13;

import java.util.Arrays;

/**
 * @author pi
 * @date 2021/03/26 12:18:03
 **/
public class Homework13 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("张飞", '男', 30, 5);
        teacher.printInfo();

        Student student = new Student("小明", '男', 15, "00023102");
        System.out.println("=============================");
        student.printInfo();

        Person[] people = new Person[4];
        people[0] = new Student("Tim", '男', 12, "11");
        people[1] = new Student("May", '女', 22, "23");
        people[2] = new Teacher("Jacky", '男', 30, 5);
        people[3] = new Teacher("Mary", '女', 35, 10);

        Homework13 homework13 = new Homework13();
        homework13.bubbleSort(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
            System.out.println("======Do something=========");
            homework13.doSomething(people[i]);
        }
    }

    public Person[] bubbleSort(Person[] people) {
        if (people != null && people.length > 0) {
            Person temp = null;
            for (int i = 0; i < people.length - 1; i++) {
                for (int j = 0; j < people.length - 1 - i; j++) {
                    if (people[j].getAge() < people[j + 1].getAge()) {
                        temp = people[j];
                        people[j] = people[j + 1];
                        people[j + 1] = temp;
                    }
                }
            }
        }
        return people;
    }

    public void doSomething(Person p) {
        if (p instanceof Teacher) {
            ((Teacher) p).teach();
        } else if (p instanceof Student) {
            ((Student) p).study();
        }else {
            System.out.println("do nothing.....");
        }
    }
}
