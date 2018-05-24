package org.xander.katas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayItemsEquilibriumTest {
    ArrayItemsEquilibrium arrayItemsEquilibrium;

    @Before
    public void setUp() throws Exception {
        arrayItemsEquilibrium = new ArrayItemsEquilibrium();
    }

    @Test
    public void basic() {
        Assert.assertNotNull(new ArrayItemsEquilibrium());
    }

    @Test
    public void calculate0() {
        assertEquals(Collections.emptySet(), arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{}));
    }

    @Test
    public void calculateNull() {
        assertEquals(Collections.emptySet(), arrayItemsEquilibrium.calculateEquilibriumBruteForce(null));
    }

    @Test
    public void calculateBigNumber() {
        assertEquals(Collections.emptySet(), arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[100001]));
    }

    @Test
    public void calculate1() {
        int one = 1;
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{one});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(one));
    }

    @Test
    public void calculate2() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 1});
        values.containsAll(new HashSet<Integer>(){{add(1);add(1);}});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(1));
    }

    @Test
    public void calculate2Negative() {
        assertEquals(Collections.emptySet(), arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 2}));
    }

    @Test
    public void calculate() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 2, 1});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(1));
    }

    @Test
    public void calculate4() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 2, -1, 3});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(2));
    }
    @Test
    public void calculate44() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 2, -2, 3});
        assertTrue(values.size() == 2);
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
    }

    @Test
    public void calculate5() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 2, -2, 0, 3});
        assertTrue(values.size() == 2);
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
    }

    @Test
    public void calculate55() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{3, 2, -6, 0, 5});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(2));
    }

    @Test
    public void calculateObviousCase() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 0, 1});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(1));
    }

    @Test
    public void calculateLeftCornerCase() {
        assertTrue(arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 2, -1}).size() == 0);
    }

    @Test
    public void calculateEightElements() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{-1, 3, -4, 5, 1, -6, 2, 1});
        assertTrue(values.size() == 3);
        assertTrue(values.contains(1));
        assertTrue(values.contains(3));
        assertTrue(values.contains(7));
    }

    @Test
    public void calculateLeftCornerC1ase() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{1, 2, -2});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(0));
    }

    @Test
    public void calculateRightCornerCase() {
        Set<Integer> values = arrayItemsEquilibrium.calculateEquilibriumBruteForce(new int[]{2, -2, 1});
        assertTrue(values.size() == 1);
        assertTrue(values.contains(2));
    }
}
