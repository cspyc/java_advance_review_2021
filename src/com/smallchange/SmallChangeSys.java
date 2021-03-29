package com.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author pi
 * @date 2021/03/25 10:41:11
 **/
public class SmallChangeSys {
    public static void main(String[] args) {

        //菜单显示
        boolean loop = true;

        //零钱通明细：使用String拼接
        String changeDetail = "-----------------零钱通明细---------------";

        //收益入账
        double money = 0.0;
        double balance = 0.0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //消费
        String spendDetail = "";
        do {
            //菜单-固定显示内容
            System.out.println("\n--------------零钱通菜单---------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消   费");
            System.out.println("\t\t\t4 退   出");
            System.out.println("请选择(1-4):");

            //菜单-输入、输出交互
            Scanner scanner = new Scanner(System.in);
            int inputMenuId = scanner.nextInt();
            //根据用户输入的不同值，跳转到不同的功能
            if (inputMenuId == 1) {
                System.out.println(changeDetail);
            } else if (inputMenuId == 2) {
                System.out.println("收益入账金额：");
                money = scanner.nextDouble();
                //收益入账金额需要校验
                //考虑异常路径
                if(money < 0) {
                    System.out.println("收入金额不能为负！");
                    continue;
                }

                balance += money;
                date = new Date();
                changeDetail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;

            } else if (inputMenuId == 3) {
                System.out.println("请输入消费项目：");
                spendDetail = scanner.next();

                System.out.println("请输入消费金额：");
                money = scanner.nextDouble();

                //消费金额需要检验：消费金额不能为负；消费金额不能超过余额
                //对异常数据的处理
                if(money < 0){
                    System.out.println("消费金额不能为负！");
                    continue;
                }
                if(money > balance) {
                    System.out.println("余额不足！");
                    continue;
                }

                balance -= money;
                date = new Date();
                changeDetail += "\n" + spendDetail + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
            } else if (inputMenuId == 4) {
                //用户输入"4"退出时，给出提示"你确定要退出吗?y/n",必须输入正确的y/n，否则循环输入指令，直到输入y或者n
                String choice = "";
                while (true) {
                    System.out.println("你确定要退出吗?y/n");

                    choice = scanner.next();
                    if ("y".equals(choice) || "n".equals(choice)) {
                        break;
                    } else {
                        System.out.println("请输入正确的指令！");
                    }
                }
                if ("y".equals(choice)) {
                    System.out.println("------------正在退出零钱通-----------");
                    loop = false;
                }
            } else {
                System.out.println("请输入正确的菜单编号！");
            }
        } while (loop);

        System.out.println("退出程序成功.....");
    }


}
