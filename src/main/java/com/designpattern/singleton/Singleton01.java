package com.designpattern.singleton;

/**
 * @author pi
 * @date 2021/04/10 20:43:45
 **/
public class Singleton01 {
    public static void main(String[] args) {
        GirlFriend gf = GirlFriend.getInstance();
        System.out.println(gf);

        GirlFriend gf2 = GirlFriend.getInstance();
        System.out.println(gf2);

        System.out.println(gf == gf2);
    }
}

class GirlFriend{
    private String name;

    //单例模式-饿汉式  创建步骤
    //1.私有化构造器；
    //2.内部创建实例对象(静态属性)；
    //3.提供一个公共的静态方法，供外部调用实例

    //为了能够在静态方法中，返回gf对象，需要将其修饰为static
    private static GirlFriend gf = new GirlFriend("Who");

    public static GirlFriend getInstance(){
        return gf;
    }
    private GirlFriend() {
    }

    private GirlFriend(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
