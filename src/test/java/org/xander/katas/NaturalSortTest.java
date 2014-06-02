package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NaturalSortTest {
    NaturalSort naturalSort;

    @Before
    public void setUp() {
        naturalSort = NaturalSort.getInstance();
    }

    @Test
    public void testBasic() {
        assertNotNull(naturalSort);
    }

    @Test
    public void testBasicSort() {
        List<String> unsortedList = new ArrayList<>();
        unsortedList.add("3");
        unsortedList.add("38");
        unsortedList.add("100");
        unsortedList.add("1");
        unsortedList.add("4");
        unsortedList.add("2");
        unsortedList.add("22");
        unsortedList.add("10");
        unsortedList.add("2s");
        unsortedList.add("3");
        unsortedList.add("a3");
        unsortedList.add("13a");

        List<String> sortedList = naturalSort.sortNaturally(unsortedList);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("1");
        expectedList.add("10");
        expectedList.add("100");
        expectedList.add("13a");
        expectedList.add("2");
        expectedList.add("22");
        expectedList.add("2s");
        expectedList.add("3");
        expectedList.add("3");
        expectedList.add("38");
        expectedList.add("4");
        expectedList.add("a3");

        assertEquals(expectedList, sortedList);
    }
}
