package com.griffin.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TargetSum {
/*
Write a class to determine if an input array contains two addends totaling a key value.
 */
    static public void main(String [] args) {

        TargetSum targetSum = new TargetSum();

        int [] input  = new int [] {5,7,1,2,8,4,3};
        boolean result = targetSum.runTest(input, 10);
        System.out.println("com.griffin.amazon.TargetSum addends total 10, result :" + result);
        result = targetSum.runTest(input, 100);
        System.out.println("com.griffin.amazon.TargetSum addends total 100, result :" + result);
    }

    public boolean runTest( int [] anArray, int val) {

        // Determine if any two addend ints in the input array sum to the input val?

        // Use a Hashset for perf reasons
        // The hashset (backed by hashmap) does not guarantee iteration order (not needed here).
        // The hashset offers constant performance based on its size (number of elements)  plus
        // the capacity of the backing hashmap.

        // Box int -> Integer and into a list which can be used to construct the HashSet
        List<Integer> intList = Arrays.stream(anArray).boxed().toList();
        HashSet<Integer> intHash = new HashSet<>(intList);

        for (Integer intElem: intHash) {
            Integer addendNeeded = val-intElem;
            if (intHash.contains(addendNeeded))
                return true;
        }
        return false;
    }
}
