package com.object.interface_;

/**
 * @author pi
 * @date 2021/04/11 15:59:15
 **/
public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向，实现了该接口的类的对象实例
        IG ig = new Teacher();
        //如果IG 继承了 IH 接口，而Teacher类实现了IG接口
        //那么，实际上就相当于Teacher 类也实现了IH接口
        //这就是所谓的  接口多态传递现象
        IH ih = new Teacher();
    }
}

interface IH{
    void hi();
}

interface IG extends IH{}

class Teacher implements IG{
    @Override
    public void hi() {

    }
}