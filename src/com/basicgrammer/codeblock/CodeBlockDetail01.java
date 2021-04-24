package com.basicgrammer.codeblock;

/**
 * @author pi
 * @date 2021/04/10 16:04:41
 **/
public class CodeBlockDetail01 {

    public static void main(String[] args) {
        //1.创建对象实例时(new)
        //AA a1 = new AA();
        //2.创建子类对象实例，父类也会被加载
        //BB b1 = new BB();
        //3.使用类的静态成员时(静态属性,静态方法)
        System.out.println(Cat.n1);
    }
}

class Cat {
    //静态属性
    public static int n1 = 99;

    static {
        System.out.println("Cat 的静态代码块被执行。。。。。");
    }
}
class AA{
    static {
        System.out.println("AA类中静态代码块被加载。。。");
    }
}

class BB extends AA{
    static {
        System.out.println("BB类中静态代码块被加载。。。。。");
    }
}