package com.basicgrammer.interface_;

/**
 * @author pi
 * @date 2021/04/11 14:36:55
 **/
public class OracleDB implements DBInterface{

    @Override
    public void connection() {
        System.out.println("连接oracle数据库...");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle数据库连接...");
    }
}
