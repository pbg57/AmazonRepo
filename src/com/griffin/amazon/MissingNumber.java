package com.griffin.amazon;

/*
See description of problem at https://www.educative.io/blog/crack-amazon-coding-interview-questions#overview
 */

/*
Find the missing number in the array:
You are given an array of positive numbers from 1 to n, such that all numbers
from 1 to n are present except one number x. You have to find x. The input array
is not sorted.
 */
public class MissingNumber {

    // Algorithm:
    //      1. Compute the sum of the arithmetic series for an integer array with no missing values.
    //      2. Compute the sum of the given array (with missing value).
    //      3. The difference of the two sums is the value of the missing integer.
    //      Note: arrays start at value of 1 (arrays[0] == 1); arrays do no contain duplicate values.
    // Runtime complexity: Linear - O(n) == on the order of number of terms, n.
    // Memory complexity: O(1) == constant

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        int[] inpArray1 = new int[]{3, 7, 1, 2, 8, 4, 5};
        int[] inpArray2 = new int[]{3, 7, 1, 2, 8, 4, 5, 6, 10};
        int[] inpArray3 = new int[]{9, 7, 1, 2, 8, 4, 5, 6, 10};


        int missingResult = missingNumber.runTests(inpArray1);
        System.out.println("MissingTest expected 6 found " + missingResult);

        missingResult = missingNumber.runTests(inpArray2);
        System.out.println("MissingTest expected 9 found " + missingResult);

        missingResult = missingNumber.runTests(inpArray3);
        System.out.println("MissingTest expected 3 found " + missingResult);


    }


    public int runTests(int[] inputArray) {

        // Algorithm:
        //      1. Compute the sum of the arithmetic series for an integer array with no missing values.
        //      2. Compute the sum of the given array (with missing value).
        //      3. The difference of the two sums is the value of the missing integer.
        //      Note: arrays start at value of 1 (arrays[0] == 1); arrays do no contain duplicate values.
        // Runtime complexity: Linear - O(n) == on the order of number of terms, n.
        // Memory complexity: O(1) == constant

        int noMissingElementsSum = 0;
        for (int i = 1; i < inputArray.length + 2; i++) {    // Iterate for array length + 2, starting with index 1
            noMissingElementsSum += i;
        }

        int inputElementsSum = 0;
        for (int j : inputArray) {      // Iterate to sum array values
            inputElementsSum += j;
        }

        // Difference is value of missing integer
        return noMissingElementsSum - inputElementsSum;
    }

}
