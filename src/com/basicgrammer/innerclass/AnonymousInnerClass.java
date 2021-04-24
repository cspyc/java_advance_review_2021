package com.basicgrammer.innerclass;

/**
 * @author pi
 * @date 2021/04/12 14:26:56
 **/
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.method();
    }
}

class Outer02 {
    //属性
    private int n1 = 10;
    //方法
    public void method(){
        //1.需求： 想使用IA接口,并创建对象
        //2.传统方式，是写一个类，实现该接口，并创建对象
        //3.需求是 Tiger/Dog 类只是使用一次，后面再不使用
//        Animal tiger = new Tiger();
//        tiger.eat();
//        Animal dog = new Dog();
//        dog.eat();
        //使用匿名内部类来简化开发
        //基于接口的匿名内部类
        IAnimal tiger = new IAnimal() {
            @Override
            public void eat() {
                System.out.println("小脑斧在吃肉.....");
            }
        };
        tiger.eat();
        IAnimal dog = new IAnimal() {
            @Override
            public void eat() {
                System.out.println("小狗勾在吃shit.....");
            }
        };
        dog.eat();

        //基于类的匿名内部类
        Father f = new Father("peter"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写Test方法");
            }
        };
        f.test();

        //基于抽象类的匿名内部类
        Animal a = new Animal() {
            @Override
            void eat() {
                System.out.println("动物吃点啥？");
            }
        };
        a.eat();
    }
}

interface IAnimal {
    void eat();
}

//class Tiger implements Animal{
//    @Override
//    public void eat() {
//        System.out.println("小脑斧在吃肉.....");
//    }
//}
//
//class Dog implements Animal{
//
//    @Override
//    public void eat() {
//        System.out.println("小狗勾在吃shit.....");
//    }
//}

class Father{
    public Father(String name) {
        System.out.println("构造器接收到的name = " + name);
    }

    public void test(){}
}

abstract class Animal{
    abstract void eat();
}