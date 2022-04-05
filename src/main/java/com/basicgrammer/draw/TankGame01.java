package com.basicgrammer.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Pi
 * @date 2021-04-23 00:21
 */
public class TankGame01 extends JFrame {
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
        tankGame01.paintTank();
    }

    TankPanel tp = new TankPanel();

    public void paintTank() {
        //画框添加画板
        this.add(tp);
        this.setVisible(true);
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class TankPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintTank(g);
    }

    private void paintTank(Graphics g) {
        Color trackColor = Color.black;
        Color mainColor = Color.cyan;
        Color weaponColor = Color.red;
        //两条履带
        paintRect(g, trackColor, 20, 20, 20, 100);
        paintRect(g, trackColor, 80, 20, 20, 100);
        //主体
        paintRect(g, mainColor, 40, 40, 40, 60);
        //炮台
        paintCircle(g, weaponColor, 40, 50, 40, 40);
        //炮管
        paintLine(g, weaponColor, 60, 60, 60, 10);
    }

    private void paintRect(Graphics g, Color color,
                           int originPointX, int originPointY, int width, int height) {
        g.setColor(color);
        g.fillRect(originPointX, originPointY, 20, 100);

    }

    private void paintCircle(Graphics g, Color color,
                             int originPointX, int originPointY, int width, int height) {
        g.setColor(color);
        g.fillOval(originPointX, originPointY, width, height);
    }

    private void paintLine(Graphics g, Color color,
                           int originPointX, int originPointY, int destPointX, int destPointY) {
        g.setColor(color);
        g.drawLine(originPointX, originPointY, destPointX, destPointY);
    }

}
