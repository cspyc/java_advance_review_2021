package com.basicgrammer.iostream.outputstream;

import java.io.Serializable;

/**
 * @author Pi
 * @date 2021-05-10 12:45
 */
public class Dog implements Serializable {

//   不希望通过编译来强制划分软件版本，即实现序列化接口的实体能够兼容先前版本，
//    显式地定义一个名为serialVersionUID，类型为long的变量，不修改这个变量值的序列化实体都可以相互进行串行化和反串行化
    private static final long serialVersionUID = -7338733701783687252L;

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

