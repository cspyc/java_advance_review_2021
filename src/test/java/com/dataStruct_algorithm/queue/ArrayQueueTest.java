package com.dataStruct_algorithm.queue;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

/**
 * @author Pi
 * @date 2021-04-28 12:34
 */
@DisplayName("Array Queue Test Cases")
public class ArrayQueueTest {

    @Test
    public void should_throw_queue_is_empty_exception_when_get_element_from_empty_queue() throws Exception {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue(2);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Integer element = arrayQueue.get();
        });
    }

    @Test
    public void should_return_1_from_queue_when_first_push_1() throws Exception {
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>(2);
        integerArrayQueue.push(1);
        integerArrayQueue.push(2);
        Assertions.assertEquals(integerArrayQueue.get(), 1);
    }

    @Test
    public void should_throw_exception_when_push_element_if_queue_is_full() throws Exception {
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<Integer>(1);
        Assertions.assertThrows(RuntimeException.class, () -> {
            integerArrayQueue.push(0);
            integerArrayQueue.push(1);
        });
    }

    @Test
    public void should_return_all_queue_element() throws Exception {
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>(3);
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
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>(2);
        integerArrayQueue.push(1);
        integerArrayQueue.push(2);
        Assertions.assertEquals(integerArrayQueue.head(), 1);
    }
}
