package com.basicgrammer.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Pi
 * @date 2021-04-23 16:24
 */
public class BallMove extends JFrame {
    MoveBallPanel panel = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        this.panel = new MoveBallPanel();
        //添加画板
        this.add(panel);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addKeyListener(panel);
    }
}

class MoveBallPanel extends JPanel implements KeyListener {
    private int ballX = 20;
    private int ballY = 20;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //画个小圆球
        g.fillOval(ballX, ballY, 30, 30);
    }

    //当输出字符时，触发方法
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当按下某个键时，触发方法
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ballY--;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ballY++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ballX--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ballX++;
        }

        //改变小球绘制参数，需要重绘，刷新
        this.repaint();
    }

    //当释放某个键时，触发方法
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

