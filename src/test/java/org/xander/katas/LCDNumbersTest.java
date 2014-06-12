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
    public void Basic() {
        assertNotNull(lcdNumbers);
    }

    @Test
    public void Zero() {
        int zero = 0;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(zero);
        assertEquals("._. ._. ._.\n" +
                     "|.| |.| |.|\n" +
                     "|_| |_| |_|", lcdNumber);
    }

    @Test
    public void One() {
        int zero = 1;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(zero);
        assertEquals("._. ._. ...\n" +
                     "|.| |.| ..|\n" +
                     "|_| |_| ..|", lcdNumber);
    }

    @Test
    public void AnyNumberBelow1000_910() {
        int number = 910;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(number);
        assertEquals("._. ... ._.\n" +
                     "|_| ..| |.|\n" +
                     "..| ..| |_|", lcdNumber);
    }

    @Test
    public void AnyNumberBelow1000_365() {
        int number = 365;
        String lcdNumber = lcdNumbers.generateLCDNumberFrom(number);
        assertEquals("._. ._. ._.\n" +
                     "._| |_. |_.\n" +
                     "._| |_| ._|", lcdNumber);
    }
}
