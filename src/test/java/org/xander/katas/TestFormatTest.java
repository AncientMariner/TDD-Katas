package org.xander.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFormatTest {
    @Test
    public void testFormat() throws Exception {
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(-12343);
        assertEquals("(12 343)", format);
    }

    @Test
    public void testFormat1() {
        int number = -1334424233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("(1 334 424 233)", format);
    }  
    
    @Test
    public void testFormat11() {
        int number = -334424233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("(334 424 233)", format);
    }
    
    @Test
    public void testFormat2() {
        int number = 334424233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("334 424 233", format);
    }  
    
    @Test
    public void testFormat3() {
        int number = 34424233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("34 424 233", format);
    }
   
    @Test
    public void testFormat4() {
        int number = 4233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("4 233", format);
    }   
    
    @Test
    public void testFormat4Negative() {
        int number = -4233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("(4 233)", format);
    } 
    
    @Test
    public void testFormat5() {
        int number = 233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("233", format);
    }
    
    @Test
    public void testFormat5Negative() {
        int number = -233;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("(233)", format);
    }

    @Test
    public void testFormat1000() {
        int number = 1000;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("1 000", format);
    }

    @Test
    public void testFormatNegativea() {
        int number = -00;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("0", format);
    }

    @Test
    public void testFormatNegativeMin() {
        int number = Integer.MIN_VALUE + 1;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("(2 147 483 647)", format);
    }

    @Test
    public void testFormatNegativeMax() {
        int number = Integer.MAX_VALUE;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("2 147 483 647", format);
    }
}