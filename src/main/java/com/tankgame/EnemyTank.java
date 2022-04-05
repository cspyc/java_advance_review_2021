package com.tankgame;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import static com.tankgame.TankMoveDirectCode.*;

/**
 * @author Pi
 * @date 2021-04-23 21:08
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector，保存多个shot
    Vector<Shot> shots = new Vector<>();

    //当前游戏界面中的敌军坦克集合
    Vector<Tank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y, TankMoveDirectCode direct, int speed) {
        super(x, y, direct, speed);
    }

    public void setEnemyTanks(Vector<Tank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //敌人坦克设置成方向随机、移动；每隔一段时间自动换方向(遇到障碍物也需要自动换方向)
    public void autoRandomMove() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int moveDirection = random.nextInt(4);

        if (moveDirection == UP.getCode()) {
            turnToUpwardAndMove();
        } else if (moveDirection == TankMoveDirectCode.RIGHT.getCode()) {
            turnRightAndMove();
        } else if (moveDirection == TankMoveDirectCode.DOWN.getCode()) {
            turnToDownwardAndMove();
        } else if (moveDirection == TankMoveDirectCode.LEFT.getCode()) {
            turnLeftAndMove();
        }

    }

    @Override
    public void run() {
        while (true) {
            //如果shots集合元素数量为0，创建一颗子弹，放入到集合，并启动
            if (isLive() && shots.size() == 0) {
                //判断坦克方向，创建对应的子弹
                Shot s = null;
                TankMoveDirectCode directCode = getDirect();
                switch (directCode) {
                    case UP:
                        s = new Shot(getX() + 20, getY(), UP, 4);
                        break;
                    case RIGHT:
                        s = new Shot(getX() + 60, getY() + 20, RIGHT, 4);
                        break;
                    case DOWN:
                        s = new Shot(getX() + 20, getY() + 60, DOWN, 4);
                        break;
                    case LEFT:
                        s = new Shot(getX(), getY() + 20, LEFT, 4);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            move();
            try {
                Thread.sleep(50);//每隔5秒换次方向
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            //敌方坦克自动移动
            autoRandomMove();
            //坦克被击中后，退出线程
            if (!isLive()) {
                break;
            }
        }
    }

    private void move() {
        TankMoveDirectCode directCode = getDirect();
        switch (directCode) {
            case UP:
                //让坦克保持一个方向，走30步
                for (int i = 0; i < 30; i++) {
                    //Y坐标大于等于0时，可以继续往上走
                    if (getY() > 0 && !isEnenmyTanksCollisioned()) {
                        moveUp();
                    }
                    //休眠50ms
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case RIGHT:
                for (int i = 0; i < 30; i++) {
                    if (getY() + 60 < 1000 && !isEnenmyTanksCollisioned()) {
                        moveRight();
                    }
                    //休眠50ms
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case DOWN:
                for (int i = 0; i < 30; i++) {
                    if (getY() + 60 < 750 && !isEnenmyTanksCollisioned()) {
                        moveDown();
                    }
                    //休眠50ms
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case LEFT:
                for (int i = 0; i < 30; i++) {
                    if (getX() > 0 && !isEnenmyTanksCollisioned()) {
                        moveLeft();
                    }
                    //休眠50ms
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public boolean isEnenmyTanksCollisioned() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            if (this != enemyTanks.get(i)) {
                return this.isCollisionTank(enemyTanks.get(i));
            }
        }
        return false;
    }
}
