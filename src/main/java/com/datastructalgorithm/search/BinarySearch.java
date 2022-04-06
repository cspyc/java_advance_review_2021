package com.datastructalgorithm.search;

/**
 * @author pi
 * @date 2022/04/05 23:42:40
 **/
public class BinarySearch {

    public int binarySearch(int[] originOrderedArray, int targetNum) {

        //数组关键位置
        int low = 0;
        int high = originOrderedArray.length - 1;

        while (low <= high) {
            int mid = Math.floorDiv(low + high, 2);
            int guessNum = originOrderedArray[mid];
            if (targetNum == guessNum) {
                return mid;
            }

            if (guessNum < targetNum) {
                low = mid + 1;
            }

            if (guessNum > targetNum) {
                high = mid - 1;
            }

        }

        return -1;

    }
}
