package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ISBNTest {
    ISBN isbn;

    @Before
    public void setUp() {
        isbn = new ISBN();
    }

    @Test
    public void testBasic() {
        assertNotNull(isbn);
    }

    @Test
    public void testHyphensAreIgnored() {
        String number = "9780471486480";
        String numberWithHyphens = "978-0-471-48648-0";

        String numberWithoutHyphens = isbn.checkNumber(numberWithHyphens);
        assertEquals(number, numberWithoutHyphens);

    }

    @Test
    public void testCalculateCheckDigitForISBN10() {
        String number = "0 471 60695 2";
        String checkDigit = String.valueOf(242 % 11);

        assertEquals(checkDigit, isbn.calculateCheckDigitIsbn10(number));
    }

    @Test
    public void testCalculateCheckDigitForISBN13() {
        String number = "978-0-13-149505-0";
        int sum = 100;
        String checkDigit = String.valueOf((10 - (sum % 10)) % 10);

        assertEquals(checkDigit, isbn.calculateCheckDigitIsbn13(number));
    }
}
