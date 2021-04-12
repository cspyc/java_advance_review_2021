package com.designpattern.template;

/**
 * @author pi
 * @date 2021/04/11 13:42:20
 **/
public abstract class Template {

    public abstract void job();

    public void calculateTime(){
        long beginTime = System.currentTimeMillis();
        //多态-动态绑定-从运行中的类查找相关方法
        job();
        long endTime = System.currentTimeMillis();

        System.out.println("执行任务花费时间：" + (endTime - beginTime));
    }
}
