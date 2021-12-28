package com.griffin.amazon;

import java.io.*;
import java.util.ArrayList;

public class ConsoleIO_MaxMin {


    public static void main(String[] args) throws IOException {

        // Use reader to read from
        // Input is:
        // number of tests\n
        // number of array elements\n
        // space separated numeric array elements
        // repeat last two lines for each test

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        String numTestCases = bufferedReader.readLine();
        Integer numTests = Integer.valueOf(numTestCases);
        for (int i = 0; i < numTests; i++) {
            String sizeOfArray = bufferedReader.readLine();
            Integer sizeArray = Integer.valueOf(sizeOfArray);

            String arrayElements = bufferedReader.readLine();
            String[] stringElems = arrayElements.split(" ",sizeArray);

            // Convert to integers and add to List
            ArrayList<Integer> intList = new ArrayList<>();
            for (String s : stringElems) {
                intList.add(Integer.valueOf(s.trim()));   // remove any trailing spaces/whitespace
            }

            // Sort with default comparator
            intList.sort(null);

            Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
            out.write(intList.get(intList.size() - 1) + " ");
            out.write(intList.get(0) + "\n");

            out.flush();
        }
    }
}

