package com.basicgrammer.collection_.excercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pi
 * @date 2021-04-21 13:33
 */
@SuppressWarnings({"all"})
public class HomeWork01 {
    public static void main(String[] args) {
        //需求:封装一个新闻类，包含标题和内容属性，提供get,set方法，重写toString方法，打印对象时只打印标题；
        //只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
        //新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河"圣浴"，引民众担忧
        //新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生
        //将新闻对象添加到ArrayList集合中，并且进行倒序遍历
        //在遍历集合过程中，对新闻标题进行处理，超过15个字的只保留前15个，然后在后边加"..."
        //在控制台打印遍历出经过处理的新闻标题
        List newsList = new ArrayList();
        newsList.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"，引民众担忧"));
        newsList.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

        //倒序遍历
        for (int i = newsList.size() - 1; i >= 0; i--) {
            String title = ((News) (newsList.get(i))).getTitle();
            if (title.length() > 15) {
                title = title.replace(title.substring(15, title.length()), "...");
            }
            System.out.println(title);
        }
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "news{" +
                "title='" + title +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
