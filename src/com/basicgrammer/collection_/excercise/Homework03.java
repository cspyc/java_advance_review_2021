package com.basicgrammer.collection_.excercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Pi
 * @date 2021-04-21 14:08
 */
@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {
        //需求：使用HashMap类实例化一个Map类型的对象m,键(String)和值(int)分别用于存储员工的姓名和工资，
        // 存入数据如下：jack-650元；tom-1200元；smith-2900元；
        //将jack的工资更改为2600元
        //为所有员工工资加薪100元
        //遍历集合中所有的员工
        //遍历集合中所有的工资
        Map employees = new HashMap();
        employees.put("jack", 650);
        employees.put("tom", 1200);
        employees.put("smith", 2900);

        employees.put("jack", 2600);
        Set keys = employees.keySet();
        for (Object key : keys) {
            String name = (String) key;
            Integer salary = (Integer) employees.get(name);
            employees.put(name, salary + 100);
        }
        System.out.println(employees);

        Set entrySet = employees.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "-" + entry.getValue());

        }
    }
}
