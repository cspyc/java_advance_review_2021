package com.basicgrammer.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Pi
 * @date 2021-04-22 23:43
 * 画一个圆
 */
public class DrawCircle extends JFrame {//定义一个画框

    public static void main(String[] args) {
        DrawCircle drawCircle = new DrawCircle();
        drawCircle.paintCircle();
    }

    MyPanel panel = new MyPanel();
    private void paintCircle() {
        //把面板放入到画框
        this.add(panel);
        //设置窗口大小
        this.setSize(500, 300);
        //设置可见
        this.setVisible(true);
        //当点击窗口的关闭按钮，完全退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


//定义一个画板
class MyPanel extends JPanel {

    //用画笔画图
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawOval(50,50,100,100);
    }
}
