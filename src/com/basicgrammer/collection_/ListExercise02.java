package com.basicgrammer.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pi
 * @date 2021-04-17 19:20
 */
public class ListExercise02 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //需求：使用List的实现类添加三本图书，并遍历，打印效果如下
        //名称：xx   价格：xx    作者:xx
        //要求：按价格排序，从低到高(使用冒泡法)
        // 使用 ArrayList,LinkedList和Vector三种集合实现
        List books = new ArrayList();
        books.add(new Book("红楼梦", "曹雪芹", 100.0));
        books.add(new Book("西游记", "吴承恩", 199.0));
        books.add(new Book("三国演义", "罗贯中", 111.0));

        for (Object o : books) {
            System.out.println(o);
        }

        System.out.println("=======排序后========");
        List sortedBooks = sortByPriceUsingBubbleSort(books);
        Iterator iterator = sortedBooks.iterator();
        while (iterator.hasNext()) {
            Book next = (Book) iterator.next();
            String printStr = String.format("名称：%s\t价格：%f\t作者:%s", next.getName(), next.getPrice(), next.getAuthor());
            System.out.println(printStr);
        }


    }

    private static List sortByPriceUsingBubbleSort(List books) {
        int bookCount = books.size();
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = 0; j < bookCount - i - 1; j++) {
                Book a = (Book) books.get(j);
                Book b = (Book) books.get(j + 1);
                if (a.getPrice() > b.getPrice()) {
                    books.set(j, b);
                    books.set(j + 1, a);
                }
            }
        }
        return books;
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t价格：" + price + "\t作者:" + author;
    }
}
