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

    @Test
    public void testCustomQuarter() {
        String name = countCoins.countCustomCoin(25);
        assertThat(true, is(name.contains("25 penny")));
        assertThat(true, is(name.contains("5 nickel")));
        assertThat(true, is(name.contains("1 quarter")));
    }

    @Test
    public void test15Cents() {
        String name = countCoins.countCustomCoin(15);
        assertThat(true, is(name.contains("15 penny")));
        assertThat(true, is(name.contains("3 nickel")));
        assertThat(true, is(name.contains("2 nickel and 5 penny")));
        assertThat(true, is(name.contains("1 dime and 5 penny")));
        assertThat(true, is(name.contains("1 dime and 1 nickel")));
        assertThat(true, is(name.contains("1 nickel and 10 penny")));
    }
}
