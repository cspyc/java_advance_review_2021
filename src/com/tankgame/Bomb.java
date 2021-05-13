package com.tankgame;

/**
 * @author Pi
 * @date 2021-05-05 22:26
 */
@SuppressWarnings({"all"})
public class Bomb {
    private int x, y;//炸弹的坐标
    private int life = 9;//炸弹的生命周期
    private boolean isLive = true;//是否还存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }

    public int getLife() {
        return life;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
