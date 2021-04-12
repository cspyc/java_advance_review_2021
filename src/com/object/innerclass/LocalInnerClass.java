package com.object.innerclass;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * @author pi
 * @date 2021/04/12 10:30:27
 **/
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m1();
    }
}

class Outer01 {
    private int n1 = 1;

    public void m1() {
        int localValue = 22;

        final class InnerClass01 {
            int n1 = 100;

            public void innerM2() {
                //局部内部类---访问--->外部类的成员[访问方式：直接访问]
                //如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.this.成员)去访问
                System.out.println("inner-n1:" + n1);
                System.out.println("outter-n1:" + Outer01.this.n1);
            }
        }

        InnerClass01 in = new InnerClass01();
        //外部类---访问--->局部内部类的成员[访问方式：创建对象，再访问(必须在作用域内)]
        in.innerM2();
    }
}

class OuterOther {
    public void m1() {
        //外部其他类---不能访问--->局部内部类(因为局部内部类地位类似于一个局部变量)
//        InnerClass01 innerClass = new InnerClass01();

    }
}
