package org.xander.katas;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SplitStringTest {
    @Test
    public void splitStringTest() {
        String input = "21&tes2t21&212test23121212&rest34&12re&er2";

        char[] delimiter = {'1', '2', '&'};
        String[] expectedArrayOfStrings = {"tes", "", "t", "", "test", "", "3", "", "rest34", "", "re", "", "er"};

        SpiltString spiltString = new SpiltString();
        String[] split = spiltString.splitString(input, delimiter);

        for (int i = 0; i < expectedArrayOfStrings.length; i++)
            assertEquals(expectedArrayOfStrings[i], split[i]);

    }

    @Test
    public void splitStringTestWithEmpty() {
        String input = "215test2t112te";

        char[] delimiter = {'1', '2', '5'};
        String[] expectedArrayOfStrings = {"test", "", "t", "", "te"};

        SpiltString spiltString = new SpiltString();
        String[] split = spiltString.splitString(input, delimiter);

        assertEquals(expectedArrayOfStrings[0], split[0]);
        assertEquals(expectedArrayOfStrings[1], split[1]);
        assertEquals(expectedArrayOfStrings[2], split[2]);
        assertEquals(expectedArrayOfStrings[3], split[3]);
        assertEquals(expectedArrayOfStrings[4], split[4]);
    }

    @Test
    public void splitStringAnotherTest() {
        String input = "21&tes2t21&251y5yu";

        char[] delimiter = {'1', '2', '&', '5'};
        String[] expectedArrayOfStrings = {"tes", "", "t", "", "y", "", "yu"};

        SpiltString spiltString = new SpiltString();
        String[] split = spiltString.splitString(input, delimiter);

        for (int i = 0; i < expectedArrayOfStrings.length; i++)
            assertEquals(expectedArrayOfStrings[i], split[i]);

    }

    @Test
    public void splitStringEmptyTest() {
        String input = "";
        char[] delimiter = {'1'};
        String[] expectedArrayOfStrings = new String[]{};

        SpiltString spiltString = new SpiltString();
        String[] split = spiltString.splitString(input, delimiter);

        assertArrayEquals(expectedArrayOfStrings, split);
    }


    @Test
    public void splitStringNullTest() {
        String input = null;
        char[] delimiter = {'1'};
        String[] expectedArrayOfStrings = new String[]{};

        SpiltString spiltString = new SpiltString();
        String[] split = spiltString.splitString(input, delimiter);

        assertArrayEquals(expectedArrayOfStrings, split);
    }

    @Test
    public void splitStringRealSplitTest() {
        String input = "21&tes2t21&251y5yu";

        char[] delimiter = {'1'};
        String[] expectedArrayOfStrings = {"2", "", "&tes2t2", "", "&25", "", "y5yu"};

        SpiltString spiltString = new SpiltString();

        String[] split = spiltString.splitString(input, delimiter);

        for (int i = 0; i < expectedArrayOfStrings.length; i++)
            assertEquals(expectedArrayOfStrings[i], split[i]);

        //compareTimeOfExecution(input, delimiter, spiltString);
        //compareTimeOfExecution(input, delimiter, spiltString);
        //compareTimeOfExecution(input, delimiter, spiltString);

    }

    private void compareTimeOfExecution(String input, char[] delimiter, SpiltString spiltString) {
        String[] split;
        long averageResultOfSplit = 0;
        long averageResultOfMySplit = 0;
        long startDateTime = 0;
        long endDateTime = 0;

        for (int i = 0; i < 10000000; i++) {
            startDateTime = System.nanoTime();
            input.split("1", 6);
            endDateTime = System.nanoTime();
            averageResultOfSplit += (endDateTime - startDateTime);

            startDateTime = System.nanoTime();
            spiltString.splitString(input, delimiter);
            endDateTime = System.nanoTime();
            averageResultOfMySplit += (endDateTime - startDateTime);
        }

        System.out.println("Average result of standart split in nanoseconds: " + averageResultOfSplit / 10000000);
        System.out.println("Average result of my split in nanoseconds: " + averageResultOfMySplit / 10000000);
    }
}
