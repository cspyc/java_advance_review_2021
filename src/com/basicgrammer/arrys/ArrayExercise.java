package com.basicgrammer.arrys;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Pi
 * @date 2021-04-16 20:47
 */
public class ArrayExercise {
    public static void main(String[] args) {
        //需求：自定义Book类，里面包含name和price，按price排序(从大到小)。要求使用两种方式排序，
        //有一个Book[] books = 4本书对象

        //使用 传递实现Comparator接口 匿名内部类，也称为定制排序。
        //按照price 1> 从大到小；2>从小到大；3>按照书名长度
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("新金瓶梅", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃", 2000);

        //按照price从大到小排序
        Book[] books1 = Arrays.copyOf(books, books.length);
        Arrays.sort(books1, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //不能直接强转，如果是差价只有0.几，最后结果是个0，这样是有问题的
//                return (int) (o2.getPrice() - o1.getPrice());
                double price = o2.getPrice() - o1.getPrice();
                if (price > 0) {
                    return 1;
                } else if (price < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("======按照price从大到小排序=========");
        System.out.println(Arrays.toString(books1) + "\n");

        Book[] books2 = Arrays.copyOf(books, books.length);
        Arrays.sort(books2, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //不能直接强转，如果是差价只有0.几，最后结果是个0，这样是有问题的
//                return (int) (o1.getPrice() - o2.getPrice());
                double price = o1.getPrice() - o2.getPrice();
                if (price > 0) {
                    return 1;
                } else if (price < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("==========按照price从小到大排序-------");
        System.out.println(Arrays.toString(books2) + "\n");

        Book[] books3 = Arrays.copyOf(books, books.length);
        Arrays.sort(books3, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        System.out.println("==========按照书名长度从小到大排序-------");
        System.out.println(Arrays.toString(books3) + "\n");
    }

}
