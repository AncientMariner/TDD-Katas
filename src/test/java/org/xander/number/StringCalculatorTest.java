package org.xander.number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void zeroParametersTest() {
        int sum = stringCalculator.add();

        assertEquals(0, sum);
    }

    @Test
    public void oneParameterTest() {
        String number = "7";
        Integer sum = stringCalculator.add(number);

        assertEquals(Integer.valueOf(number), sum);
    }

    @Test(expected = NumberFormatException.class)
    public void oneParameterNegativeTest() {
        String number = "a";
        stringCalculator.add(number);
    }

    @Test(expected = NumberFormatException.class)
    public void oneParameterMixedNegativeTest() {
        String number = "a2";
        stringCalculator.add(number);
    }

    @Test(expected = NumberFormatException.class)
    public void oneParameterMixed2NegativeTest() {
        String number = "7a2";
        stringCalculator.add(number);
    }

    @Test
    public void zeroStringTest() {
        String number = "";
        Integer sum = stringCalculator.add(number);

        ;
        assertEquals(new Integer(0), sum);
    }

    @Test
    public void emptyStringTest() {
        String number = "    ";
        Integer sum = stringCalculator.add(number);

        ;
        assertEquals(new Integer(0), sum);
    }

    @Test
    public void twoParametersTest() {
        String number1 = "7";
        String number2 = "7";
        Integer sum = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(14), sum);
    }

    @Test
    public void twoParametersNegativeTestWithZero() {
        String number1 = "7";
        String number2 = "0";
        Integer sum1 = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(7), sum1);


        String number3= "0";
        String number4 = "7";
        Integer sum2 = stringCalculator.add(number3, number4);

        assertEquals(Integer.valueOf(7), sum2);
    }

    @Test
    public void twoParametersNegativeTestWithZeroAndEmpty() {
        String number1 = "0";
        String number2 = "0";
        Integer sum1 = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(0), sum1);


        String number3= "0";
        String number4 = "";
        Integer sum2 = stringCalculator.add(number3, number4);

        assertEquals(Integer.valueOf(0), sum2);

        String number5= "";
        String number6 = "0";
        Integer sum3 = stringCalculator.add(number5, number6);

        assertEquals(Integer.valueOf(0), sum3);
    }

    @Test
    public void twoParametersNegativeTestWithZeroAndSpace() {
        String number1 = " ";
        String number2 = "0";
        Integer sum1 = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(0), sum1);

        String number3= "5";
        String number4 = "  ";
        Integer sum2 = stringCalculator.add(number3, number4);

        assertEquals(Integer.valueOf(5), sum2);

        String number5= "  ";
        String number6 = "0";
        Integer sum3 = stringCalculator.add(number5, number6);

        assertEquals(Integer.valueOf(0), sum3);

        String number7 = " ";
        String number8 = "3";
        Integer sum4 = stringCalculator.add(number7, number8);

        assertEquals(Integer.valueOf(3), sum4);
    }

}
