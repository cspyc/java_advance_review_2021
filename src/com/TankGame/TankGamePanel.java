package com.TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import static com.TankGame.TankMoveDirectCode.DOWN;
import static com.TankGame.TankMoveDirectCode.UP;

/**
 * @author Pi
 * @date 2021-04-23 10:34
 */
@SuppressWarnings({"all"})
public class TankGamePanel extends JPanel implements KeyListener, Runnable {

    private TigerHeroTank myTank;
    private Vector<Tank> enemyTanks = new Vector<>();
    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，加入一个Bomb对象对panel
    private Vector<Bomb> bombs = new Vector<>();

    //定义三张炸弹图片，用于显示爆炸效果
    Image bomb1 = null;
    Image bomb2 = null;
    Image bomb3 = null;


    public TankGamePanel() {
        //初始化我方坦克
        myTank = new TigerHeroTank(300, 200, UP, 3);

        //初始化敌方坦克
        int enemyTankNum = 3;
        for (int i = 0; i < enemyTankNum; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 10, DOWN, 2);
            //启动敌人坦克线程
            new Thread(enemyTank).start();
            //给坦克装弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect(), 2);
            enemyTank.shots.add(shot);
            //启动shot对象
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }

        //初始化炸弹图片对象
        bomb1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        bomb2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        bomb3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //游戏区域背景
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        //画出我方坦克
        if (myTank != null && myTank.isLive()) {
            drawTank(g, myTank.getX(), myTank.getY(), myTank.getDirect(), 0);
        }

        //画出我方发射子弹集合
        if (myTank.getShots() != null && !myTank.getShots().isEmpty()) {
            Vector<Shot> shots = myTank.getShots();
            for (int i = 0; i < shots.size(); i++) {
                Shot shot = shots.get(i);
                if (shot != null && shot.isLive()) {
                    g.draw3DRect(shot.getX(), shot.getY(), 2, 2, false);
                } else {//如果shot已经消亡则移除子弹对象
                    shots.remove(shot);
                }
            }
        }

        //如果bombs集合中有对象，就画出炸弹
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.getLife() > 6) {
                g.drawImage(bomb1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 3) {
                g.drawImage(bomb2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(bomb3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            //减少炸弹生命值
            bomb.lifeDown();
            //如果bomb life 为0，就从bombs的集合中删除
            if (bomb.getLife() == 0) {
                bombs.remove(bomb);
            }
        }

        //画敌方坦克
        for (Tank tank : enemyTanks) {
            EnemyTank enemyTank = (EnemyTank) tank;
            //判断敌人坦克是否存活，如果不存活，不用画出
            if (enemyTank.isLive()) {
                drawTank(g, enemyTank.getX(), enemyTank.getY(), enemyTank.getDirect(), 1);

                //画出所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    //绘制子弹
                    if (shot.isLive()) {
                        g.draw3DRect(shot.getX(), shot.getY(), 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
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
    private void drawTank(Graphics g, int tankOriginPointX, int tankOriginPointY, TankMoveDirectCode moveDirect, int tankType) {
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
            case UP://向上
                drawUpDirectTank(g, tankOriginPointX, tankOriginPointY, tankColor);
                break;
            case RIGHT://向右
                drawRightDirectTank(g, tankOriginPointX, tankOriginPointY, tankColor);
                break;
            case DOWN://下
                drawDownDirectTank(g, tankOriginPointX, tankOriginPointY, tankColor);
                break;
            case LEFT://向左
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

    //编写方法，判断子弹是否击中坦克  <=> 子弹坐标是否在坦克区域内
    public void hitTank(Shot shot, Tank tank, Vector<Tank> enemyTanks) {
        //判断子弹是否击中坦克
        switch (tank.getDirect()) {
            case UP:
            case DOWN:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 40
                        && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 60) {
                    shot.dispel();
                    tank.dispel();
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    //移除被击中的坦克
                    if (enemyTanks != null && enemyTanks.size() > 0) {
                        enemyTanks.remove(tank);
                    } else {
                        tank = null;
                    }
                }
                break;
            case LEFT:
            case RIGHT:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 60
                        && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 40) {
                    shot.dispel();
                    tank.dispel();
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    //移除被击中的坦克
                    if (enemyTanks != null && enemyTanks.size() > 0) {
                        enemyTanks.remove(tank);
                    } else {
                        tank = null;
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            //左转向移动
            if (myTank.getX() > 0) {
                myTank.turnLeftAndMove();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            //向上转向移动
            if (myTank.getY() > 0) {
                myTank.turnToUpwardAndMove();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //右转向移动
            if (myTank.getX() + 60 < 1000) {
                myTank.turnRightAndMove();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            //下转向移动
            if (myTank.getY() + 60 < 750) {
                myTank.turnToDownwardAndMove();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("按下J键，开始射击。");
            myTank.shotEnemyTank();
        }

        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断我方坦克发射子弹否击中了敌人的坦克
            hitEnemyTank();
            //判断敌方坦克的子弹是否我方坦克
            hitMyTigerTank();
            this.repaint();
        }
    }

    private void hitEnemyTank() {
        if (myTank.getShots() != null && !myTank.getShots().isEmpty()) {

            for (Shot shot : myTank.getShots()) {
                if (shot != null && shot.isLive()) {//当我方坦克子弹还存活
                    //遍历敌人所有的坦克
                    for (int i = 0; i < enemyTanks.size(); i++) {
                        Tank enemyTank = enemyTanks.get(i);
                        hitTank(shot, enemyTank, enemyTanks);
                    }
                }
            }
        }
    }

    private void hitMyTigerTank() {
        if (enemyTanks != null && enemyTanks.size() != 0) {
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = (EnemyTank) enemyTanks.get(i);
                Vector<Shot> enemyTankShots = enemyTank.shots;
                if (enemyTankShots != null && !enemyTankShots.isEmpty()) {

                    for (Shot shot : enemyTankShots) {
                        if (shot != null && shot.isLive()) {//当坦克子弹还存活
                            //判断我方坦克是否被击中
                            hitTank(shot, myTank, null);
                        }
                    }
                }
            }
        }

    }
}
