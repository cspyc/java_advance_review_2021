package com.TankGame;

import java.util.Vector;

/**
 * @author Pi
 * @date 2021-04-23 21:08
 */
public class EnemyTank extends Tank{
    //在敌人坦克类，使用Vector，保存多个shot
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y, TankMoveDirectCode direct) {
        super(x, y, direct);
    }

    public EnemyTank(int x, int y, TankMoveDirectCode direct, int speed) {
        super(x, y, direct, speed);
    }

    //敌人坦克设置成方向随机、移动；每隔一段时间自动换方向(遇到障碍物也需要自动换方向)
    public void autoRandomMove(){

    }

}
