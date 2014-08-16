package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListMergerTest {
    ListMerger listMerger;

    @Before
    public void setUp() {
        listMerger = new ListMerger();
    }

    @Test
    public void basic() {
        assertNotNull(listMerger);
    }

    @Test
    public void inputListsIsSorted() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        assertTrue(listMerger.checkListIsSorted(list));
    }

    @Test
    public void inputListsIsNotSorted() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(2);
        list.add(1);

        assertFalse(listMerger.checkListIsSorted(list));
    }

    @Test
    public void mergeListsOne() {
        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(3);
        listOne.add(4);
        listOne.add(5);
        assertTrue(listMerger.checkListIsSorted(listOne));


        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(0);
        listTwo.add(2);
        listTwo.add(6);
        listTwo.add(7);
        listTwo.add(8);
        assertTrue(listMerger.checkListIsSorted(listTwo));

        List<Integer> mergedList = listMerger.merge(listOne, listTwo);

        assertTrue(listMerger.checkListIsSorted(mergedList));
    }

    @Test
    public void mergeListsTwo() {
        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(3);
        listOne.add(4);
        listOne.add(5);
        listOne.add(11);
        listOne.add(17);
        listOne.add(18);
        assertTrue(listMerger.checkListIsSorted(listOne));


        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(0);
        listTwo.add(2);
        listTwo.add(6);
        listTwo.add(7);
        listTwo.add(8);
        assertTrue(listMerger.checkListIsSorted(listTwo));

        List<Integer> mergedList = listMerger.merge(listOne, listTwo);

        assertTrue(listMerger.checkListIsSorted(mergedList));
    }
}
