package com.basicgrammer.codeblock;

/**
 * @author pi
 * @date 2021/04/10 20:19:36
 **/
public class CodeBlockDetail03 {
    public static void main(String[] args) {
        ChildA childA = new ChildA();
    }
}

class SuperA {
    //父类静态属性
    public static int n1 = getN1();

    //输出顺序：1
    private static int getN1() {
        System.out.println("父类静态属性初始化....");
        return 100;
    }
    //输出顺序：2
    //父类静态代码块
    static {
        System.out.println("父类静态代码块初始化.....");
    }
    //父类普通属性
    public int n2 = getN2();

    //输出顺序：5
    private int getN2() {
        System.out.println("父类普通属性初始化");
        return 200;
    }
    //输出顺序：6
    //父类普通代码块
    {
        System.out.println("父类普通代码块初始化.....");
    }
    //输出顺序：7
    //父类构造器
    public SuperA() {
        //super
        //普通成员初始化
        System.out.println("父类构造器初始化.....");
    }
}

class ChildA extends SuperA{
    //子类静态属性
    public static int n1 = getN1();

    //输出顺序：3
    private static int getN1() {
        System.out.println("子类静态属性初始化....");
        return 100;
    }

    //输出顺序：4
    //子类静态代码块
    static {
        System.out.println("子类静态代码块初始化.....");
    }

    //子类普通属性
    public int n2 = getN2();
    //输出顺序：8
    private int getN2() {
        System.out.println("子类普通属性初始化");
        return 200;
    }
    //输出顺序：9
    //子类普通代码块
    {
        System.out.println("子类普通代码块初始化.....");
    }
    //输出顺序：10
    //子类构造器
    public ChildA() {
        //super
        //普通成员初始化
        System.out.println("子类构造器初始化.....");
    }
}
