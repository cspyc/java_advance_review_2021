package com.object.codeblock;

/**
 * @author pi
 * @date 2021/04/10 17:42:24
 **/
public class CodeBlockDetail02 {
    public static void main(String[] args) {
        AAB aab = new AAB();
    }
}

class AAB{
    //普通属性
    public int n2 = getN2();

    //普通代码块
    {
        System.out.println("普通代码块初始化.....");
    }

    private int getN2() {
        System.out.println("普通属性初始化.....");
        return 200;
    }


    //静态属性
    public static int n1 = getN1();

    //静态代码块
    static {
        System.out.println("AAB类中的静态代码块初始化......");
    }

    private static int getN1() {
        System.out.println("AAB类的静态属性初始化.....");
        return 100;
    }

    public AAB(){
        System.out.println("构造器初始化....");
    }

}