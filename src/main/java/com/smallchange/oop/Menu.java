package com.smallchange.oop;

import java.util.Scanner;

/**
 * @author pi
 * @date 2021/03/25 15:20:02
 **/
public class Menu {

    public void showMenu() {
        //菜单-固定显示内容
        System.out.println("\n--------------零钱通菜单---------------");
        System.out.println("\t\t\t1 零钱通明细");
        System.out.println("\t\t\t2 收益入账");
        System.out.println("\t\t\t3 消   费");
        System.out.println("\t\t\t4 退   出");
        System.out.println("请选择(1-4):");
    }


    private  void selectMenuFunction() {
        boolean showMenuLoop = true;
        Account myAccount = new Account();
        Scanner input = new Scanner(System.in);

        do {
            this.showMenu();
            String menuChoice = input.next();
            switch (menuChoice){
                case "1" :
                    myAccount.showDetail();
                    break;
                case "2":
                    System.out.println("请输入收入金额：");
                    double inCome = input.nextDouble();
                    myAccount.gain(inCome);
                    break;
                case "3":
                    System.out.println("请输入消费项目：");
                    String spendItem = input.next();
                    System.out.println("请输入消费金额：");
                    double payment = input.nextDouble();
                    myAccount.spend(payment,spendItem);
                    break;
                case "4":
                    showMenuLoop = this.quit();
                    break;
                default:
                    System.out.println("请输入正确的菜单编号！");
            }
        } while (showMenuLoop);

        System.out.println("程序已退出.......");
    }

    public boolean quit(){
        boolean menuLoop = true;
        //用户输入"4"退出时，给出提示"你确定要退出吗?y/n",必须输入正确的y/n，否则循环输入指令，直到输入y或者n
        String choice = "";
        while (true) {
            System.out.println("你确定要退出吗?y/n");
            Scanner input = new Scanner(System.in);
            choice = input.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            } else {
                System.out.println("请输入正确的指令！");
            }
        }
        if ("y".equals(choice)) {
            System.out.println("------------正在退出零钱通-----------");
            menuLoop = false;
        }
        return menuLoop;
    }
}
