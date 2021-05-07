package com.TankGame;


import static com.TankGame.TankMoveDirectCode.*;

/**
 * @author Pi
 * @date 2021-04-23 10:33
 */
public class Tank {
    //坦克的坐标
    private int x;
    private int y;
    private TankMoveDirectCode direct;
    private int speed = 1;
    private boolean isLive = true;


    public Tank(int x, int y, TankMoveDirectCode direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public Tank(int x, int y, TankMoveDirectCode direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TankMoveDirectCode getDirect() {
        return direct;
    }

    public void moveLeft() {
        this.x -= speed;
    }

    public void turnLeftAndMove() {
        this.direct = LEFT;
        moveLeft();
    }

    public void moveRight() {
        this.x += speed;
    }

    public void turnRightAndMove() {
        this.direct = RIGHT;
        moveRight();
    }

    public void moveUp() {
        this.y -= speed;
    }

    public void turnToUpwardAndMove() {
        this.direct = UP;
        moveUp();
    }

    public void moveDown() {
        this.y += speed;
    }

    public void turnToDownwardAndMove() {
        this.direct = DOWN;
        moveDown();
    }

    public void dispel() {
        this.isLive = false;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void setDirect(TankMoveDirectCode direct) {
        this.direct = direct;
    }
}
