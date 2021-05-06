package com.basicgrammer.threds_;

/**
 * @author Pi
 * @date 2021-04-24 22:03
 */
public class Homework02 {
    public static void main(String[] args) {
        //需求：有2个用户分别从同一个卡上取钱(总额：10000)
        //每次都取1000，当余额不足时，就不能取款了
        //不能出现超取现象->线程同步问题

        User userA = new User();
        userA.setName("A用户");

        User userB = new User();
        userB.setName("B用户");

        userA.start();
        userB.start();
    }
}

class User extends Thread {
    private static double accountBalance = 10000;
    private boolean loopFlag = true;

    @Override
    public void run() {
        while (loopFlag) {
            getMoney();
        }
    }

    private synchronized void getMoney() {
        if (accountBalance < 1000) {
            System.out.println("余额不足，无法完成取钱");
            loopFlag = false;
            return;
        }
        System.out.println("用户：" + Thread.currentThread().getName() + ",正在取1000元，账户余额：" + (accountBalance -= 1000));
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


