package com.griffin.amazon;/*
See description of problem at https://www.educative.io/blog/crack-amazon-coding-interview-questions#overview
 */

import java.util.*;
import java.util.stream.Collectors;

/*
1. Find the missing number in the array
You are given an array of positive numbers from 1 to n, such that all numbers
from 1 to n are present except one number x. You have to find x. The input array
is not sorted. Look at the below array and give it a try before checking the solution.
 */
public class MissingNumber {


    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        int[] inpArray1 = new int[]{3, 7, 1, 2, 8, 4, 5};
        int[] inpArray2 = new int[]{3,7, 1, 2, 8, 4, 5, 6,10};
        int[] inpArray3 = new int[]{9,7, 1, 2, 8, 4, 5, 6,10};


        int missingResult = missingNumber.runTests(inpArray1);
        System.out.println("MissingTest found " + missingResult);

        missingResult = missingNumber.runTests(inpArray2);
        System.out.println("MissingTest found " + missingResult);

        missingResult = missingNumber.runTests2(inpArray2);
        System.out.println("MissingTest2 found " + missingResult);

        missingResult = missingNumber.runTests2(inpArray3);
        System.out.println("MissingTest2 found " + missingResult);


    }

    public int runTests(int[] inputArray) {

        // Convert input array to a Set, which only allows unique members.
        // Furthermore, use a SortedSet (TreeSet) and add Integers to it (which implement Comparable interface already)


        List<Integer> intList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());

        Set<Integer> treeSet = new TreeSet<>(intList);

        Integer next = null;
        for (Integer i : treeSet) {

            // first = (first == null) ? i : first;
            if (next == null) {
                next = i;
                continue;
            } else {
                // Check to see if continuous ints found?
                if (i == (next + 1)) {
                    next = i;
                    continue;
                } else {
                    // Found missing integer
                    return (next +1);
                }
            }
        }
        return -1;
    }
    public int runTests2(int[] inputArray) {

        // Repeat solution above using different algorithm
        // Compute the sum of the arithmetic series for a integer array with no missing values.
        // Then compute the sum of the given array (with missing value).
        // The difference of the two sums is the value of the missing integer.
        // Runtime complexity: Linear - O(n) == on the order of number of terms, n.
        // Memory complexity: O(1) == constant

        int sum_of_elements  = 0;
        int expected_sum = 0;


        for (int i=0; i<inputArray.length; i++) {
            sum_of_elements += inputArray[i];
        }

        // To compute expected sum, we must first sort, so we know what beginning int value is?
        List<Integer> intList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
        Set<Integer> treeSet = new TreeSet<>(intList);

            for (Integer intElem: intList) {
                sum_of_elements += intElem;
            }
//
//
//        // Need to know first int value in the sorted array
        int startingInt = 0;

        for (Integer i: treeSet) {
            startingInt = i;
            break;
        }

//
//        expected_sum = startingInt;
//        for (int i = 0; i< treeSet.size()+1; i++) {
//            expected_sum = (expected_sum+1);
//        }


        expected_sum = startingInt;
        int subtotal = startingInt;
        for (int i=0; i<inputArray.length; i++) {
            expected_sum += 1;
            subtotal += expected_sum;
        }

        return subtotal - sum_of_elements;
    }

}
