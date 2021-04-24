package com.basicgrammer.homeworks.homework01;

/**
 * @author Pi
 * @date 2021-04-13 14:03
 */
public class TestFrock {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println("第一个：" + frock1.getSerialNumber());
        System.out.println("第二个：" + frock2.getSerialNumber());
        System.out.println("第三个：" + frock3.getSerialNumber());
    }
}
