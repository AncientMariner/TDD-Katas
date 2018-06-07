package org.xander.katas;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SumInArrayTest {
    @Test
    public void test() {
        assertTrue("Sum not found", new SumInArray().checkBruteForce(new int[]{1, 3, 5, 0, 8}, 11));
    }

    @Test
    public void testNegative() {
        assertFalse("Sum not found", new SumInArray().checkBruteForce(new int[]{1, 3, 5, 0, 8}, 7));
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        new SumInArray().checkBruteForce(null, 7);
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalSize1() {
        new SumInArray().checkBruteForce(new int[]{1}, 7);
    }

    @Test(expected = IllegalStateException.class)
    public void testIllegalSize0() {
        new SumInArray().checkBruteForce(new int[]{}, 7);
    }

    @Test
    public void testWithSet() {
        assertTrue("Sum not found", new SumInArray().checkBruteForce(new int[]{1, 3, 5, 0, 8}, 11));
    }

    @Test
    public void testMap() {
        assertTrue("Sum not found", new SumInArray().checkWithMap(new int[]{1, 3, 5, 0, 8}, 11));
    }

    @Test
    public void testMapNegative() {
        assertTrue("Sum not found", new SumInArray().checkWithMap(new int[]{1, 3, 5, 0, 8}, 11));
    }
    
    @Test
    public void testSet() {
        assertTrue("Sum not found", new SumInArray().checkWithSet(new int[]{1, 3, 5, 0, 8}, 11));
    }
}
