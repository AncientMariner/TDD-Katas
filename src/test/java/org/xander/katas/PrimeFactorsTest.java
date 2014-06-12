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
    public void Basic() {
        assertNotNull(primeFactors);
    }

    @Test
    public void SimpleNumber4() {
        int inputNumber = 4;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void SimpleNumber6() {
        int inputNumber = 6;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void SimpleNumber8() {
        int inputNumber = 8;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 2};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void SimpleNumber12() {
        int inputNumber = 12;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void SimpleNumber96() {
        int inputNumber = 96;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 2, 2, 2, 3};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void SimpleNumber960() {
        int inputNumber = 960;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 2, 2, 2, 2, 3, 5};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }

    @Test
    public void SimpleNumber980() {
        int inputNumber = 980;

        int[] result = primeFactors.factorize(inputNumber);
        int[] expectedResult = {2, 2, 5, 7, 7};
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i] , result[i]);
        }
    }
}
