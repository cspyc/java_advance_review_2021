package com.basicgrammer.collection_;

import java.util.HashMap;

/**
 * @author Pi
 * @date 2021-04-19 10:54
 */
public class HashMapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i <= 12; i++) {
            hashMap.put(i, "hello");
        }
        hashMap.put("aaa", "bbb");
        //0 -> 16(12) -> 32(24) -> 64(64*0.75=48)-> 128 (96) ->
        for (int i = 13; i <= 24; i++) {
            hashMap.put(i, "hello");
        }
        hashMap.put("bbb", "bbb");
        for (int i = 25; i <= 48; i++) {
            hashMap.put(i, "hello");
        }
        hashMap.put("ccc", "bbb");

        System.out.println("hashMap=" + hashMap);//12个 k-v

        //布置一个任务，自己设计代码去验证，table 的扩容
        //0 -> 16(12) -> 32(24) -> 64(64*0.75=48)-> 128 (96) ->
        //自己设计程序，验证-》 增强自己阅读源码能力. 看别人代码.
    }
}
