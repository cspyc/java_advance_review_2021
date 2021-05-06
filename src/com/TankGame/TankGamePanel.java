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
public class TankGamePanel extends JPanel implements KeyListener, Runnable {

    private TigerHeroTank myTank;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
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
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 10, DOWN, 1);
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
        drawTank(g, myTank.getX(), myTank.getY(), myTank.getDirect(), 0);

        //画出子弹
        if (myTank.getShot() != null && myTank.getShot().isLive()) {
            g.draw3DRect(myTank.getShot().getX(), myTank.getShot().getY(), 2, 2, false);
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
        for (EnemyTank enemyTank : enemyTanks) {
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
    public void hitTank(Shot shot, EnemyTank enemyTank) {
        //判断子弹是否击中坦克
        switch (enemyTank.getDirect()) {
            case UP:
            case DOWN:
                if (shot.getX() > enemyTank.getX() && shot.getX() < enemyTank.getX() + 40
                        && shot.getY() > enemyTank.getY() && shot.getY() < enemyTank.getY() + 60) {
                    shot.dispel();
                    enemyTank.dispel();
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                    //移除被击中的坦克
                    enemyTanks.remove(enemyTank);
                }
                break;
            case LEFT:
            case RIGHT:
                if (shot.getX() > enemyTank.getX() && shot.getX() < enemyTank.getX() + 60
                        && shot.getY() > enemyTank.getY() && shot.getY() < enemyTank.getY() + 40) {
                    shot.dispel();
                    enemyTank.dispel();
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                    //移除被击中的坦克
                    enemyTanks.remove(enemyTank);
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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断是否击中了敌人的坦克
            if (myTank.getShot() != null && myTank.getShot().isLive()) {//当我方坦克子弹还存活
                //遍历敌人所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(myTank.getShot(), enemyTank);
                }

            }
            this.repaint();
        }
    }
}
