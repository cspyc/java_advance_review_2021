package com.TankGame;

import javax.swing.*;
import java.awt.*;

/**
 * @author Pi
 * @date 2021-04-23 10:59
 */
public class TankGameV1 extends JFrame {

    public static void main(String[] args) {
        TankGameV1 tankGameV1 = new TankGameV1();

    }

    //定义游戏区域画板
    TankGamePanel tp = null;

    public TankGameV1() {
        tp = new TankGamePanel();

        //画框添加画板
        this.add(tp);
        this.setVisible(true);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置键盘事件监听
        this.addKeyListener(tp);
    }
}
