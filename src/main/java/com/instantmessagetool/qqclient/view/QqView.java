package com.instantmessagetool.qqclient.view;

import com.instantmessagetool.qqclient.util.Utility;

/**
 * @author pi
 * @date 2021/05/16 18:12:50
 **/
public class QqView {

    /**
     * 控制是否显示菜单
     */
    private boolean loop = true;
    /**
     * 接收用户键盘输入
     */
    private String key = "";

    public static void main(String[] args) {
        new QqView().mainMenu();
    }

    /**
     * 显示主菜单
     */
    private void mainMenu() {
        while (loop) {
            System.out.println("--------------------------欢迎登录网络通信系统-------------------------");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);

            //根据用户的输入，来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String passWord = Utility.readString(3);

                    if ("100".equals(userId) && "123".equals(passWord)) {
                        System.out.println("----------------------------欢迎 " + userId + " 用户----------------------------");
                        secondMenu(userId);
                    } else {
                        System.out.println("用户名或密码错误，登录失败！");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 二级菜单显示
     *
     * @param userId 用户标识
     */
    private void secondMenu(String userId) {
        boolean showSecondMenu = true;

        while (showSecondMenu) {
            System.out.println("--------------------------网络通信系统二级菜单(用户" + userId + ")-------------------------");
            System.out.println("\t\t 1 显示在线用户列表");
            System.out.println("\t\t 2 群发消息");
            System.out.println("\t\t 3 私聊消息");
            System.out.println("\t\t 4 发送文件");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);

            //根据用户的输入，来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.println("---------------当前在线用户列表-----------------");
                    break;
                case "2":
                    System.out.println("请输入想说的话");
                    break;
                case "3":
                    System.out.println("请输入想聊天的用户号(在线)：");

                    System.out.println("请输入想说的话：");

                    break;
                case "4":
                    System.out.println("请输入想发送文件的用户号(在线)：");

                    System.out.println("请输入发送的文件完整路径(形式:d:\\xxx.jpg):");

                    System.out.println("请输入发送文件到对方的路径(形式:d:\\xxx.jpg):");

                    break;
                case "9":
                    showSecondMenu = false;
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}
