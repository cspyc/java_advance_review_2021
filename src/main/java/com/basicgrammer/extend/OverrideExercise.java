package com.basicgrammer.extend;

/**
 * @author pi
 * @date 2021/03/23 16:56:21
 **/
public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("ζζ",22);
        Student student = new Student("ηδΊ",23,"123456",100.00);

        System.out.println(person.say());
        System.out.println(student.say());

    }
}
