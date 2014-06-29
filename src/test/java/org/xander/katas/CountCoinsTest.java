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
    public void basicBehavior() {
        assertNotNull(countCoins);
    }

    @Test
    public void quarter() {
        String name = countCoins.countOneCoin(25);
        assertThat("quarter", is(name));
    }

    @Test
    public void dime() {
        String name = countCoins.countOneCoin(10);
        assertThat("dime", is(name));
    }

    @Test
    public void nickel() {
        String name = countCoins.countOneCoin(5);
        assertThat("nickel", is(name));
    }

    @Test
    public void penny() {
        String name = countCoins.countOneCoin(1);
        assertThat("penny", is(name));
    }

    @Test
    public void nothing() {
        String name = countCoins.countOneCoin(-1);
        assertThat("nothing", is(name));
    }

    @Test
    public void customQuarter() {
        String name = countCoins.countCustomCoin(25);
        assertThat(true, is(name.contains("25_penny")));
        assertThat(true, is(name.contains("5_nickel")));
        assertThat(true, is(name.contains("1_quarter")));
        assertThat(true, is(name.contains("5_penny and 4_nickel")));
        assertThat(true, is(name.contains("5_penny and 2_dime")));
        assertThat(true, is(name.contains("10_penny and 3_nickel")));
        assertThat(true, is(name.contains("15_penny and 2_nickel")));
        assertThat(true, is(name.contains("15_penny and 1_dime")));
        assertThat(true, is(name.contains("20_penny and 1_nickel")));
        assertThat(true, is(name.contains("1_nickel and 20_penny")));
        assertThat(true, is(name.contains("1_nickel and 2_dime")));
        assertThat(true, is(name.contains("2_nickel and 15_penny")));
        assertThat(true, is(name.contains("3_nickel and 10_penny")));
        assertThat(true, is(name.contains("3_nickel and 1_dime")));
        assertThat(true, is(name.contains("4_nickel and 5_penny")));
        assertThat(true, is(name.contains("1_dime and 15_penny")));
        assertThat(true, is(name.contains("1_dime and 3_nickel")));
        assertThat(true, is(name.contains("2_dime and 5_penny")));
        assertThat(true, is(name.contains("2_dime and 1_nickel")));
    }

    @Test
    public void fifteenCents() {
        String name = countCoins.countCustomCoin(15);
        assertThat(true, is(name.contains("15_penny")));
        assertThat(true, is(name.contains("3_nickel")));
        assertThat(true, is(name.contains("1_dime and 5_penny")));
        assertThat(true, is(name.contains("1_dime and 1_nickel")));
        assertThat(true, is(name.contains("2_nickel and 5_penny")));
        assertThat(true, is(name.contains("1_nickel and 10_penny")));
    }

    @Test
    public void hundredCents() {
        String name = countCoins.countCustomCoin(100);
        assertThat(true, is(name.contains("100_penny")));
        assertThat(true, is(name.contains("20_nickel")));
        assertThat(true, is(name.contains("10_dime")));
        assertThat(true, is(name.contains("4_quarter")));
        assertThat(true, is(name.contains("5_penny and 19_nickel")));
        assertThat(true, is(name.contains("10_penny and 18_nickel")));
        assertThat(true, is(name.contains("10_penny and 9_dime")));
        assertThat(true, is(name.contains("15_penny and 17_nickel")));
        assertThat(true, is(name.contains("20_penny and 16_nickel")));
        assertThat(true, is(name.contains("20_penny and 8_dime")));
        assertThat(true, is(name.contains("25_penny and 15_nickel")));
        assertThat(true, is(name.contains("25_penny and 3_quarter")));
        assertThat(true, is(name.contains("30_penny and 14_nickel")));
        assertThat(true, is(name.contains("30_penny and 7_dime")));
        assertThat(true, is(name.contains("35_penny and 13_nickel")));
        assertThat(true, is(name.contains("40_penny and 12_nickel")));
        assertThat(true, is(name.contains("40_penny and 6_dime")));
        assertThat(true, is(name.contains("45_penny and 11_nickel")));
        assertThat(true, is(name.contains("50_penny and 10_nickel")));
        assertThat(true, is(name.contains("50_penny and 5_dime")));
        assertThat(true, is(name.contains("50_penny and 2_quarter")));
        assertThat(true, is(name.contains("55_penny and 9_nickel")));
        assertThat(true, is(name.contains("60_penny and 8_nickel")));
        assertThat(true, is(name.contains("60_penny and 4_dime")));
        assertThat(true, is(name.contains("65_penny and 7_nickel")));
        assertThat(true, is(name.contains("70_penny and 6_nickel")));
        assertThat(true, is(name.contains("70_penny and 3_dime")));
        assertThat(true, is(name.contains("75_penny and 5_nickel")));
        assertThat(true, is(name.contains("75_penny and 1_quarter")));
        assertThat(true, is(name.contains("80_penny and 4_nickel")));
        assertThat(true, is(name.contains("80_penny and 2_dime")));
        assertThat(true, is(name.contains("85_penny and 3_nickel")));
        assertThat(true, is(name.contains("90_penny and 2_nickel")));
        assertThat(true, is(name.contains("90_penny and 1_dime")));
        assertThat(true, is(name.contains("95_penny and 1_nickel")));
        assertThat(true, is(name.contains("1_nickel and 95_penny")));
        assertThat(true, is(name.contains("2_nickel and 90_penny")));
        assertThat(true, is(name.contains("2_nickel and 9_dime")));
        assertThat(true, is(name.contains("3_nickel and 85_penny")));
        assertThat(true, is(name.contains("4_nickel and 80_penny")));
        assertThat(true, is(name.contains("4_nickel and 8_dime")));
        assertThat(true, is(name.contains("5_nickel and 75_penny")));
        assertThat(true, is(name.contains("5_nickel and 3_quarter")));
        assertThat(true, is(name.contains("6_nickel and 70_penny")));
        assertThat(true, is(name.contains("6_nickel and 7_dime")));
        assertThat(true, is(name.contains("7_nickel and 65_penny")));
        assertThat(true, is(name.contains("8_nickel and 60_penny")));
        assertThat(true, is(name.contains("8_nickel and 6_dime")));
        assertThat(true, is(name.contains("9_nickel and 55_penny")));
        assertThat(true, is(name.contains("10_nickel and 50_penny")));
        assertThat(true, is(name.contains("10_nickel and 5_dime")));
        assertThat(true, is(name.contains("10_nickel and 2_quarter")));
        assertThat(true, is(name.contains("11_nickel and 45_penny")));
        assertThat(true, is(name.contains("12_nickel and 40_penny")));
        assertThat(true, is(name.contains("12_nickel and 4_dime")));
        assertThat(true, is(name.contains("13_nickel and 35_penny")));
        assertThat(true, is(name.contains("14_nickel and 30_penny")));
        assertThat(true, is(name.contains("14_nickel and 3_dime")));
        assertThat(true, is(name.contains("15_nickel and 25_penny")));
        assertThat(true, is(name.contains("15_nickel and 1_quarter")));
        assertThat(true, is(name.contains("16_nickel and 20_penny")));
        assertThat(true, is(name.contains("16_nickel and 2_dime")));
        assertThat(true, is(name.contains("17_nickel and 15_penny")));
        assertThat(true, is(name.contains("18_nickel and 10_penny")));
        assertThat(true, is(name.contains("18_nickel and 1_dime")));
        assertThat(true, is(name.contains("19_nickel and 5_penny")));
        assertThat(true, is(name.contains("1_dime and 90_penny")));
        assertThat(true, is(name.contains("1_dime and 18_nickel")));
        assertThat(true, is(name.contains("2_dime and 80_penny")));
        assertThat(true, is(name.contains("2_dime and 16_nickel")));
        assertThat(true, is(name.contains("3_dime and 70_penny")));
        assertThat(true, is(name.contains("3_dime and 14_nickel")));
        assertThat(true, is(name.contains("4_dime and 60_penny")));
        assertThat(true, is(name.contains("4_dime and 12_nickel")));
        assertThat(true, is(name.contains("5_dime and 50_penny")));
        assertThat(true, is(name.contains("5_dime and 10_nickel")));
        assertThat(true, is(name.contains("5_dime and 2_quarter")));
        assertThat(true, is(name.contains("6_dime and 40_penny")));
        assertThat(true, is(name.contains("6_dime and 8_nickel")));
        assertThat(true, is(name.contains("7_dime and 30_penny")));
        assertThat(true, is(name.contains("7_dime and 6_nickel")));
        assertThat(true, is(name.contains("8_dime and 20_penny")));
        assertThat(true, is(name.contains("8_dime and 4_nickel")));
        assertThat(true, is(name.contains("9_dime and 10_penny")));
        assertThat(true, is(name.contains("9_dime and 2_nickel")));
        assertThat(true, is(name.contains("1_quarter and 75_penny")));
        assertThat(true, is(name.contains("1_quarter and 15_nickel")));
        assertThat(true, is(name.contains("2_quarter and 50_penny")));
        assertThat(true, is(name.contains("2_quarter and 10_nickel")));
        assertThat(true, is(name.contains("2_quarter and 5_dime")));
        assertThat(true, is(name.contains("3_quarter and 25_penny")));
        assertThat(true, is(name.contains("3_quarter and 5_nickel")));
    }

    @Test
    public void twentySixCents() {
        String name = countCoins.countCustomCoin(26);
        assertThat(true, is(name.contains("26_penny")));
        assertThat(true, is(name.contains("1_penny and 5_nickel")));
        assertThat(true, is(name.contains("1_penny and 1_quarter")));
        assertThat(true, is(name.contains("6_penny and 4_nickel")));
        assertThat(true, is(name.contains("6_penny and 2_dime")));
        assertThat(true, is(name.contains("11_penny and 3_nickel")));
        assertThat(true, is(name.contains("16_penny and 2_nickel")));
        assertThat(true, is(name.contains("16_penny and 1_dime")));
        assertThat(true, is(name.contains("21_penny and 1_nickel")));
        assertThat(true, is(name.contains("1_nickel and 21_penny")));
        assertThat(true, is(name.contains("2_nickel and 16_penny")));
        assertThat(true, is(name.contains("3_nickel and 11_penny")));
        assertThat(true, is(name.contains("4_nickel and 6_penny")));
        assertThat(true, is(name.contains("5_nickel and 1_penny")));
        assertThat(true, is(name.contains("1_dime and 16_penny")));
        assertThat(true, is(name.contains("2_dime and 6_penny")));
        assertThat(true, is(name.contains("1_quarter and 1_penny")));
    }
}
