package org.xander.katas;

import org.junit.Before;
import org.junit.Ignore;
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

        String numberChain = numberChains.formAscendingOrder(number);
        assertEquals("134567", numberChain);
    }
    @Test
    public void numberChainDesc() {
        int number = 561374;

        String numberChain = numberChains.formDescendingOrder(number);
        assertEquals("765431", numberChain);
    }

    @Test
    public void numberChainAnotherOneAsc() {
        int number = 314765;

        String numberChain = numberChains.formAscendingOrder(number);
        assertEquals("134567", numberChain);
    }

    @Test
    public void numberChainAnotherOneAsc3087() {
        int number = 3087;

        String numberChain = numberChains.formAscendingOrder(number);
        assertEquals("378", numberChain);
    }

    @Test
    public void numberChainAnotherOneDes() {
        int number = 314765;

        String numberChain = numberChains.formDescendingOrder(number);
        assertEquals("765431", numberChain);
    }

    @Test
    public void numberChainAnotherReallyBigOneAsc() {
        int number = 629340530;

        String numberChain = numberChains.formAscendingOrder(number);
        assertEquals("2334569", numberChain);
    }

    @Test
    public void numberChainAnotherReallyBigOneDes() {
        int number = 620934530;

        String numberChain = numberChains.formDescendingOrder(number);
        assertEquals("9654332", numberChain);
    }

    @Test
    public void substractAscFromDesc() {
        int number = 123456789;

        String numberChainAsc = numberChains.formAscendingOrder(number);
        String numberChainDesc = numberChains.formDescendingOrder(number);

        int substraction = numberChains.formSubstraction(number);

        assertEquals(Integer.parseInt(numberChainAsc) - Integer.parseInt(numberChainDesc), substraction);
    }

    @Ignore
    @Test
    public void chainOfSubstraction() {
        int number = 1234;

        String numberChainAsc = numberChains.formAscendingOrder(number);
        String numberChainDesc = numberChains.formDescendingOrder(number);

        String chainOfSubstraction = numberChains.formAChain(number);
    }


}
