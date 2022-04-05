package com.advanceofmultithread.obviouslock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author pi
 * @date 2021/06/21 13:43:25
 **/
@SuppressWarnings({"all"})
public class LockSupportDemo {

    @Test
    public void should_testLockSupport() throws Exception {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + Thread.currentThread().getName() + "]" + "即将进行无限阻塞？");
            System.out.println("[" + Thread.currentThread().getName() + "]" + "当前线程状态为：" + Thread.currentThread().getState());

            LockSupport.park();

            System.out.println("[" + Thread.currentThread().getName() + "]" + "线程被重新唤醒！！！");
        }, "演示线程名");

        thread.start();
        System.out.println("[" + Thread.currentThread().getName() + "]" + "启动thread线程。。。。。。");
        //唤醒一次没有调用LockSupport.part()的线程
//        LockSupport.unpark(thread);
//        LockSupport.unpark(thread);

        Thread.sleep(2000);
        System.out.println("[" + thread.getName() + "]" + "LockSupport.Park()后，线程状态为：" + thread.getState());
        //唤醒调用了LockSupport.park()的线程
//        LockSupport.unpark(thread);
    }
}
