package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrimeFactorsTest {
    PrimeFactors primeFactors;

    @Before
    public void setUp() {
        primeFactors = new PrimeFactors();
    }

    @Test
    public void basic() {
        assertNotNull(primeFactors);
    }

    @Test
    public void simpleNumber4() {
        int inputNumber = 4;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void simpleNumber6() {
        int inputNumber = 6;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void simpleNumber8() {
        int inputNumber = 8;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 2};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void simpleNumber12() {
        int inputNumber = 12;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void simpleNumber96() {
        int inputNumber = 96;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 2, 2, 2, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void simpleNumber960() {
        int inputNumber = 960;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 2, 2, 2, 2, 3, 5};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void simpleNumber980() {
        int inputNumber = 980;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 5, 7, 7};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }
}
