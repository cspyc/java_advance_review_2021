package com.basicgrammer.generic;

import java.util.*;

/**
 * @author Pi
 * @date 2021-04-21 16:30
 */
public class GenericExercise {
    public static void main(String[] args) {
        //需求：创建3个学生对象
        //放入到HashSet中
        //放到到HashMap中，要求Key就是String name,Value就是学生对象
        //使用两种方式遍历

        Student student = new Student("小1", 1);
        Student student1 = new Student("小2", 2);
        Student student2 = new Student("小3", 3);

        System.out.println("========使用HashSet=======");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student);
        studentSet.add(student1);
        studentSet.add(student2);

        Iterator<Student> iterator = studentSet.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next);
        }

        System.out.println("=========使用HashMap============");
        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put(student.getName(), student);
        studentMap.put(student1.getName(), student1);
        studentMap.put(student2.getName(), student2);

        Set<String> studentMapKey = studentMap.keySet();
        for (String key : studentMapKey) {
            System.out.println(key + "-" + studentMap.get(key));
        }

        System.out.println("使用迭代器遍历");
        Set<Map.Entry<String, Student>> studentMapEntrySet = studentMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator1 = studentMapEntrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Student> next = iterator1.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
    }
}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
