package com.basicgrammer.threds_;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Pi
 * @date 2021-04-24 21:41
 */
public class Homework01 {
    public static void main(String[] args) {
        Thread_01 t1 = new Thread_01();
        t1.start();

        Thread_02 task = new Thread_02(t1);
        task.start();

    }
}

class Thread_02 extends Thread {

    private final Thread_01 target;
    private final Scanner input = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入你的指令(Q)表示退出：");

            char inputStr = input.next().toUpperCase().charAt(0);
            if (inputStr == 'Q') {
                target.setPrintLoop(false);
                System.out.println("线程2运行结束");
                break;
            }
        }
    }

    public Thread_02(Thread_01 target) {
        this.target = target;
    }
}

class Thread_01 extends Thread {
    private boolean printLoop = true;

    @Override
    public void run() {
        while (printLoop) {
            System.out.println(randomIntNumber());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPrintLoop(boolean printLoop) {
        this.printLoop = printLoop;
    }

    private int randomIntNumber() {
        return (int) (Math.random() * 100 + 1);
    }
}