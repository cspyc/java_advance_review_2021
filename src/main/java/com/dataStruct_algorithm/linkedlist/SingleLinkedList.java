package com.dataStruct_algorithm.linkedlist;

/**
 * @author pi
 * @date 2021/07/02 18:23:09
 **/
public class SingleLinkedList {

    private Node head;

    /**
     * 向链表添加元素,尾部添加
     */
    public void add(Node node) {
        Node index = head;
        while (index.next != null) {
            index = index.next;
        }
        index.next = node;
    }

    /**
     * 遍历链表，打印出所有
     */
    public void list() {
        Node index = head;
        while (index.next != null) {
            index = index.next;
            System.out.println(index);
        }
    }

    public SingleLinkedList() {
        this.head = new Node(0, "头结点");
    }

    static class Node {
        private int no;
        private String name;
        private Node next;

        public Node(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}


