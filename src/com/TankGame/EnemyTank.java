package com.TankGame;

/**
 * @author Pi
 * @date 2021-04-23 21:08
 */
public class EnemyTank extends Tank{
    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
}
