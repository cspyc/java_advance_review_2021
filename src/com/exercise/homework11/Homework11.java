package com.exercise.homework11;

/**
 * @author pi
 * @date 2021/03/26 11:08:32
 **/
public class Homework11 {
    public static void main(String[] args) {
        //向上转型
        Person p = new Student("Lily", 10);
        p.eat();//Lily正在吃饭
        p.run();//学生：Lily正在奔跑

        //向下转型
        if (p instanceof Student) {
            Student s = (Student) p;
            s.run();//学生：Lily正在奔跑
            s.study();//学生：Lily正在学习
            s.eat();//Lily正在吃饭
        }

    }
}
