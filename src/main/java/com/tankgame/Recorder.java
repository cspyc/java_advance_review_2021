package com.tankgame;

import java.io.*;
import java.util.Vector;

/**
 * @author pi
 * @date 2021/05/13 14:27:53
 * 用于记录相关信息
 **/
@SuppressWarnings({"all"})
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;

    private static Vector<Tank> enemyTanks = new Vector<>();

    //定义IO对象，准备写数据到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "src/myRecord.txt";

    public static void setEnemyTanks(Vector<Tank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static Vector<Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public static String getRecordFile() {
        return recordFile;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum++
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }

    //增加一个方法，当游戏退出时，将allEnemyTankNum保存到recordFile
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");

            //遍历敌人坦克Vector，然后根据情况保存
            for (int i = 0; i < enemyTanks.size(); i++) {
                Tank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive()) {
                    //保存坦克信息
                    String tankInfo = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect().getCode();
                    bw.write(tankInfo + "\r\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readRecord() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            String lineContent = " ";
            int readCount = 0;

            while ((lineContent = br.readLine()) != null) {
                if (readCount == 0) {
                    allEnemyTankNum = Integer.parseInt(lineContent);
                } else {
                    String[] tankInfo = lineContent.split(" ");
                    if (tankInfo.length > 0) {
                        int tankX = Integer.parseInt(tankInfo[0]);
                        int tankY = Integer.parseInt(tankInfo[1]);
                        int direct = Integer.parseInt(tankInfo[2]);

                        EnemyTank enemyTank = new EnemyTank(tankX, tankY, TankMoveDirectCode.getDirectCodeFromIntNum(direct), 2);
                        enemyTanks.add(enemyTank);

                    }
                }
                readCount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
