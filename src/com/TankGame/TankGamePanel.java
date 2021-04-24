package com.TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Pi
 * @date 2021-04-23 10:34
 */
public class TankGamePanel extends JPanel implements KeyListener {

    private TigerHeroTank myTank = new TigerHeroTank(300, 200, 0, 3);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //游戏区域背景
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        Vector<Tank> enemyTanks = new Vector<>();
        int enemyTankNum = 3;
        for (int i = 0; i < enemyTankNum; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 10, 2, 1);
            enemyTanks.add(enemyTank);
        }

        for (Tank enemyTank : enemyTanks) {
            drawTank(g, enemyTank.getX(), enemyTank.getY(), enemyTank.getDirect(), 1);
        }
        drawTank(g, myTank.getX(), myTank.getY(), myTank.getDirect(), 0);
    }

    /**
     * 画坦克
     *
     * @param g                画笔
     * @param tankOriginPointX 坦克左侧原点X坐标
     * @param tankOriginPointY 坦克左侧原点Y坐标
     * @param moveDirect       坦克前进方向
     * @param tankType         坦克类型(用于区别敌我)
     */
    private void drawTank(Graphics g, int tankOriginPointX, int tankOriginPointY, int moveDirect, int tankType) {
        Color tankColor = null;

        switch (tankType) {
            case 0://己方坦克
                tankColor = Color.cyan;
                break;
            case 1://敌方坦克
                tankColor = Color.yellow;
                break;
            default:
                break;
        }
        switch (moveDirect) {
            case 0://向上
                drawUpDirectTank(g, tankOriginPointX, tankOriginPointY, tankColor);
                break;
            case 1://向右
                drawRightDirectTank(g, tankOriginPointX, tankOriginPointY, tankColor);
                break;
            case 2://向下
                drawDownDirectTank(g, tankOriginPointX, tankOriginPointY, tankColor);
                break;
            case 3://向左
                drawLeftDirectTank(g, tankOriginPointX, tankOriginPointY, tankColor);
                break;
        }

    }

    /**
     * 画出朝上前进的坦克
     *
     * @param g                画笔
     * @param tankOriginPointX 坦克左侧原点X坐标
     * @param tankOriginPointY 坦克左侧原点Y坐标
     * @param tankColor        坦克颜色
     */
    public void drawUpDirectTank(Graphics g, int tankOriginPointX, int tankOriginPointY, Color tankColor) {
        //两条履带
        paintRect(g, tankColor, tankOriginPointX, tankOriginPointY, 10, 60);
        paintRect(g, tankColor, tankOriginPointX + 30, tankOriginPointY, 10, 60);
        //主体
        paintRect(g, tankColor, tankOriginPointX + 10, tankOriginPointY + 10, 20, 40);
        //炮台
        paintCircle(g, tankColor, tankOriginPointX + 10, tankOriginPointY + 20, 20, 20);
        //炮管
        paintLine(g, tankColor, tankOriginPointX + 20, tankOriginPointY, tankOriginPointX + 20, tankOriginPointY + 30);
    }

    /**
     * 画出朝右前进的坦克
     *
     * @param g                画笔
     * @param tankOriginPointX 坦克左侧原点X坐标
     * @param tankOriginPointY 坦克左侧原点Y坐标
     * @param tankColor        坦克颜色
     */
    public void drawRightDirectTank(Graphics g, int tankOriginPointX, int tankOriginPointY, Color tankColor) {
        //两条履带
        paintRect(g, tankColor, tankOriginPointX, tankOriginPointY, 60, 10);
        paintRect(g, tankColor, tankOriginPointX, tankOriginPointY + 30, 60, 10);
        //主体
        paintRect(g, tankColor, tankOriginPointX + 10, tankOriginPointY + 10, 40, 20);
        //炮台
        paintCircle(g, tankColor, tankOriginPointX + 20, tankOriginPointY + 10, 20, 20);
        //炮管
        paintLine(g, tankColor, tankOriginPointX + 30, tankOriginPointY + 20, tankOriginPointX + 60, tankOriginPointY + 20);
    }

    /**
     * 画出朝下前进的坦克
     *
     * @param g                画笔
     * @param tankOriginPointX 坦克左侧原点X坐标
     * @param tankOriginPointY 坦克左侧原点Y坐标
     * @param tankColor        坦克颜色
     */
    public void drawDownDirectTank(Graphics g, int tankOriginPointX, int tankOriginPointY, Color tankColor) {
        //两条履带
        paintRect(g, tankColor, tankOriginPointX, tankOriginPointY, 10, 60);
        paintRect(g, tankColor, tankOriginPointX + 30, tankOriginPointY, 10, 60);
        //主体
        paintRect(g, tankColor, tankOriginPointX + 10, tankOriginPointY + 10, 20, 40);
        //炮台
        paintCircle(g, tankColor, tankOriginPointX + 10, tankOriginPointY + 20, 20, 20);
        //炮管
        paintLine(g, tankColor, tankOriginPointX + 20, tankOriginPointY + 60, tankOriginPointX + 20, tankOriginPointY + 30);
    }

    /**
     * 画出朝左前进的坦克
     *
     * @param g                画笔
     * @param tankOriginPointX 坦克左侧原点X坐标
     * @param tankOriginPointY 坦克左侧原点Y坐标
     * @param tankColor        坦克颜色
     */
    public void drawLeftDirectTank(Graphics g, int tankOriginPointX, int tankOriginPointY, Color tankColor) {
        //两条履带
        paintRect(g, tankColor, tankOriginPointX, tankOriginPointY, 60, 10);
        paintRect(g, tankColor, tankOriginPointX, tankOriginPointY + 30, 60, 10);
        //主体
        paintRect(g, tankColor, tankOriginPointX + 10, tankOriginPointY + 10, 40, 20);
        //炮台
        paintCircle(g, tankColor, tankOriginPointX + 20, tankOriginPointY + 10, 20, 20);
        //炮管
        paintLine(g, tankColor, tankOriginPointX + 30, tankOriginPointY + 20, tankOriginPointX, tankOriginPointY + 20);
    }

    private void paintRect(Graphics g, Color color,
                           int originPointX, int originPointY, int width, int height) {
        g.setColor(color);
        g.fill3DRect(originPointX, originPointY, width, height, false);

    }

    private void paintCircle(Graphics g, Color color,
                             int originPointX, int originPointY, int width, int height) {
        g.setColor(color);
        g.fillOval(originPointX, originPointY, width, height);
    }

    private void paintLine(Graphics g, Color color,
                           int originPointX, int originPointY, int destPointX, int destPointY) {
        g.setColor(color);
        g.drawLine(originPointX, originPointY, destPointX, destPointY);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            //左转向移动
            myTank.turnLeftAndMove();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            //向上转向移动
            myTank.turnToUpwardAndMove();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //右转向移动
            myTank.turnRightAndMove();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            //下转向移动
            myTank.turnToDownwardAndMove();
        }
        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
