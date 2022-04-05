package com.basicgrammer.threds_;

/**
 * @author Pi
 * @date 2021-04-24 15:34
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();

        int count = 0;
        while (true) {
            System.out.println("hi " + (++count));
            if (count == 5) {
                Thread thread = new Thread(t1);
                thread.start();
                thread.join();
            }
            if (count == 10) {
                break;
            }
        }

    }
}

class T1 implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
