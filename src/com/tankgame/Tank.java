package com.tankgame;


import static com.tankgame.TankGameConstants.TANK_HEIGHT;
import static com.tankgame.TankGameConstants.TANK_WIDTH;
import static com.tankgame.TankMoveDirectCode.*;

/**
 * @author Pi
 * @date 2021-04-23 10:33
 */
@SuppressWarnings({"all"})
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

    //编写方法，判断坦克是否相撞  <=> 两个坦克是否重叠
    public boolean isCollisionTank(Tank otherTank) {
        TankMoveDirectCode otherTankDirect = otherTank.getDirect();
        //判断坦克是否重叠
        switch (this.getDirect()) {
            case UP:
                //另一只坦克，分为朝上下，x的范围[otherTank.getX(), otherTank.getX() + TANK_WIDTH]
//                                      y的范围[otherTank.getY(), otherTank.getY() + TANK_HEIGHT]
                // 及朝左右两种情况   x的范围[otherTank.getX(),otherTank.getX()+TANK_HEIGHT]
//                                   y的范围[otherTank.getY(), otherTank.getY() + TANK_WIDTH]
                if (otherTankDirect == UP || otherTankDirect == DOWN) {
                    //当前坦克左上角坐标(this.getX(),this.getY())
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_WIDTH
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                    //当前坦克右上角坐标(this.getX() + TANK_WIDTH,this.getY())
                    if (this.getX() + TANK_WIDTH >= otherTank.getX() && this.getX() + TANK_WIDTH <= otherTank.getX() + TANK_WIDTH
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                }

                if (otherTankDirect == LEFT || otherTankDirect == RIGHT) {
                    //当前坦克左上角坐标(this.getX(),this.getY())
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                    //当前坦克右上角坐标(this.getX() + TANK_WIDTH,this.getY())
                    if (this.getX() + TANK_WIDTH >= otherTank.getX() && this.getX() + TANK_WIDTH <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                }
                break;
            case DOWN:
                //另一只坦克，分为朝上下，x的范围[otherTank.getX(), otherTank.getX() + TANK_WIDTH]
//                                      y的范围[otherTank.getY(), otherTank.getY() + TANK_HEIGHT]
                // 及朝左右两种情况   x的范围[otherTank.getX(),otherTank.getX()+TANK_HEIGHT]
//                                   y的范围[otherTank.getY(), otherTank.getY() + TANK_WIDTH]
                if (otherTankDirect == UP || otherTankDirect == DOWN) {
                    //当前坦克左下角坐标(this.getX(),this.getY() + TANK_HEIGHT)
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_WIDTH
                            && this.getY() + TANK_HEIGHT >= otherTank.getY() && this.getY() + TANK_HEIGHT <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                    //当前坦克右下角坐标(this.getX() + TANK_WIDTH,this.getY() + TANK_HEIGHT)
                    if (this.getX() + TANK_WIDTH >= otherTank.getX() && this.getX() + TANK_WIDTH <= otherTank.getX() + TANK_WIDTH
                            && this.getY() + TANK_HEIGHT >= otherTank.getY() && this.getY() + TANK_HEIGHT <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                }

                if (otherTankDirect == LEFT || otherTankDirect == RIGHT) {
                    //当前坦克左下角坐标(this.getX(),this.getY() + TANK_HEIGHT)
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() + TANK_HEIGHT >= otherTank.getY() && this.getY() + TANK_HEIGHT <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                    //当前坦克右下角坐标(this.getX() + TANK_WIDTH,this.getY() + TANK_HEIGHT)
                    if (this.getX() + TANK_WIDTH >= otherTank.getX() && this.getX() + TANK_WIDTH <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() + TANK_HEIGHT >= otherTank.getY() && this.getY() + TANK_HEIGHT <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                }
                break;
            case LEFT:
                //另一只坦克，分为朝上下，x的范围[otherTank.getX(), otherTank.getX() + TANK_WIDTH]
//                                      y的范围[otherTank.getY(), otherTank.getY() + TANK_HEIGHT]
                // 及朝左右两种情况   x的范围[otherTank.getX(),otherTank.getX()+TANK_HEIGHT]
//                                   y的范围[otherTank.getY(), otherTank.getY() + TANK_WIDTH]
                if (otherTankDirect == UP || otherTankDirect == DOWN) {
                    //当前坦克左上角坐标(this.getX(),this.getY())
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_WIDTH
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                    //当前坦克左下角坐标(this.getX(),this.getY() + TANK_WIDTH)
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_WIDTH
                            && this.getY() + TANK_WIDTH >= otherTank.getY() && this.getY() + TANK_WIDTH <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                }

                if (otherTankDirect == LEFT || otherTankDirect == RIGHT) {
                    //当前坦克左上角坐标(this.getX(),this.getY())
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                    //当前坦克左下角坐标(this.getX(),this.getY() + TANK_WIDTH)
                    if (this.getX() >= otherTank.getX() && this.getX() <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() + TANK_WIDTH >= otherTank.getY() && this.getY() + TANK_WIDTH <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                }
                break;
            case RIGHT:
                //另一只坦克，分为朝上下，x的范围[otherTank.getX(), otherTank.getX() + TANK_WIDTH]
//                                      y的范围[otherTank.getY(), otherTank.getY() + TANK_HEIGHT]
                // 及朝左右两种情况   x的范围[otherTank.getX(),otherTank.getX()+TANK_HEIGHT]
//                                   y的范围[otherTank.getY(), otherTank.getY() + TANK_WIDTH]
                if (otherTankDirect == UP || otherTankDirect == DOWN) {
                    //当前坦克右上角坐标(this.getX()+TANK_HEIGHT,this.getY())
                    if (this.getX() + TANK_HEIGHT >= otherTank.getX() && this.getX() + TANK_HEIGHT <= otherTank.getX() + TANK_WIDTH
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                    //当前坦克右下角坐标(this.getX()+TANK_HEIGHT,this.getY() + TANK_WIDTH)
                    if (this.getX() + TANK_HEIGHT >= otherTank.getX() && this.getX() + TANK_HEIGHT <= otherTank.getX() + TANK_WIDTH
                            && this.getY() + TANK_WIDTH >= otherTank.getY() && this.getY() + TANK_WIDTH <= otherTank.getY() + TANK_HEIGHT) {
                        return true;
                    }
                }

                if (otherTankDirect == LEFT || otherTankDirect == RIGHT) {
                    //当前坦克右上角坐标(this.getX()+TANK_HEIGHT,this.getY())
                    if (this.getX() + TANK_HEIGHT >= otherTank.getX() && this.getX() + TANK_HEIGHT <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() >= otherTank.getY() && this.getY() <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                    //当前坦克右下角坐标(this.getX()+TANK_HEIGHT,this.getY() + TANK_WIDTH)
                    if (this.getX() + TANK_HEIGHT >= otherTank.getX() && this.getX() + TANK_HEIGHT <= otherTank.getX() + TANK_HEIGHT
                            && this.getY() + TANK_WIDTH >= otherTank.getY() && this.getY() + TANK_WIDTH <= otherTank.getY() + TANK_WIDTH) {
                        return true;
                    }
                }
                break;
            default:
                break;
        }
        return false;
    }
}
