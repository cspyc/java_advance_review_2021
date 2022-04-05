package com.dataStruct_algorithm.sort;

import com.dataStruct_algorithm.sort.QuickSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author pi
 * @date 2021/06/29 23:18:27
 **/
public class QuickSorterTest {

    @Test
    public void should_return_sorted_array_using_quick_sort() throws Exception {
        QuickSorter quickSorter = new QuickSorter();
        Integer[] originArray = {3, 5, 8, 1, 22, 37, 11};
        Integer[] result = quickSorter.quickSort(originArray, 0, originArray.length - 1);

        Integer[] expectedArray = {1, 3, 5, 8, 11, 22, 37};
        Assertions.assertArrayEquals(result, expectedArray);
    }

}
