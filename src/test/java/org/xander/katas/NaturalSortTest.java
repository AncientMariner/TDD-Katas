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
        naturalSort = new NaturalSort();
    }

    @Test
    public void testBasic() {
        assertNotNull(naturalSort);
    }

    @Test
    public void testBasicSort() {
        List<String> unsortedList = new ArrayList<>();
        unsortedList.add("1");
        unsortedList.add("2");
        unsortedList.add("10");
//        unsortedList.add("2s");
//        unsortedList.add("3");

        List<String> sortedList = naturalSort.sortForNumbers(unsortedList);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("10");

        assertEquals(expectedList, sortedList);
    }
}
