package com.basicgrammer.interface_;

/**
 * @author pi
 * @date 2021/04/11 14:34:30
 **/
public interface DBInterface {
    /**
     * 创建数据库连接
     */
    public abstract void connection();

    /**
     * 关闭数据库连接
     */
    public abstract void close();
}
