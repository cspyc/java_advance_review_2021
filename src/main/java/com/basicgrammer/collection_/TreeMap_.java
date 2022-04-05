package com.basicgrammer.collection_;

import java.util.TreeMap;

/**
 * @author Pi
 * @date 2021-04-19 14:23
 */
@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(new A("3"), 11);
        treeMap.put(new A("1"), 22);
        treeMap.put(new A("2"), 33);

        System.out.println(treeMap);
    }
}

class A{
    private String id;

    public A(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
