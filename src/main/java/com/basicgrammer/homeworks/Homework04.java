package com.basicgrammer.homeworks;

/**
 * @author Pi
 * @date 2021-04-13 14:31
 */
public class Homework04 {
    public static void main(String[] args) {
        Aclass aclass = new Aclass();
        aclass.m1();
    }
}

class Aclass {
    private static final String NAME = "小王";
    private final String SEASONE = "现在是春天呢，春雨连绵......";

    public void m1() {
        //局部内部类
        final class Bclass {
            private final String NAME = "小李";

            public void show() {
                System.out.println("B中Name:" + NAME);
                System.out.println("A中的Name:" + Aclass.NAME);
                System.out.println("A中的季节：" + Aclass.this.SEASONE);
            }
        }

        Bclass bclass = new Bclass();
        bclass.show();
    }
}
