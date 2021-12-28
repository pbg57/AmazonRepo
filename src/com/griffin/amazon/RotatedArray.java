package com.griffin.amazon;

import java.util.Arrays;
import java.util.List;
import com.griffin.utility.BinarySort;

public class RotatedArray {

    public static void main( String [] args) {
        RotatedArray rotatedArray = new RotatedArray();
        rotatedArray.runTests();
    }

    public void runTests() {

        List<Integer> intList = Arrays.asList(0,2,2,3,4,5);
        int key = 3;

        BinarySort binarySort = new BinarySort();
        int low = binarySort.findLowIndex(intList, key);
        int high = binarySort.findHighIndex(intList, key);

        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);



    }
}
