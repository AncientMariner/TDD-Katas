package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CombineListOfTwoListsTest {
    CombineListOfTwoLists listCombination;

    @Before
    public void setUp() {
        listCombination = new CombineListOfTwoLists();
    }

    @Test
    public void basic() {
        assertNotNull(listCombination);
    }

    @Test
    public void inputListsIsSorted() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        assertTrue(listCombination.checkListIsSorted(list));
    }

    @Test
    public void inputListsIsNotSorted() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(2);
        list.add(1);

        assertFalse(listCombination.checkListIsSorted(list));
    }

    @Test
    public void mergeLists() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        assertTrue(listCombination.checkListIsSorted(list1));


        List<Integer> list2 = new ArrayList<>();
        list2.add(8);
        list2.add(7);
        list2.add(6);
        list2.add(2);
        list2.add(0);
        Collections.sort(list2);
        assertTrue(listCombination.checkListIsSorted(list2));

        List<Integer> mergedList = listCombination.merge(list1, list2);

        assertTrue(listCombination.checkListIsSorted(mergedList));

    }


}
