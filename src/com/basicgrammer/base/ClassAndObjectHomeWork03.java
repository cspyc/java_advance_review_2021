package com.basicgrammer.base;

public class ClassAndObjectHomeWork03{
    public static void main(String[] args){
        //需求：编写类Book，定义方法updatePrice,实现更改某本书的价格，具体：如果价格 > 150;则更改为150，如果价格 > 100,更改为100，否则不变
       Book book1 = new Book("你好，世界！", 1000);
       double modifedBookPrice1 = book1.modifyPrice(); 
       System.out.print("书籍更新后的价格：" + modifedBookPrice1);
    }
}

class Book{
    private String name;
    private double price;

    public Book(){}

    public Book(String name,double price){
        this.name = name;
        this.price = price;
    }

    public double modifyPrice() {
        if(this.price > 150) {
            this.price = 150;
            return this.price;
        } else if(this.price > 100) {
            this.price = 100;
            return this.price;
        } else {
            return this.price;
        }
    }
}