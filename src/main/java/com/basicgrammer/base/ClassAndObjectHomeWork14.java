package com.basicgrammer.base;

import java.util.Scanner;

public class ClassAndObjectHomeWork14 {
    public static void main(String[] args) {
        //需求：有个人 Tom设计他的成员变量，成员方法，可以电脑猜拳。电脑每次都会随机生成0,1,2，  0表示石头，1表示剪刀，2表示布
        //并要可以显示Tom的输赢次数(清单)
        //Tasking:
        // 1. Tom可以在界面输入要出石头、剪刀、还是布(0,1,2)；
        // 2. 电脑能够随机生成 0，1，2
        // 3. 设置规则， 0 与 1 比较； 1 与 2比较； 0 与 2比较；
        // 发现两个抽象：玩家 player（tom,computer),裁判judge（负责判断谁赢、输或者平局）                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   

        Player tom = new Player("Tom");
        Player computer = new Player("Computer");
        Judge judge = new Judge();

        do {
            System.out.println("请比赛选手Tom出拳：0表示石头，1表示剪刀，2表示布");
            Scanner input = new Scanner(System.in);
            int tomFistGuesture = input.nextInt();
            //自动生成
            int computerGuesture = computer.generateFistResult(0, 0);
            System.out.println("电脑所出手势为：" + judge.translateGuesture(computerGuesture));
            //接收输入
            int tomGuesture = tom.generateFistResult(1, tomFistGuesture);
            System.out.println("Tom所出手势为：" + judge.translateGuesture(tomGuesture));
            //输出结果
            String currentResult = judge.judgeMatch(tom, computer);
            System.out.println(currentResult);

            //输出Tom输赢清单
            System.out.println("Tom have Win: " + tom.getPlayerTotalWinTimes() + ", Lose: " + tom.getPlayerTotalLoseTimes() + ", Tie: " + tom.getPlyaerTotalTieTimes());
        } while (true);
    }
}

//代码
class Player {
    private String name;
    private int fistResult;
    private int winCount;
    private int loseCount;
    private int tieCount;

    public int generateFistResult(int generateWay, int inputFistResult) {
        if (generateWay == 0) {
            //自动生成
            this.fistResult = autoGenerateFistResult();
        } else if (generateWay == 1) {
            //接收输入值
            this.fistResult = inputFistResult;
        }
        return fistResult;
    }

    private int autoGenerateFistResult() {
        return (int) (Math.random() * 3);
    }

    public int getPlayFistGuesture() {
        return this.fistResult;
    }

    public String getPlayerName() {
        return this.name;
    }

    public int getPlayerTotalWinTimes() {
        return this.winCount;
    }

    public int getPlayerTotalLoseTimes() {
        return this.loseCount;
    }

    public int getPlyaerTotalTieTimes() {
        return this.tieCount;
    }

    public void win() {
        this.winCount++;
    }

    public void lose() {
        this.loseCount++;
    }

    public void tie() {
        this.tieCount++;
    }

    public Player(String name) {
        this.name = name;
    }
}

class Judge {

    public String judgeMatch(Player a, Player b) {
        //穷举： 0,1,2，  0表示石头，1表示剪刀，2表示布
        int aFistGuesture = a.getPlayFistGuesture();
        int bFistGuesture = b.getPlayFistGuesture();

        String result = "";
        //TODO 需要优化代码
        if (aFistGuesture == 0) {
            if (bFistGuesture == 1) {
                a.win();
                b.lose();
                result = a.getPlayerName() + " Win, " + b.getPlayerName() + " Lose! ";
            } else if (bFistGuesture == 2) {
                a.lose();
                b.win();
                result = a.getPlayerName() + " Lose, " + b.getPlayerName() + " Win! ";
            } else {
                a.tie();
                b.tie();
                result = a.getPlayerName() + " And " + b.getPlayerName() + " Tie!";
            }
        } else if (aFistGuesture == 1) {
            if (bFistGuesture == 0) {
                b.win();
                a.lose();
                result = a.getPlayerName() + " Lose, " + b.getPlayerName() + " Win!";
            } else if (bFistGuesture == 2) {
                b.lose();
                a.win();
                result = a.getPlayerName() + " Win, " + b.getPlayerName() + " Lose!";
            } else {
                a.tie();
                b.tie();
                result = a.getPlayerName() + " And " + b.getPlayerName() + " Tie!";
            }
        } else if (aFistGuesture == 2) {
            if (bFistGuesture == 0) {
                a.win();
                b.lose();
                result = a.getPlayerName() + " Win, " + b.getPlayerName() + " Lose!";
            } else if (bFistGuesture == 1) {
                a.lose();
                b.win();
                result = a.getPlayerName() + " Lose, " + b.getPlayerName() + " Win!";
            } else {
                a.tie();
                b.tie();
                result = a.getPlayerName() + " And " + b.getPlayerName() + " Tie!";
            }
        }
        return result;
    }

    public String translateGuesture(int fistGuesture) {
        String result = "";
        if (fistGuesture == 0) {
            result = "石头";
        } else if (fistGuesture == 1) {
            result = "剪刀";
        } else if (fistGuesture == 2) {
            result = "布";
        }
        return result;
    }

}