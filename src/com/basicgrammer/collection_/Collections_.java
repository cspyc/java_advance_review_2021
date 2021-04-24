package com.basicgrammer.collection_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pi
 * @date 2021-04-21 13:09
 */
@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        //测试Collections工具类方法

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("C");
        System.out.println("list的size:" + list.size());

        List destList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            destList.add("");
        }
        Collections.copy(destList, list);
        System.out.println(destList);
    }
}
