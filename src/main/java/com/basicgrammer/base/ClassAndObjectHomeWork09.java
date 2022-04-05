package com.basicgrammer.base;

public class ClassAndObjectHomeWork09{
    public static void main(String[] args){
        //需求：定义Music类，里面有音乐名name、音乐时长times属性，并有播放play功能和返回本身属性信息的功能方法getInfo
        Music m = new Music("你好，世界！",10.23);
        System.out.println(m.getInfo());
        System.out.println(m.play());
    }
}

class Music{
    private String name;
    private double times;

    public Music(){}
    public Music(String name,double times){
        this.name = name;
        this.times = times;
    }   

    public String getInfo(){
        return "歌曲名称为：" + this.name + ",时长：" + this.times;
    }

    public String play(){
        return "开始播放歌曲：" + this.name;
    }
}