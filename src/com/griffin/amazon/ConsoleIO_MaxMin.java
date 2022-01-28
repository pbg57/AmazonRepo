package com.griffin.amazon;

import java.io.*;
import java.util.ArrayList;

public class ConsoleIO_MaxMin {

    /*
    Write a class to read test data from the standard input stream.
    Collect a variable-sized amount of input, then combine, sort and print values.
     */
    public static void main(String[] args) throws IOException {

        // Use reader to read from System.in
        // Input is:
        // number of tests\n    "2"
        // number of array elements\n   "3"
        // space separated numeric array elements   "5 6 7"
        // repeat last two lines for each test "4" \n "8 9 10"

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        String numTestCases = bufferedReader.readLine();
        int numTests = Integer.parseInt(numTestCases);
        for (int i = 0; i < numTests; i++) {
            String sizeOfArray = bufferedReader.readLine();
            int sizeArray = Integer.parseInt(sizeOfArray);

            String arrayElements = bufferedReader.readLine();
            String[] stringElems = arrayElements.split(" ", sizeArray);

            // Convert to integers and add to List
            ArrayList<Integer> intList = new ArrayList<>();
            for (String s : stringElems) {
                intList.add(Integer.valueOf(s.trim()));   // remove any trailing spaces/whitespace
            }

            // Sort with default comparator
            intList.sort(null);

            // Print first and last (highest and lowest valued) integer elements.
            Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
            out.write(intList.get(intList.size() - 1) + " ");
            out.write(intList.get(0) + "\n");

            out.flush();
        }
    }
}

