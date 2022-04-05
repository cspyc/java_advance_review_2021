package com.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pi
 * @date 2021/03/25 15:06:20
 **/
public class Account {
    private double inCome;
    private double payment;
    private double balance;
    private String detail;

    public String showDetail() {
        return detail;
    }

    public void gain(double inCome) {
        //收益入账金额需要校验
        //考虑异常路径
        if(checkIncomeMoney(inCome)){
            return;
        }
        this.inCome = inCome;
        this.balance += inCome;
        this.detail += gainDetail();
    }

    private boolean checkIncomeMoney(double inCome) {
        if(inCome < 0) {
            System.out.println("收入金额不能为负！");
            return true;
        }
        return false;
    }

    private String gainDetail() {
        return "\n收益入账\t+" + this.inCome + "\t" + this.getDateString() + "\t" + this.balance;
    }

    private String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        return sdf.format(currentDate);
    }

    public void spend(double fare, String spendItem) {
        if (checkSpendMoney(fare)) {
            return;
        }

        this.payment = fare;
        this.balance -= fare;
        this.detail += spendDetail(spendItem);
    }

    private boolean checkSpendMoney(double fare) {
        if(fare < 0){
            System.out.println("消费金额不能为负！");
            return true;
        }
        if(fare > balance) {
            System.out.println("余额不足！");
            return true;
        }
        return false;
    }

    private String spendDetail(String spendItem) {
        return "\n" + spendItem + "\t+" + this.payment + "\t" + this.getDateString() + "\t" + this.balance;
    }
}
