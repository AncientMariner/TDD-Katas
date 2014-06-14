package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SpellOutANumberTest {
    SpellOutANumber spellOutANumber;

    @Before
    public void setUp() {
        spellOutANumber = new SpellOutANumber();
    }

    @Test
    public void basic() {
        assertNotNull(spellOutANumber);
    }

    @Test
    public void simpleOneDigitNumber() {
        int nine = 9;

        String result = spellOutANumber.spellOutOneDigitNumber(nine);
        assertEquals("nine", result);
    }

    @Test
    public void twoDigitNumber() {
        int nineteen = 19;

        String result = spellOutANumber.spellOutTwoDigitNumber(nineteen);
        assertEquals("nineteen", result);
    }

    @Test
    public void anotherTwoDigitNumber() {
        int nineteen = 21;

        String result = spellOutANumber.spellOutTwoDigitNumberAbove20(nineteen);
        assertEquals("twenty one", result);
    }

    @Test
    public void anotherTwoDigitNumber77() {
        int nineteen = 77;

        String result = spellOutANumber.spellOutTwoDigitNumberAbove20(nineteen);
        assertEquals("seventy seven", result);
    }

    @Test
    public void threeDigitNumber177() {
        int number = 177;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred seventy seven", result);
    }

    @Test
    public void anotherThreeDigitNumber134() {
        int number = 134;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred thirty four", result);
    }

    @Test
    public void anotherThreeDigitNumber100() {
        int number = 100;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred", result);
    }

    @Test
    public void anotherThreeDigitNumber101() {
        int number = 101;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred one", result);
    }

    @Test
    public void anotherThreeDigitNumber110() {
        int number = 110;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred ten", result);
    }

    @Test
    public void anotherThreeDigitNumber999() {
        int number = 999;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("nine hundred ninety nine", result);
    }

    @Test
    public void anotherFourDigitNumber4529() {
        int number = 4529;

        String result = spellOutANumber.spellOutFourDigitNumber(number);
        assertEquals("four thousand five hundred twenty nine", result);
    }

    @Test
    public void anotherFourDigitNumber1000() {
        int number = 1000;

        String result = spellOutANumber.spellOutFourDigitNumber(number);
        assertEquals("one thousand", result);
    }

    @Test
    public void anotherFourDigitNumber9999() {
        int number = 9999;

        String result = spellOutANumber.spellOutFourDigitNumber(number);
        assertEquals("nine thousand nine hundred ninety nine", result);
    }

    @Test
    public void fiveDigitNumber19999() {
        int number = 19999;

        String result = spellOutANumber.spellOutFiveDigitNumber(number);
        assertEquals("nineteen thousand nine hundred ninety nine", result);
    }

    @Test
    public void sixDigitNumber719999() {
        int number = 719999;

        String result = spellOutANumber.spellOutSixDigitNumber(number);
        assertEquals("seven hundred nineteen thousand nine hundred ninety nine", result);
    }

    @Test
    public void sevenDigitNumber1719999() {
        int number = 1_719_999;

        String result = spellOutANumber.spellOutSevenDigitNumber(number);
        assertEquals("one million seven hundred nineteen thousand nine hundred ninety nine", result);
    }

    @Test
    public void eightDigitNumber43719999() {
        int number = 43_112_603;

        String result = spellOutANumber.spellOutEightDigitNumber(number);
        assertEquals("forty three million one hundred twelve thousand six hundred three", result);
    }

    @Test
    public void nineDigitNumber143719999() {
        int number = 143_112_603;

        String result = spellOutANumber.spellOutNineDigitNumber(number);
        assertEquals("one hundred forty three million one hundred twelve thousand six hundred three", result);
    }

    @Test
    public void tenDigitNumber143719999() {
        long number = 15_143_112_603L;

        String result = spellOutANumber.spellOutTenDigitNumber(number);
        assertEquals("fifteen billion one hundred forty three million one hundred twelve thousand six hundred three", result);
    }

    @Test
    public void anyNumberBelow100Billion() {
        long number = 25_143_112_603L;

        String result = spellOutANumber.spellOutANumber(number);
        assertEquals("twenty five billion one hundred forty three million one hundred twelve thousand six hundred three", result);
    }

    @Test
    public void anotherAnyNumberBelow100Billion() {
        long number = 25_131_263;

        String result = spellOutANumber.spellOutANumber(number);
        assertEquals("twenty five million one hundred thirty one thousand two hundred sixty three", result);
    }
}
