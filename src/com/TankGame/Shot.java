package com.TankGame;

/**
 * @author Pi
 * @date 2021-04-25 15:21
 */
public class Shot implements Runnable {
    private int x;
    private int y;
    private TankMoveDirectCode direct;
    private int speed;
    private boolean isLive = true;//子弹是否还存活

    public Shot(int x, int y, TankMoveDirectCode direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {
            //休眠50ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case UP:
                    y -= speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                default:
                    break;
            }
//            System.out.println("子弹坐标：" + x + "," + y);
            //子弹超出游戏面板边界
            //当子弹碰到敌人坦克时，也需要销毁
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                isLive = false;
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLive() {
        return isLive;
    }

    public void dispel() {
        this.isLive = false;
    }
}
