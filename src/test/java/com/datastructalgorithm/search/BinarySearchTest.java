package com.datastructalgorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author pi
 * @date 2022/04/05 23:35:23
 **/
public class BinarySearchTest {
    @Test
    public void should_test_binary_search() throws Exception {
        int[] originOrderedArray = {1,4,22,44,99,123,333,343,999};
        int targetNum = 333;
        BinarySearch binarySearch = new BinarySearch();

        int targetNumIndex = binarySearch.binarySearch(originOrderedArray,targetNum);
        assertEquals(targetNumIndex,6);

    }
}
