package com.exercise.homework01;

/**
 * @author pi
 * @date 2021/03/25 15:54:59
 **/
public class PersonArray {
    public static void main(String[] args) {
        //需求：定义一个Person类{name,age,job},初始化Person对象数组，有3个person对象，并按照age 从大到小进行排序
        //使用冒泡排序
        Person[] p = new Person[3];
        p[0] = new Person("Tom", 29, "工人");
        p[1] = new Person("Mary", 25, "农场主");
        p[2] = new Person("Henry", 31, "教师");

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }

        System.out.println("==============排序后================");
        PersonArray personArray = new PersonArray();
        Person[] sortedArray = personArray.bubbleSort(p);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }

    private Person[] bubbleSort(Person[] people) {
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
}
