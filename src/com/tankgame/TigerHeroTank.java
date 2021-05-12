package com.tankgame;

import java.util.Vector;

import static com.tankgame.TankMoveDirectCode.*;

/**
 * @author Pi
 * @date 2021-04-23 10:33
 */
public class TigerHeroTank extends Tank {
    //射击
    private Vector<Shot> shots = new Vector<>();

    public TigerHeroTank(int x, int y, TankMoveDirectCode direct, int speed) {
        super(x, y, direct, speed);
    }

    public void shotEnemyTank() {
        if (shots.size() == 5) {//一次最多只能发射5颗子弹
            return;
        }
        switch (getDirect()) {
            case UP:
                Shot shotUp = new Shot(getX() + 20, getY(), UP, 2);
                new Thread(shotUp).start();
                shots.add(shotUp);
                break;
            case RIGHT:
                Shot shotRight = new Shot(getX() + 60, getY() + 20, RIGHT, 2);
                new Thread(shotRight).start();
                shots.add(shotRight);
                break;
            case DOWN:
                Shot shotDown = new Shot(getX() + 20, getY() + 60, DOWN, 2);
                new Thread(shotDown).start();
                shots.add(shotDown);
                break;
            case LEFT:
                Shot shotLeft = new Shot(getX(), getY() + 20, LEFT, 2);
                new Thread(shotLeft).start();
                shots.add(shotLeft);
                break;
            default:
                break;
        }
    }

    public Vector<Shot> getShots() {
        return shots;
    }
}
