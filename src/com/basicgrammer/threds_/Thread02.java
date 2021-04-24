package com.basicgrammer.threds_;

/**
 * @author Pi
 * @date 2021-04-24 14:14
 */
public class Thread02 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        System.out.println("主线程退出");
    }
}

class Task1 implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("我是任务1,执行第 " + (++count) + " 次，线程名：" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 60) {
                break;
            }
        }
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("我是任务2,执行第 " + (++count) + " 次，线程名：" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 50) {
                break;
            }
        }
    }
}
