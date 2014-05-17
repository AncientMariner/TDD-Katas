package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringCalculatorTest {

    StringCalculator stringCalculator;
    final int zero = 0;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void zeroParametersTest() {
        int sum = stringCalculator.add();

        assertEquals(zero, sum);
    }

    @Test
    public void oneParameterTest() {
        String number = "7";
        Integer sum = stringCalculator.add(number);

        assertEquals(Integer.valueOf(number), sum);
    }

    @Test
    public void oneParameterNegativeTest() {
        String number = "a";
        Integer sum = stringCalculator.add(number);

        assertEquals(Integer.valueOf(0), sum);
    }

    @Test
    public void oneParameterMixedNegativeTest() {
        String number = "a2";
        Integer sum = stringCalculator.add(number);

        assertEquals(Integer.valueOf(2), sum);
    }

    @Test
    public void oneParameterMixed2NegativeTest() {
        String number = "7a2a";
        Integer sum = stringCalculator.add(number);
        assertEquals(Integer.valueOf(9), sum);
    }

    @Test
    public void zeroStringTest() {
        String number = "";
        Integer sum = stringCalculator.add(number);

        assertEquals(new Integer(zero), sum);
    }

    @Test
    public void emptyStringTest() {
        String number = "    ";
        Integer sum = stringCalculator.add(number);

        assertEquals(new Integer(zero), sum);
    }

    @Test
    public void twoParametersTest() {
        String number1 = "7";
        String number2 = " 7";
        Integer sum = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(14), sum);
    }

    @Test
    public void twoParametersTestWithDelimiters() {
        String number1 = "6,\n\t\\#&^%(*)(&(*1";
        String number2 = "7,4";
        Integer sum = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(18), sum);
    }

    @Test
    public void oneParameterTestWithDelimiter() {
        String number1 = "7,7";
        Integer sum = stringCalculator.add(number1);

        assertEquals(Integer.valueOf(14), sum);
    }

    @Test
    public void oneParameterTestWithMoreDelimiters() {
        String number1 = "7,,f7gh7";
        Integer sum = stringCalculator.add(number1);

        assertEquals(Integer.valueOf(21), sum);
    }

    @Test
    public void oneParameterNegativeNumberTest() {
        String number1 = "-7";
        try {
            stringCalculator.add(number1);
        } catch (NumberFormatException ex) {
            assertEquals("Negative number is not allowed \'-7\'", ex.getMessage());
        }
    }

    @Test
    public void twoParameterNegativeNumberTest() {
        String number1 = "-7";
        String number2 = "-8";
        try {
            stringCalculator.add(number1, number2);
        } catch (NumberFormatException ex) {
            assertEquals("Negative number is not allowed \'" + number1 + "\' \'" + number2 + "\'", ex.getMessage());
        }
    }

    @Test
    public void twoParameterPositiveNegativeNumberTest() {
        String number1 = "-7";
        String number2 = "8";
        boolean exceptionHappened1 = false;
        try {
            stringCalculator.add(number1, number2);
        } catch (NumberFormatException ex) {
            exceptionHappened1 = true;
            assertEquals("Negative number is not allowed \'" + number1 + "\'", ex.getMessage());
        }
        assertTrue(exceptionHappened1);


        String number3 = "1";
        String number4 = "-8";
        boolean exceptionHappened2 = false;
        try {
            stringCalculator.add(number3, number4);
        } catch (NumberFormatException ex) {
            exceptionHappened2 = true;
            assertEquals("Negative number is not allowed \'" + number4 + "\'", ex.getMessage());
        }
        assertTrue(exceptionHappened2);
    }

    @Test
    public void twoParameterNegativeEmptyNumberTest() {
        String number1 = "-7";
        String number2 = " ";
        boolean exceptionHappened1 = false;
        try {
            stringCalculator.add(number1, number2);
        } catch (NumberFormatException ex) {
            exceptionHappened1 = true;
            assertEquals("Negative number is not allowed \'" + number1 + "\'", ex.getMessage());
        }
        assertTrue(exceptionHappened1);
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

        assertEquals(Integer.valueOf(zero), sum1);


        String number3= "0";
        String number4 = "";
        Integer sum2 = stringCalculator.add(number3, number4);

        assertEquals(Integer.valueOf(zero), sum2);

        String number5= "";
        String number6 = "0";
        Integer sum3 = stringCalculator.add(number5, number6);

        assertEquals(Integer.valueOf(zero), sum3);
    }

    @Test
    public void twoParametersNegativeTestWithZeroAndSpace() {
        String number1 = " ";
        String number2 = " 0";
        Integer sum1 = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(zero), sum1);

        String number3= " 5";
        String number4 = "  ";
        Integer sum2 = stringCalculator.add(number3, number4);

        assertEquals(Integer.valueOf(5), sum2);

        String number5= "  ";
        String number6 = "0";
        Integer sum3 = stringCalculator.add(number5, number6);

        assertEquals(Integer.valueOf(zero), sum3);

        String number7 = " ";
        String number8 = "3 ";
        Integer sum4 = stringCalculator.add(number7, number8);

        assertEquals(Integer.valueOf(3), sum4);
    }

    @Test
    public void unknownAmountOfNumbersTest() {
        String[] numbers = {"1", "2", "3", "4 ", "5"};

        Integer sum = stringCalculator.add(numbers);

        assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void unknownAmountOfNumbersNegativeTest() {
        String[] numbers = {"1", "2", "[,.;']3", "", "//[***]\n1***2***3", "1", "//;\\n1;2", "", ",.;'5", "2", "3", "", "1\\n2,3"};

        Integer sum = stringCalculator.add(numbers);

        assertEquals(Integer.valueOf(32), sum);

        String[] numbers1 = {"a s f 1 f af af 1,\n", "1", " f ", ".,,\t..\t,,.\n", "//[*][%]\\n1*2%3"};

        Integer sum1 = stringCalculator.add(numbers1);

        assertEquals(Integer.valueOf(9), sum1);

        String[] numbers2 = {"", "5\n7", "  ", "      ", "  5    "};

        Integer sum2 = stringCalculator.add(numbers2);

        assertEquals(Integer.valueOf(17), sum2);
    }


    @Test
    public void twoParameterOverThresholdNumberTest() {
        String number1 = "2";
        String number2 = "1001";
        Integer sum = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(2), sum);
    }

    @Test
    public void twoParameterWithDelimiterNumberTest() {
        String number1 = "2";
        String number2 = "10,,01";
        Integer sum = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(13), sum);
    }

    @Test
    public void twoParameterNumberTest() {
        String number1 = ",22,";
        String number2 = "22";
        Integer sum = stringCalculator.add(number1, number2);

        assertEquals(Integer.valueOf(44), sum);
    }
}
