package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ZeckendorfNumberTest {
    ZeckendorfNumber zeckendorfNumber;
    final int threshold = 40;

    @Before
    public void setUp() {
        zeckendorfNumber = new ZeckendorfNumber();
    }

    @Test
    public void basic() {
        assertNotNull(zeckendorfNumber);
    }

    @Test
    public void fibonacciMax20() {
        int[] fibonacciArray = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
                    89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
                    10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
                    1346269, 2178309, 3524578, 5702887, 9227465,
                    14930352, 24157817, 39088169, 63245986, 102334155};

        int[] resultFibonacciRow = zeckendorfNumber.generateFibonacci(threshold);

        assertEquals(threshold, resultFibonacciRow.length);

        for (int i = 0; i < fibonacciArray.length; i++) {
            assertEquals(fibonacciArray[i], resultFibonacciRow[i]);
        }
    }

    @Test
    public void representDistinctNumber3() {
        int inputNumber = 3;

        zeckendorfNumber.generateFibonacci(threshold);
        List<Integer> resultArrayOfNumbers = zeckendorfNumber.representNumber(inputNumber);
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(3);

        Collection expected = new ArrayList(expectedArray);
        Collection actual = new ArrayList(resultArrayOfNumbers);

        assertFalse(expected.retainAll(actual));

    }

    @Test
    public void representDistinctNumber11() {
        int inputNumber = 11;

        zeckendorfNumber.generateFibonacci(threshold);
        List<Integer> resultArrayOfNumbers = zeckendorfNumber.representNumber(inputNumber);
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(8);
        expectedArray.add(3);

        Collection expected = new ArrayList(expectedArray);
        Collection actual = new ArrayList(resultArrayOfNumbers);

        assertFalse(expected.retainAll(actual));
    }

    @Test
    public void representDistinctNumber13() {
        int inputNumber = 13;

        zeckendorfNumber.generateFibonacci(threshold);
        List<Integer> resultArrayOfNumbers = zeckendorfNumber.representNumber(inputNumber);
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(13);

        Collection expected = new ArrayList(expectedArray);
        Collection actual = new ArrayList(resultArrayOfNumbers);

        assertFalse(expected.retainAll(actual));
    }

    @Test
    public void representDistinctNumber25() {
        int inputNumber = 25;

        zeckendorfNumber.generateFibonacci(threshold);
        List<Integer> resultArrayOfNumbers = zeckendorfNumber.representNumber(inputNumber);
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(21);
        expectedArray.add(3);
        expectedArray.add(1);

        Collection expected = new ArrayList(expectedArray);
        Collection actual = new ArrayList(resultArrayOfNumbers);

        assertFalse(expected.retainAll(actual));
    }

    @Test
    public void representDistinctNumber4563() {
        int inputNumber = 4563;

        zeckendorfNumber.generateFibonacci(threshold);
        List<Integer> resultArrayOfNumbers = zeckendorfNumber.representNumber(inputNumber);
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(4181);
        expectedArray.add(377);
        expectedArray.add(5);

        Collection expected = new ArrayList(expectedArray);
        Collection actual = new ArrayList(resultArrayOfNumbers);

        assertFalse(expected.retainAll(actual));
    }

    @Test
    public void representDistinctNumber45633() {
        int inputNumber = 45633;

        zeckendorfNumber.generateFibonacci(threshold);
        List<Integer> resultArrayOfNumbers = zeckendorfNumber.representNumber(inputNumber);
        List<Integer> expectedArray = new ArrayList<>();
        expectedArray.add(28657);
        expectedArray.add(10946);
        expectedArray.add(1597);
        expectedArray.add(233);
        expectedArray.add(13);
        expectedArray.add(5);
        expectedArray.add(1);

        Collection expected = new ArrayList(expectedArray);
        Collection actual = new ArrayList(resultArrayOfNumbers);

        assertFalse(expected.retainAll(actual));
    }
}
