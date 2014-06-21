package org.xander.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeckendorfNumber {
    private int[] fibonacciRow = new int[40];

    public int[] generateFibonacci(final int threshold) {
        final int initialNumber = 1;

        fibonacciRow[0] = initialNumber;
        fibonacciRow[1] = initialNumber;

        for (int i = 2; i < threshold; i++) {
            fibonacciRow[i] = fibonacciRow[i - 2] + fibonacciRow[i - 1];
        }
        return Arrays.copyOf(fibonacciRow, fibonacciRow.length);
    }

    public List<Integer> representNumber(int inputNumber) {
        List<Integer> resultArray = new ArrayList<>();

        for (int i = fibonacciRow.length - 1; i > 0; i--) {
            if (inputNumber >= fibonacciRow[i] && inputNumber % fibonacciRow[i] >= 0) {
                if (inputNumber == fibonacciRow[i]) {
                    resultArray.add(fibonacciRow[i]);
                    break;
                }
                if (resultArray.isEmpty()) {
                    resultArray.add(fibonacciRow[i]);
                } else if(!resultArray.isEmpty() && fibonacciRow[i] + sumOfAlreadyPresentElementsIn(resultArray) <= inputNumber) {
                    resultArray.add(fibonacciRow[i]);
                }
            }
        }
        return resultArray;
    }

    private Integer sumOfAlreadyPresentElementsIn(List<Integer> resultArray) {
        int sumOfAllElements = 0;
        for (int element : resultArray) {
            sumOfAllElements += element;
        }
        return sumOfAllElements;
    }
}
