package com.datastructalgorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pi
 * @date 2022/04/06 23:16:33
 **/
public class SelectionSortTest {
    @Test
    public void should_return_smallest_element() throws Exception {
        int[] testArray = {3,54,11,1,33};
        SelectionSort selectionSort = new SelectionSort();
        int result = selectionSort.findSmallestElement(testArray);
        Assertions.assertEquals(3,result);
    }

    @Test
    public void should_return_sorted_array() throws Exception {
        int[] array = {3,22,43,21,1,33};
        SelectionSort selectionSort = new SelectionSort();
        int[] result = selectionSort.selectionSort(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        Assertions.assertArrayEquals(new int[]{1,3,21,22,33,43},result);
    }
}
