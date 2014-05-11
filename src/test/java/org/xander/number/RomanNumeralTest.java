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
        for (int i = 65; i < 91; i++) {
            String asciiToVerify = String.valueOf((char) i);
            String numberRoman = romanNumeral.convertFourDigit(asciiToVerify);
            assertEquals("there is no such a number", numberRoman);
        }

        for (int i = 97; i < 123; i++) {
            String asciiToVerify = String.valueOf((char) i);
            String numberRoman = romanNumeral.convertFourDigit(asciiToVerify);
            assertEquals("there is no such a number", numberRoman);
        }
    }

    @Test
    public void zeroTest() {
        String zero = "0";
        String zeroRoman = romanNumeral.convertOneDigit(zero);
        assertEquals("there is no such a number", zeroRoman);
    }

    @Test
    public void testNull() {
        String nullRoman = romanNumeral.convertFourDigit(null);
        assertEquals("there is no such a number", nullRoman);
    }

    @Test
    public void testWrongSizeOfDigits() {
        String oneSizeDigit = "1";
        String twoSizeDigit = "19";
        String threeSizeDigit = "432";
        String fourSizeDigit = "5121";

        String wrongNumberRoman11 = romanNumeral.convertTwoDigit(oneSizeDigit);
        String wrongNumberRoman111 = romanNumeral.convertThreeDigit(oneSizeDigit);
        String wrongNumberRoman1111 = romanNumeral.convertFourDigit(oneSizeDigit);
        assertEquals("there is no such a number", wrongNumberRoman11);
        assertEquals("there is no such a number", wrongNumberRoman111);
        assertEquals("there is no such a number", wrongNumberRoman1111);

        String wrongNumberRoman2 = romanNumeral.convertOneDigit(twoSizeDigit);
        String wrongNumberRoman222 = romanNumeral.convertThreeDigit(twoSizeDigit);
        String wrongNumberRoman2222 = romanNumeral.convertFourDigit(twoSizeDigit);
        assertEquals("there is no such a number", wrongNumberRoman2);
        assertEquals("there is no such a number", wrongNumberRoman222);
        assertEquals("there is no such a number", wrongNumberRoman2222);

        String wrongNumberRoman3 = romanNumeral.convertOneDigit(threeSizeDigit);
        String wrongNumberRoman33 = romanNumeral.convertTwoDigit(threeSizeDigit);
        String wrongNumberRoman3333 = romanNumeral.convertThreeDigit(threeSizeDigit);
        assertEquals("there is no such a number", wrongNumberRoman3);
        assertEquals("there is no such a number", wrongNumberRoman33);
        assertEquals("there is no such a number", wrongNumberRoman3333);

        String wrongNumberRoman4 = romanNumeral.convertThreeDigit(fourSizeDigit);
        String wrongNumberRoman44 = romanNumeral.convertThreeDigit(fourSizeDigit);
        String wrongNumberRoman444 = romanNumeral.convertThreeDigit(fourSizeDigit);
        assertEquals("there is no such a number", wrongNumberRoman4);
        assertEquals("there is no such a number", wrongNumberRoman44);
        assertEquals("there is no such a number", wrongNumberRoman444);
    }

    @Test
    public void testConvertCustomFourDigitNumber() {
        String customDigit = "3888";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MMMDCCCLXXXVIII", customNumberRoman);
    }

    @Test
    public void testConvertCustomThreeDigitNumber() {
        String customDigit = "388";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("CCCLXXXVIII", customNumberRoman);
    }

    @Test
    public void testConvertCustomTwoDigitNumber() {
        String customDigit = "38";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("XXXVIII", customNumberRoman);
    }

    @Test
    public void testConvertCustomOneDigitNumber() {
        String customDigit = "8";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("VIII", customNumberRoman);
    }

    @Test
    public void testConvertCustomBigDigitNumber() {
        String customDigit = "123123123218";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("there is no such a number", customNumberRoman);
    }
}
