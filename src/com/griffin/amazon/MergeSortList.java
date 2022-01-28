package com.griffin.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MergeSortList {
    /*
    Write a class that processes two linked lists by merging, ordering, and de-duplicating entries.
     */
    static public void main(String[] args) {
        MergeSortList mergeSortList = new MergeSortList();

        int[] intArray1 = new int[]{2, 4, 6, 8, 9};
        int[] intArray2 = new int[]{1, 3, 5, 7, 9};

        LinkedList<Integer> llList1 = Arrays.stream(intArray1).boxed().collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Integer> llList2 = Arrays.stream(intArray2).boxed().collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Integer> result = mergeSortList.runTest(llList1, llList2);
        System.out.println("com.griffin.amazon.MergeSortList result: " + result.toString());

    }


    public LinkedList<Integer> runTest(LinkedList<Integer> inputList1, LinkedList<Integer> inputList2) {
        // Given two sorted linked lists, merge them so that the resulting linked list is also sorted.
        // Use an ordered and unique collection TreeSet to sort a copy of the LinkedList input
        TreeSet<Integer> treeSet = new TreeSet<>(inputList1);
        treeSet.addAll(inputList2);

        return new LinkedList<>(treeSet);
    }

}
