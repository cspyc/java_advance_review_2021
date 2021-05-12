package com.basicgrammer.threds_;

/**
 * @author Pi
 * @date 2021-04-24 14:35
 */
public class SellTicketsExercise {
    public static void main(String[] args) {
//        SellTicket sellTicket = new SellTicket();
//        SellTicket sellTicket1 = new SellTicket();
//        SellTicket sellTicket2 = new SellTicket();
//        sellTicket.start();
//        sellTicket1.start();
//        sellTicket2.start();

        SellTickets2 sellTickets2 = new SellTickets2();
        Thread t1 = new Thread(sellTickets2);
        Thread t2 = new Thread(sellTickets2);
        Thread t3 = new Thread(sellTickets2);
        t1.start();
        t2.start();
        t3.start();

    }
}

class SellTicket extends Thread {
    private static int allTicketsNum = 100;

    public SellTicket() {
    }


    @Override
    public void run() {
        int sellCount = 0;
        while (true) {
            System.out.println("窗口：" + Thread.currentThread().getName() + "卖出第 " + (++sellCount) + "张票！剩余票数：" + (--allTicketsNum));

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (allTicketsNum <= 0) {
                System.out.println("窗口：" + Thread.currentThread().getName() + "售票结束!");
                break;
            }
        }
    }
}

class SellTickets2 implements Runnable {
    private int allTicketsNum = 100; //让多个线程共享 allTicketsNum 票池
    private boolean loop = true;
    private int sellCount = 0;

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

    private synchronized void sell() {
        //卖票前先检查余票数量
        if (allTicketsNum <= 0) {
            System.out.println("窗口：" + Thread.currentThread().getName() + "售票结束!");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("窗口：" + Thread.currentThread().getName() + "卖出第 " + (++sellCount) + "张票！剩余票数：" + (--allTicketsNum));
    }
}
