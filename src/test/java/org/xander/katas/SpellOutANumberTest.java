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
    public void Basic() {
        assertNotNull(spellOutANumber);
    }

    @Test
    public void SimpleOneDigitNumber() {
        int nine = 9;

        String result = spellOutANumber.spellOutOneDigitNumber(nine);
        assertEquals("nine", result);
    }

    @Test
    public void TwoDigitNumber() {
        int nineteen = 19;

        String result = spellOutANumber.spellOutTwoDigitNumber(nineteen);
        assertEquals("nineteen", result);
    }

    @Test
    public void AnotherTwoDigitNumber() {
        int nineteen = 21;

        String result = spellOutANumber.spellOutTwoDigitNumberAbove20(nineteen);
        assertEquals("twenty one", result);
    }

    @Test
    public void AnotherTwoDigitNumber77() {
        int nineteen = 77;

        String result = spellOutANumber.spellOutTwoDigitNumberAbove20(nineteen);
        assertEquals("seventy seven", result);
    }

    @Test
    public void ThreeDigitNumber177() {
        int number = 177;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred seventy seven", result);
    }

    @Test
    public void AnotherThreeDigitNumber134() {
        int number = 134;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred thirty four", result);
    }

    @Test
    public void AnotherThreeDigitNumber100() {
        int number = 100;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred", result);
    }

    @Test
    public void AnotherThreeDigitNumber101() {
        int number = 101;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred one", result);
    }

    @Test
    public void AnotherThreeDigitNumber110() {
        int number = 110;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("one hundred ten", result);
    }

    @Test
    public void AnotherThreeDigitNumber999() {
        int number = 999;

        String result = spellOutANumber.spellOutThreeDigitNumber(number);
        assertEquals("nine hundred ninety nine", result);
    }

    @Test
    public void AnotherFourDigitNumber4529() {
        int number = 4529;

        String result = spellOutANumber.spellOutFourDigitNumber(number);
        assertEquals("four thousand five hundred twenty nine", result);
    }

    @Test
    public void AnotherFourDigitNumber1000() {
        int number = 1000;

        String result = spellOutANumber.spellOutFourDigitNumber(number);
        assertEquals("one thousand", result);
    }

    @Test
    public void AnotherFourDigitNumber9999() {
        int number = 9999;

        String result = spellOutANumber.spellOutFourDigitNumber(number);
        assertEquals("nine thousand nine hundred ninety nine", result);
    }

    @Test
    public void FiveDigitNumber19999() {
        int number = 19999;

        String result = spellOutANumber.spellOutFiveDigitNumber(number);
        assertEquals("nineteen thousand nine hundred ninety nine", result);
    }

    @Test
    public void SixDigitNumber719999() {
        int number = 719999;

        String result = spellOutANumber.spellOutSixDigitNumber(number);
        assertEquals("seven hundred nineteen thousand nine hundred ninety nine", result);
    }

    @Test
    public void SevenDigitNumber1719999() {
        int number = 1_719_999;

        String result = spellOutANumber.spellOutSevenDigitNumber(number);
        assertEquals("one million seven hundred nineteen thousand nine hundred ninety nine", result);
    }

    @Test
    public void EightDigitNumber43719999() {
        int number = 43_112_603;

        String result = spellOutANumber.spellOutEightDigitNumber(number);
        assertEquals("forty three million one hundred twelve thousand six hundred three", result);
    }

    @Test
    public void NineDigitNumber143719999() {
        int number = 143_112_603;

        String result = spellOutANumber.spellOutNineDigitNumber(number);
        assertEquals("one hundred forty three million one hundred twelve thousand six hundred three", result);
    }


    @Test
    public void TenDigitNumber143719999() {
        long number = 15_143_112_603L;

        String result = spellOutANumber.spellOutTenDigitNumber(number);
        assertEquals("fifteen billion one hundred forty three million one hundred twelve thousand six hundred three", result);
    }

    @Test
    public void AnyNumberBelow100Billion() {
        long number = 25_143_112_603L;

        String result = spellOutANumber.spellOutANumber(number);
        assertEquals("twenty five billion one hundred forty three million one hundred twelve thousand six hundred three", result);
    }

    @Test
    public void AnotherAnyNumberBelow100Billion() {
        long number = 25_131_263;

        String result = spellOutANumber.spellOutANumber(number);
        assertEquals("twenty five million one hundred thirty one thousand two hundred sixty three", result);
    }


}
