package com.griffin.amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MergeSortList {

    static public void main(String[] args) {
        MergeSortList mergeSortList = new MergeSortList();

        int[] intArray1 = new int[]{2, 4, 6, 8, 9};
        int[] intArray2 = new int[]{1, 3, 5, 7};

        List<Integer> inputList1 = Arrays.stream(intArray1).boxed().collect(Collectors.toList());
        LinkedList<Integer> llList1 = new LinkedList<>(inputList1);

        List<Integer> inputList2 = Arrays.stream(intArray2).boxed().collect(Collectors.toList());
        LinkedList<Integer> llList2 = new LinkedList<>(inputList2);

        LinkedList<Integer> result = mergeSortList.runTest(llList1, llList2);
        System.out.println("com.griffin.amazon.MergeSortList result: " + result.toString());

        LinkedList<Integer> result2 = mergeSortList.runTest2(llList1, llList2);
        System.out.println("com.griffin.amazon.MergeSortList result: " + result2.toString());
    }

    public LinkedList<Integer> runTest(LinkedList<Integer> inputList1, LinkedList<Integer> inputList2) {
        // Given two sorted linked lists, merge them so that the resulting linked list is also sorted.

        LinkedList<Integer> resultList = new LinkedList<>();

        //Start with the list with the smaller first element:

        LinkedList<Integer> startingList = null;
        LinkedList<Integer> secondList = null;

        // Keep a list index for each list as we toggle across each during merge
        int startingListIndex = 0;
        int secondListIndex = 0;

        if (inputList1.getFirst() < inputList2.getFirst()) {
            startingList = inputList1;
            secondList = inputList2;
            startingListIndex++;
            resultList.addFirst(startingList.getFirst());
        } else {
            startingList = inputList2;
            secondList = inputList1;
            resultList.addFirst(startingList.getFirst());
            startingListIndex++;
        }


        boolean moreStartingList = true;
        boolean moreSecondList = true;

        while (moreSecondList || moreStartingList) {
            int nextNode = -1;
            if (moreStartingList && (startingListIndex < startingList.size())) {
                nextNode = startingList.get(startingListIndex);
                startingListIndex++;
            } else
                moreStartingList = false;

            if (moreSecondList && (secondListIndex < secondList.size())) {
                if ((nextNode == -1) || (secondList.get(secondListIndex) < nextNode)) {
                    nextNode = secondList.get(secondListIndex);
                    if (moreStartingList)
                        startingListIndex--;
                    secondListIndex++;
                }
            } else
                moreSecondList = false;

            if (nextNode != -1) {
                resultList.addLast(nextNode);
            }
        }
        return resultList;
    }

    public LinkedList<Integer> runTest2(LinkedList<Integer> inputList1, LinkedList<Integer> inputList2) {
        // Given two sorted linked lists, merge them so that the resulting linked list is also sorted.

        LinkedList<Integer> resultList = new LinkedList<>();

        // Use an ordered collection TreeSet to sort a copy of the LinkedList input

        TreeSet<Integer> treeSet = new TreeSet<>(inputList1);
        treeSet.addAll(inputList2);

        resultList.addAll(treeSet);

        return resultList;
    }

}
