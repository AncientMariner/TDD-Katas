package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DiversionTest {
    Diversion diversion;

    @Before
    public void setUp() {
        diversion = new Diversion();
    }

    @Test
    public void testBasic() {
        assertNotNull(diversion);
    }

    @Test
    public void testCalculateAdjacentNumbers1() {
        int size = 1;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(2, result);
    }

    @Test
    public void testCalculateAdjacentNumbers2() {
        int size = 2;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(3, result);
    }

    @Test
    public void testCalculateAdjacentNumbers3() {
        int size = 3;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(5, result);
    }

    @Test
    public void testCalculateAdjacentNumbers4() {
        int size = 4;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(8, result);
    }

    @Test
    public void testCalculateAdjacentNumbers5() {
        int size = 5;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(13, result);
    }

    @Test
    public void testCalculateAdjacentNumbers6() {
        int size = 6;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(21, result);
    }

    @Test
    public void testCalculateAdjacentNumbers7() {
        int size = 7;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(34, result);
    }

    @Test
    public void testCalculateAdjacentNumbers8() {
        int size = 8;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(55, result);
    }

    @Test
    public void testCalculateAdjacentNumbers9() {
        int size = 9;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(89, result);
    }

    @Test
    public void testCalculateAdjacentNumbers10() {
        int size = 10;
        int result = diversion.calculateAdjacentNumbers(size);

        assertEquals(144, result);
    }
}
