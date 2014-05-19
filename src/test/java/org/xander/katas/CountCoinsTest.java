package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CountCoinsTest {
    CountCoins countCoins;

    @Before
    public void setUp() {
        countCoins = new CountCoins();
    }

    @Test
    public void testBasicBehavior() {
        assertNotNull(countCoins);
    }

    @Test
    public void testQuarter() {
        String name = countCoins.countOneCoin(25);
        assertThat("quarter", is(name));
    }

    @Test
    public void testDime() {
        String name = countCoins.countOneCoin(10);
        assertThat("dime", is(name));
    }

    @Test
    public void testNickel() {
        String name = countCoins.countOneCoin(5);
        assertThat("nickel", is(name));
    }

    @Test
    public void testPenny() {
        String name = countCoins.countOneCoin(1);
        assertThat("penny", is(name));
    }




}
