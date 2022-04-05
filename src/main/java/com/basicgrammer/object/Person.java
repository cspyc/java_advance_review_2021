package com.basicgrammer.object;

/**
 * @author pi
 * @date 2021/03/24 20:56:20
 **/
public class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if (this.name.equals(person.name) &&
                    this.age == person.age &&
                    this.gender == person.gender) {
                return true;
            }
        }
        return false;
    }
}
