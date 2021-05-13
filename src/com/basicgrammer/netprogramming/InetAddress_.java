package com.basicgrammer.netprogramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author pi
 * @date 2021/05/13 22:12:31
 **/
@SuppressWarnings({"all"})
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        //1. 获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost:" + localHost);

        //2.根据指定主机名  获取 InetAddress对象
        InetAddress host = InetAddress.getByName("PYC");
        System.out.println("host:" + host);

        //3.根据域名返回 InetAddress对象，比如www.baidu.com
        InetAddress baiduHost = InetAddress.getByName("www.baidu.com");
        System.out.println("baiduHost:" + baiduHost);

        //4.通过InetAddress对象，获取对应的地址
        String baiduHostAddress = baiduHost.getHostAddress();
        System.out.println("baiduHostAddress:" + baiduHostAddress);

        //5.通过InetAddress对象，获取对应的主机名/或者域名
        String hostName = baiduHost.getHostName();
        System.out.println("hostName:" + hostName);

        //6.通过InetAddress对象， 获取主机地址
        String hostAddress = baiduHost.getHostAddress();
        System.out.println("hostAddress:" + hostAddress);
    }
}
