package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LCDNumbersTest {
    LCDNumbers lcdNumbers;

    @Before
    public void setUp() {
        lcdNumbers = new LCDNumbers();
    }

    @Test
    public void basic() {
        assertNotNull(lcdNumbers);
    }

    @Test
    public void zero() {
        int zero = 0;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(zero);
        assertEquals("._. ._. ._.\n" +
                     "|.| |.| |.|\n" +
                     "|_| |_| |_|", lcdNumber);
    }

    @Test
    public void one() {
        int zero = 1;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(zero);
        assertEquals("._. ._. ...\n" +
                     "|.| |.| ..|\n" +
                     "|_| |_| ..|", lcdNumber);
    }

    @Test
    public void anyNumberBelow1000_910() {
        int number = 910;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(number);
        assertEquals("._. ... ._.\n" +
                     "|_| ..| |.|\n" +
                     "..| ..| |_|", lcdNumber);
    }

    @Test
    public void anyNumberBelow1000_365() {
        int number = 365;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(number);
        assertEquals("._. ._. ._.\n" +
                     "._| |_. |_.\n" +
                     "._| |_| ._|", lcdNumber);
    }


    @Test
    public void anyNumberBelow1000_247() {
        int number = 247;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(number);
        assertEquals("._. ... ._.\n" +
                     "._| |_| ..|\n" +
                     "|_. ..| ./.", lcdNumber);
    }

    @Test
    public void anyNumberBelow1000_478() {
        int number = 478;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(number);
        assertEquals("... ._. ._.\n" +
                     "|_| ..| |_|\n" +
                     "..| ./. |_|", lcdNumber);
    }

    @Test
    public void notPresentNumber() {
        int number = -304;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(number);
        assertEquals("number is not present", lcdNumber);
    }
}
