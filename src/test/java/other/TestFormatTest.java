package other;

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
    public void testFormat2Negative() {
        int number = -23;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("(23)", format);
    }

    @Test
    public void testFormat2Positive() {
        int number = 23;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("23", format);
    }

    @Test
    public void testFormat1Negative() {
        int number = -3;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("(3)", format);
    }

    @Test
    public void testFormat1Positive() {
        int number = 3;
        TestFormat testFormat = new TestFormat();
        String format = testFormat.format(number);
        assertEquals("3", format);
    }
}
