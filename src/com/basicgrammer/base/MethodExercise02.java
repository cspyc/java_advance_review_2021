package com.basicgrammer.base;

public class MethodExercise02{
    public static void main(String[] args){
        //需求：编写一个方法copyPerson，可以复制一个Person对象,返回复制的对象。克隆对象
        //注意要求得到新对象和原来的乘飞机是两个独立的对象。只是他们的属性相同
        Person person = new Person("张一",'男',18);
        //自我无性复制、繁殖
        Person clonePerson = person.copyPerson();

        System.out.println("原始人：地址-：" + person);
        System.out.println("克隆人：地址-：" + clonePerson + ";克隆人姓名：" + clonePerson.getName() +",性别：" + clonePerson.getGender() + ",年龄：" + clonePerson.getAge());
    }
}

class Person{
    private String name;
    private char gender;
    private int age;

    public Person(){}

    public Person(String name,char gender,int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }
    private void setGender(char gender) {
        this.gender = gender;
    }
    private void setAge(int age){
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public char getGender() {
        return this.gender;
    }
    public int getAge(){
        return this.age;
    }

     public Person copyPerson(){
        Person clonePerson = new Person();
        clonePerson.setName(this.getName());
        clonePerson.setGender(this.getGender());
        clonePerson.setAge(this.getAge());

        return clonePerson;
    }
}
