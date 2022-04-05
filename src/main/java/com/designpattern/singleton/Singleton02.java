package com.designpattern.singleton;


/**
 * @author pi
 * @date 2021/04/10 20:59:04
 **/
public class Singleton02 {
    public static void main(String[] args) {
        //单例模式-懒汉式

        //测试在没有调用getInstance时，是否会创建实例
        System.out.println(Dog.n1);

        Dog instance = Dog.getInstance();
        System.out.println(instance);

        Dog instance2 = Dog.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);
    }
}

class Dog {
    public static int n1 = 100;
    private String name;
    //实现单例模式-懒汉式 -只有在被调用时，才创建对象。  饿汉式与懒汉式利用静态成员在类加载机制中的特性来实现的
    //实现步骤：
    //1.私有化构造器
    //2.定义一个静态实例对象
    //3.定义一个静态公共方法，供外部调用

    private static Dog dog;

    public static Dog getInstance() {
        if (dog == null) {
            dog = new Dog("小黑");
        }
        return dog;
    }

    private Dog(String name) {
        System.out.println("构造器初始化");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
