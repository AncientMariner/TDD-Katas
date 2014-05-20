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
        assertThat(true, is(name.contains("25_penny")));
        assertThat(true, is(name.contains("5_nickel")));
        assertThat(true, is(name.contains("1_quarter")));
    }

    @Test
    public void test15Cents() {
        String name = countCoins.countCustomCoin(15);
        assertThat(true, is(name.contains("15_penny")));
        assertThat(true, is(name.contains("3_nickel")));
        assertThat(true, is(name.contains("1_dime and 5_penny")));
        assertThat(true, is(name.contains("1_dime and 1_nickel")));
        assertThat(true, is(name.contains("2_nickel and 5_penny")));
        assertThat(true, is(name.contains("1_nickel and 10_penny")));
    }

    @Test
    public void test26Cents() {
        String name = countCoins.countCustomCoin(100);
        assertThat(true, is(name.contains("4_quarter")));
        assertThat(true, is(name.contains("9_dime and 2_nickel")));
        assertThat(true, is(name.contains("8_dime and 4_nickel")));
    }
}
