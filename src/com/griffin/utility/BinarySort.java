package com.griffin.utility;

import java.util.Arrays;
import java.util.List;

public class BinarySort {
/*
Write a binary sort class to improve search time across an ordered array of integers.
The array may contain duplicate entries, so binary searches should return first and last
occurrences.
 */
    public static void main(String[] args) {
        BinarySort binarySort = new BinarySort();
        binarySort.runTests();
    }

        public int findLowIndex (List<Integer> arr, int key) {
            // Find the first occurrence of 'key' in the input list of integers.
            // Perform a binary search by determining if the middle array entry
            // is of greater or lesser value than the key and repeating that
            // calculation to determine the first occurrence of the key.
            int low = 0;
            int high = arr.size() - 1;
            int mid = high / 2;

            while (low <= high) {
                int mid_elem = arr.get(mid);

                if (mid_elem < key) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
                mid = low + (high - low) / 2;
            }

            if (low < arr.size() && arr.get(low) == key) {
                return low;
            }

            return -1;
        }

        public int findHighIndex(List<Integer> arr, int key) {
            // Find the last occurrence of 'key' in the input list of integers.
            // Perform a binary search by determining if the middle array entry
            // is of greater or lesser value than the key and repeating that
            // calculation to determine the last occurrence of the key.
            int low = 0;
            int high = arr.size() - 1;
            int mid = high / 2;

            while (low <= high) {

                int mid_elem = arr.get(mid);

                if (mid_elem <= key) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
                mid = low + (high - low) / 2;
            }

            if(high == -1){
                return high;
            }

            if (arr.get(high) == key) {
                return high;
            }

            return -1;
        }

    public void runTests() {

        List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);

        int key = 4;
        int low = findLowIndex(array, key);
        int high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = 5;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = -2;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
    }
}
