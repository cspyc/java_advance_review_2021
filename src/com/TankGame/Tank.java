package com.TankGame;

/**
 * @author Pi
 * @date 2021-04-23 10:33
 */
public class Tank {
    //坦克的坐标
    private int x;
    private int y;
    private int direct;
    private int speed = 1;


    public Tank(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public Tank(int x, int y, int direct, int speed) {
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

    public int getDirect() {
        return direct;
    }

    public void turnLeftAndMove() {
        this.direct = TankMoveDirectCode.LEFT.getCode();
        this.x -= speed;
    }

    public void turnRightAndMove() {
        this.direct = TankMoveDirectCode.RIGHT.getCode();
        this.x += speed;
    }

    public void turnToUpwardAndMove() {
        this.direct = TankMoveDirectCode.UP.getCode();
        this.y -= speed;
    }

    public void turnToDownwardAndMove() {
        this.direct = TankMoveDirectCode.DOWN.getCode();
        this.y += speed;
    }

}
