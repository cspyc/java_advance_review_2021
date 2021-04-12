package com.object.interface_;

/**
 * @author pi
 * @date 2021/04/11 14:35:58
 **/
public class MySqlDB implements DBInterface {
    @Override
    public void connection() {
        System.out.println("连接mysql数据库...");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql数据库连接...");
    }
}
