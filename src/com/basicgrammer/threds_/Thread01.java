package com.basicgrammer.threds_;

/**
 * @author Pi
 * @date 2021-04-23 23:22
 */
public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
    }
}

class Cat extends Thread {
    int count = 0;

    //重写run方法，将需要实现的业务逻辑放置到其中
    @Override
    public void run() {

        while (true) {
            System.out.println("小猫喵喵叫......" + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 8) {
                break;
            }
        }
    }
}
