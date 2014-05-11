package org.xander.number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RomanNumeralTest {
    RomanNumeral romanNumeral;

    @Before
    public void setUp() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void testRomanNumeral() {
        assertNotNull(romanNumeral);
    }

    @Test
    public void testNothing() {
        String nothing = romanNumeral.convert();
        assertEquals("nothing was sent to convert", nothing);
    }

    @Test
    public void testOneDigit() {
        String one = "1";
        String oneRoman = romanNumeral.convertOneDigit(one);
        assertEquals("I", oneRoman);

        String two = "2";
        String twoRoman = romanNumeral.convertOneDigit(two);
        assertEquals("II", twoRoman);

        String three = "3";
        String threeRoman = romanNumeral.convertOneDigit(three);
        assertEquals("III", threeRoman);

        String four = "4";
        String fourRoman = romanNumeral.convertOneDigit(four);
        assertEquals("IV", fourRoman);

        String five = "5";
        String fiveRoman = romanNumeral.convertOneDigit(five);
        assertEquals("V", fiveRoman);

        String six = "6";
        String sixRoman = romanNumeral.convertOneDigit(six);
        assertEquals("VI", sixRoman);

        String seven = "7";
        String sevenRoman = romanNumeral.convertOneDigit(seven);
        assertEquals("VII", sevenRoman);

        String eight = "8";
        String eightRoman = romanNumeral.convertOneDigit(eight);
        assertEquals("VIII", eightRoman);

        String nine = "9";
        String nineRoman = romanNumeral.convertOneDigit(nine);
        assertEquals("IX", nineRoman);
    }

    @Test
    public void testTwoDigit() {
        String ten = "10";
        String tenRoman = romanNumeral.convertTwoDigit(ten);
        assertEquals("X", tenRoman);

        String twenty = "20";
        String twentyRoman = romanNumeral.convertTwoDigit(twenty);
        assertEquals("XX", twentyRoman);

        String thirty = "30";
        String thirtyRoman = romanNumeral.convertTwoDigit(thirty);
        assertEquals("XXX", thirtyRoman);

        String forty = "40";
        String fortyRoman = romanNumeral.convertTwoDigit(forty);
        assertEquals("XL", fortyRoman);

        String fifty = "50";
        String fiftyRoman = romanNumeral.convertTwoDigit(fifty);
        assertEquals("L", fiftyRoman);

        String sixty = "60";
        String sixtyRoman = romanNumeral.convertTwoDigit(sixty);
        assertEquals("LX", sixtyRoman);

        String seventy = "70";
        String seventyRoman = romanNumeral.convertTwoDigit(seventy);
        assertEquals("LXX", seventyRoman);

        String eighty = "80";
        String eightyRoman = romanNumeral.convertTwoDigit(eighty);
        assertEquals("LXXX", eightyRoman);

        String ninety = "90";
        String ninetyRoman = romanNumeral.convertTwoDigit(ninety);
        assertEquals("XC", ninetyRoman);
    }

    @Test
    public void testThreeDigit() {
        String hundred = "100";
        String hundredRoman = romanNumeral.convertThreeDigit(hundred);
            assertEquals("C", hundredRoman);

        String twoHundred = "200";
        String twoHundredRoman = romanNumeral.convertThreeDigit(twoHundred);
        assertEquals("CC", twoHundredRoman);

        String threeHundred = "300";
        String threeHundredRoman = romanNumeral.convertThreeDigit(threeHundred);
        assertEquals("CCC", threeHundredRoman);

        String fourHundred = "400";
        String fourHundredRoman = romanNumeral.convertThreeDigit(fourHundred);
        assertEquals("CD", fourHundredRoman);

        String fiveHundred = "500";
        String fiveHundredRoman = romanNumeral.convertThreeDigit(fiveHundred);
        assertEquals("D", fiveHundredRoman);

        String sixHundred = "600";
        String sixHundredRoman = romanNumeral.convertThreeDigit(sixHundred);
        assertEquals("DC", sixHundredRoman);

        String sevenHundred = "700";
        String sevenHundredRoman = romanNumeral.convertThreeDigit(sevenHundred);
        assertEquals("DCC", sevenHundredRoman);

        String eightHundred = "800";
        String eightHundredRoman = romanNumeral.convertThreeDigit(eightHundred);
        assertEquals("DCCC", eightHundredRoman);

        String nineHundred = "900";
        String nineHundredRoman = romanNumeral.convertThreeDigit(nineHundred);
        assertEquals("CM", nineHundredRoman);
    }

    @Test
    public void testFourDigit() {
        String hundred = "1000";
        String hundredRoman = romanNumeral.convertFourDigit(hundred);
        assertEquals("M", hundredRoman);
    }

    @Test
    public void testNegative() {
        String notANumber = "a";
        String numberRoman = romanNumeral.convertFourDigit(notANumber);
        assertEquals("there is no such a number", numberRoman);
    }
}
