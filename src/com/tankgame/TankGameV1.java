package com.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author Pi
 * @date 2021-04-23 10:59
 */
@SuppressWarnings({"all"})
public class TankGameV1 extends JFrame {

    public static void main(String[] args) {
        TankGameV1 tankGameV1 = new TankGameV1();
    }

    //定义游戏区域画板
    TankGamePanel tp = null;
    static Scanner scanner = new Scanner(System.in);

    public TankGameV1() {
        System.out.println("请输入选择1: 新游戏  2:继续上局");
        String key = scanner.next();

        tp = new TankGamePanel(key);
        Thread thread = new Thread(tp);//把绘图板放到一个线程内，并启动,不停地重绘
        thread.start();

        //画框添加画板
        this.add(tp);
        this.setVisible(true);
        this.setSize(1300, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置键盘事件监听
        this.addKeyListener(tp);

        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.setEnemyTanks(tp.getEnemyTanks());
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
