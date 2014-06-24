package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RecentlyUsedListTest {
    RecentlyUsedList recentlyUsedList;

    @Before
    public void setUp() {
        recentlyUsedList = new RecentlyUsedList();
    }

    @Test
    public void basic() {
        assertNotNull(recentlyUsedList);
    }

    @Test
    public void holdOneString() {
        String stringToHold = "test string";
        recentlyUsedList.pushAString(stringToHold);

        assertEquals(stringToHold, recentlyUsedList.getLastString());
        assertEquals(stringToHold, recentlyUsedList.getFirstString());
        assertEquals(recentlyUsedList.getLastString(), recentlyUsedList.getFirstString());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void holdOneStringNegative() {
        assertEquals("test string", recentlyUsedList.getLastString());
    }

    @Test
    public void holdTwoStrings() {
        String stringToHold = "test string";
        String anotherStringToHold = "test another string";
        recentlyUsedList.pushAString(stringToHold);
        recentlyUsedList.pushAString(anotherStringToHold);

        assertEquals(stringToHold, recentlyUsedList.getFirstString());
        assertEquals(anotherStringToHold, recentlyUsedList.getLastString());
    }

    @Test
    public void holdManyStrings() {
        String stringToHold = "test string";
        String anotherStringToHold = "test another string";
        String anotherStringToHold1 = "test one more string";
        String anotherStringToHold2 = "and one more string";
        recentlyUsedList.pushAString(stringToHold);
        recentlyUsedList.pushAString(anotherStringToHold1);
        recentlyUsedList.pushAString(anotherStringToHold2);
        recentlyUsedList.pushAString(anotherStringToHold);

        assertEquals(stringToHold, recentlyUsedList.getFirstString());
        assertEquals(anotherStringToHold, recentlyUsedList.getLastString());
    }

    @Test
    public void initiallyEmpty() {
        assertEquals(0, recentlyUsedList.getSizeOfList());
    }

    @Test
    public void ensureUniqueness() {
        String stringToHold = "test string";
        String anotherStringToHold = "test string";
        String anotherStringToHold1 = anotherStringToHold;
        recentlyUsedList.pushAString(stringToHold);
        recentlyUsedList.pushAString(anotherStringToHold);
        recentlyUsedList.pushAString(anotherStringToHold1);

        assertEquals(1, recentlyUsedList.getSizeOfList());
        assertEquals(stringToHold, recentlyUsedList.getLastString());
        assertEquals(stringToHold, recentlyUsedList.getFirstString());
        assertEquals(recentlyUsedList.getLastString(), recentlyUsedList.getFirstString());
    }

    @Test
    public void getByIndex() {
        String stringToHold = "test string";
        String anotherStringToHold = "test one more string";
        String anotherStringToHold1 = "and one more string";
        String anotherStringToHold2= "another string";
        recentlyUsedList.pushAString(stringToHold);
        recentlyUsedList.pushAString(anotherStringToHold);
        recentlyUsedList.pushAString(anotherStringToHold1);
        recentlyUsedList.pushAString(anotherStringToHold2);

        assertEquals(stringToHold, recentlyUsedList.getElementNumber(0));
        assertEquals(anotherStringToHold, recentlyUsedList.getElementNumber(1));
        assertEquals(anotherStringToHold1, recentlyUsedList.getElementNumber(2));
        assertEquals(anotherStringToHold2, recentlyUsedList.getElementNumber(3));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void emptyIsNotAllowed() {
        recentlyUsedList.pushAString("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void nullIsNotAllowed() {
        recentlyUsedList.pushAString(null);
    }

    @Test
    public void capacityOfList() {
        recentlyUsedList.setCapacity(3);

        String stringToHold = "test string";
        String anotherStringToHold = "test one more string";
        String anotherStringToHold1 = "and one more string";
        String anotherStringToHold2= "another string";
        recentlyUsedList.pushAString(stringToHold);
        recentlyUsedList.pushAString(anotherStringToHold);
        recentlyUsedList.pushAString(anotherStringToHold1);
        recentlyUsedList.pushAString(anotherStringToHold2);

        assertEquals(3, recentlyUsedList.getSizeOfList());
        assertEquals(anotherStringToHold, recentlyUsedList.getElementNumber(0));
        assertEquals(anotherStringToHold1, recentlyUsedList.getElementNumber(1));
        assertEquals(anotherStringToHold2, recentlyUsedList.getElementNumber(2));
    }


}
