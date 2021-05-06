package com.TankGame;

import static com.TankGame.TankMoveDirectCode.*;

/**
 * @author Pi
 * @date 2021-04-23 10:33
 */
public class TigerHeroTank extends Tank {
    //射击
    private Shot shot = null;

    public TigerHeroTank(int x, int y, TankMoveDirectCode direct) {
        super(x, y, direct);
    }

    public TigerHeroTank(int x, int y, TankMoveDirectCode direct, int speed) {
        super(x, y, direct, speed);
    }

    public void shotEnemyTank() {
        switch (getDirect()) {
            case UP:
                shot = new Shot(getX() + 20, getY(), UP, 2);
                break;
            case RIGHT:
                shot = new Shot(getX() + 60, getY() + 20, RIGHT, 2);
                break;
            case DOWN:
                shot = new Shot(getX() + 20, getY() + 60, DOWN, 2);
                break;
            case LEFT:
                shot = new Shot(getX(), getY() + 20, LEFT, 2);
                break;
            default:
                break;
        }
        new Thread(shot).start();
    }

    public Shot getShot() {
        return shot;
    }
}
