package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalcStatsTest {
    CalcStats calcStats;

    @Before
    public void setUp() {
        calcStats = new CalcStats();
    }

    @Test
    public void basic() {
        assertNotNull(calcStats);
    }

    @Test
    public void input() {
        int[] arrayOfNumbers = {6, 9, 15, -2, 92, 11};
        CalcStats.Statistics statistics = calcStats.calculateNumbers(arrayOfNumbers);

        assertEquals(-2, statistics.getMinimumValue());
        assertEquals(92, statistics.getMaximumValue());
        assertEquals(6, statistics.getNumberOfElementsInSequence());
        assertEquals(21.833333333333332, statistics.getAverageValue(), 0.00000001);
    }
    @Test
    public void anotherInput() {
        int[] arrayOfNumbers = {126, 54669, -242, -121, 392, 1111, 11, 77, 31415};
        CalcStats.Statistics statistics = calcStats.calculateNumbers(arrayOfNumbers);

        assertEquals(-242, statistics.getMinimumValue());
        assertEquals(54669, statistics.getMaximumValue());
        assertEquals(9, statistics.getNumberOfElementsInSequence());
        assertEquals(9715.333333333334, statistics.getAverageValue(), 0.00000001);
    }
}
