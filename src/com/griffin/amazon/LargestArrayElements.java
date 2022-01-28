package com.griffin.amazon;

import com.griffin.utility.LearnException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestArrayElements {

    /*
    Write a class that takes an input array of integers, orders them and returns
    a sub list of the largest K values.
     */
    public static void main( String [] args) throws LearnException {

        LargestArrayElements largestArrayElements =  new LargestArrayElements();

        int [] inputArray = new int[] {3,5,4,6,5,7,8};

        List<Integer> returnList = largestArrayElements.runTests(inputArray, 5);
        System.out.println("Return List: " + returnList);

        returnList = largestArrayElements.runTests(inputArray,7);
        System.out.println("Return List: " + returnList);
    }

    public List<Integer> runTests(int [] intArray, int K) throws LearnException {

        if (K > intArray.length)
            throw new LearnException("K is larger than array");

        // Given an unsorted array, find the largest K elements.
        List<Integer> intList = Arrays.stream(intArray).boxed().toList();

        // Note: must use mutable ArrayList in order to call sort() method.
        ArrayList<Integer> intArrayList = new ArrayList<>(intList);

//        List<Integer> intList1 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        List<Integer> intList1 = Arrays.stream(intArray).boxed().toList();


        System.out.println("List: " + intList);
        System.out.println("List: " + intList1);

        intArrayList.sort(null);
        System.out.println("List: " + intArrayList);

        // Return sub-list of largest K items.
        return intArrayList.subList(intArrayList.size()-K, intArrayList.size());
    }
}
