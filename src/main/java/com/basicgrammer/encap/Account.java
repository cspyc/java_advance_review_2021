package com.basicgrammer.encap;

/**
 * @author pi
 * @date 2021/03/22 18:07:51
 **/
public class Account {
    private String name;
    private double balance;
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int nameLength = name.length();
        if (nameLength == 2 || nameLength == 3 || nameLength == 4) {
            this.name = name;
        } else {
            System.out.println("姓名长度不符合要求！");
            this.name = "Abc";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance > 20) {
            this.balance = balance;
        }else {
            System.out.println("余额必须大于20");
            this.balance = 30;
        }
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if(passWord != null && passWord.length() == 6) {
            this.passWord = passWord;
        }else {
            System.out.println("密码长度必须是6位");
            this.passWord = "123456";
        }
    }
}
