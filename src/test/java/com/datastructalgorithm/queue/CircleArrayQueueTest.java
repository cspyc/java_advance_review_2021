package com.datastructalgorithm.queue;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

/**
 * @author Pi
 * @date 2021-04-28 12:34
 */
@DisplayName("Array Queue Test Cases")
public class CircleArrayQueueTest {

    @Test
    public void should_throw_queue_is_empty_exception_when_get_element_from_empty_queue() throws Exception {
        CircleArrayQueue<Integer> arrayQueue = new CircleArrayQueue(2);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Integer element = arrayQueue.get();
        });
    }

    @Test
    public void should_return_1_from_queue_when_first_push_1() throws Exception {
        CircleArrayQueue<Integer> integerArrayQueue = new CircleArrayQueue<>(3);//留有一个空位
        integerArrayQueue.push(1);
        integerArrayQueue.push(2);
        Assertions.assertEquals(integerArrayQueue.get(), 1);
    }

    @Test
    public void should_throw_exception_when_push_element_if_queue_is_full() throws Exception {
        CircleArrayQueue<Integer> integerArrayQueue = new CircleArrayQueue<Integer>(1);
        Assertions.assertThrows(RuntimeException.class, () -> {
            integerArrayQueue.push(0);
            integerArrayQueue.push(1);
        });
    }

    @Test
    public void should_return_all_queue_element() throws Exception {
        CircleArrayQueue<Integer> integerArrayQueue = new CircleArrayQueue<>(4);
        integerArrayQueue.push(1);
        integerArrayQueue.push(2);
        integerArrayQueue.push(3);
        Object[] elements = integerArrayQueue.list();
        Assertions.assertAll("elements",
                () -> Assertions.assertEquals(elements[0], 1),
                () -> Assertions.assertEquals(elements[1], 2),
                () -> Assertions.assertEquals(elements[2], 3));
    }

    @Test
    public void should_return_1_when_push_first_element_is_1() throws Exception {
        CircleArrayQueue<Integer> integerArrayQueue = new CircleArrayQueue<>(3);
        integerArrayQueue.push(1);
        integerArrayQueue.push(2);
        Assertions.assertEquals(integerArrayQueue.head(), 1);
    }
}
