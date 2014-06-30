package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NumberChainsTest {
    NumberChains numberChains;

    @Before
    public void setUp() {
        numberChains = new NumberChains();
    }

    @Test
    public void basic() {
        assertNotNull(numberChains);
    }

    @Test
    public void numberChainAsc() {
        int number = 561374;
        assertEquals(134567, numberChains.formAscOrder(number));
    }

    @Test
    public void numberChainDesc() {
        int number = 561374;
        assertEquals(765431, numberChains.formDescOrder(number));
    }

    @Test
    public void numberChainAnotherOneAsc() {
        int number = 314765;
        assertEquals(134567, numberChains.formAscOrder(number));
    }

    @Test
    public void numberChainAnotherOneAsc3087() {
        int number = 3087;
        assertEquals(378, numberChains.formAscOrder(number));
    }

    @Test
    public void numberChainAnotherOneDesc3087() {
        int number = 3087;
        assertEquals(8730, numberChains.formDescOrder(number));
    }

    @Test
    public void numberChainAnotherOneDes() {
        int number = 314765;
        assertEquals(765431, numberChains.formDescOrder(number));
    }

    @Test
    public void numberChainAnotherReallyBigOneAsc() {
        int number = 629340530;
        assertEquals(2334569, numberChains.formAscOrder(number));
    }

    @Test
    public void numberChainAnotherReallyBigOneDes() {
        int number = 620934530;
        assertEquals(965433200, numberChains.formDescOrder(number));
    }

    @Test
    public void substractAscFromDesc() {
        int number = 123456789;
        int numberChainAsc = numberChains.formAscOrder(number);
        int numberChainDesc = numberChains.formDescOrder(number);

        assertEquals(numberChainDesc - numberChainAsc, numberChains.formASubstraction(number));
    }

    @Test
    public void chainOfSubstraction444() {
        int number = 444;
        String chainOfSubstraction = numberChains.formAChain(number);

        assertEquals("Original number was 444\n" +
                "444 - 444 = 0\n" +
                "0 - 0 = 0\n" +
                "Chain length is 2", chainOfSubstraction);
    }

    @Test
    public void chainOfSubstraction1234() {
        int number = 1234;
        String chainOfSubstraction = numberChains.formAChain(number);

        assertEquals("Original number was 1234\n" +
                "4321 - 1234 = 3087\n" +
                "8730 - 378 = 8352\n" +
                "8532 - 2358 = 6174\n" +
                "7641 - 1467 = 6174\n" +
                "Chain length is 4", chainOfSubstraction);
    }

    @Test
    public void chainOfSubstraction123456789() {
        int number = 123456789;
        String chainOfSubstraction = numberChains.formAChain(number);

        assertEquals("Original number was 123456789\n" +
                "987654321 - 123456789 = 864197532\n" +
                "987654321 - 123456789 = 864197532\n" +
                "Chain length is 2", chainOfSubstraction);
    }
}
