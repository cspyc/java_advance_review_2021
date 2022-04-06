package com.datastructalgorithm.queue;

import java.util.NoSuchElementException;

/**
 * @author pi
 * @date 2021/07/02 12:18:36
 * 环形数组队列
 **/
@SuppressWarnings({"all"})
public class CircleArrayQueue<T> {

    private int maxSize;//队列保存最多元素个数,留有一个空位，实际只能容纳maxSize - 1个
    private int head = 0;//头指针，指向队列头的前一个位置
    private int rear = 0;//尾指针，指向队列尾部(队列的最后一个数据)
    private Object[] elements;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == head;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == head;
    }

    /**
     * 从队列中取出数据
     *
     * @return
     * @throws Exception
     */
    public T get() throws Exception {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空，无法取出元素");
        }
        //初始，head指向队列的第一个元素
        Object element = elements[head];
        //将front后移，考虑取模
        head = (head + 1) % maxSize;
        return (T) element;
    }


    /**
     * 往队列中添加数据
     *
     * @param element
     */
    public void push(T element) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加元素");
        }
        //直接将数据加入
        elements[rear] = element;
        //rear后移
        rear = (rear + 1) % maxSize;
    }

    /**
     * 返回队列中所有元素
     *
     * @return
     */
    public Object[] list() {
        int elementSize = getElementSize();
        Object[] allElement = new Object[elementSize];

        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出元素");
        }
        //遍历
        for (int i = head; i < head + elementSize; i++) {
            int j = 0;
            allElement[j] = elements[i % maxSize];
            j++;
        }
        return elements;
    }

    /**
     * 返回队列头节点
     *
     * @return
     */
    public T head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出头元素");
        }
        return (T) elements[head];
    }

    /**
     * 求出队列有效数据个数
     *
     * @return
     */
    public int getElementSize() {
        return (rear + maxSize - head) % maxSize;
    }
}
