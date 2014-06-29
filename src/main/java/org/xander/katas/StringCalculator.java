package org.xander.katas;

import java.util.regex.Pattern;

public class StringCalculator {
    static final int zero = 0;
    static final String negativeNumberMessage = "Negative number is not allowed ";

    public int add() {
        return zero;
    }

    public int add(String number) {
        if (verifyNumberIsZero(number)) return 0;
        return calculateNumber(number);
    }

    public Integer add(String numberOne, String numberTwo) {

        if (validateElementForNegativity(numberOne.toCharArray())
                && validateElementForNegativity(numberTwo.toCharArray()))
            throw new NumberFormatException(negativeNumberMessage + "\'" + numberOne + "\'" + " " + "\'" + numberTwo + "\'");
        else if (!validateElementForNegativity(numberOne.toCharArray())
                && validateElementForNegativity(numberTwo.toCharArray()))
            throw new NumberFormatException(negativeNumberMessage + "\'" + numberTwo + "\'");
        else if (validateElementForNegativity(numberOne.toCharArray())
                && !validateElementForNegativity(numberTwo.toCharArray()))
            throw new NumberFormatException(negativeNumberMessage + "\'" + numberOne + "\'");

        return (verifyNumberIsZero(numberOne) && verifyNumberIsZero(numberTwo)) ? 0 :
                (verifyNumberIsZero(numberOne)) ? calculateNumber(numberTwo) :
                        (verifyNumberIsZero(numberTwo)) ? calculateNumber(numberOne) :
                                calculateNumber(numberOne) + calculateNumber(numberTwo);
    }

    private boolean validateElementForNegativity(char[] elementInArray1) {
        for (int elementInArray : elementInArray1)
            return String.valueOf((char) elementInArray).equals("-");
        return false;
    }

    private int calculateNumber(String number) {
        int sum = zero;
        if (stringContainsOnlyNumbers(number) && Integer.parseInt(number) > 1000) {
            return zero;
        } else {
            if (number.trim().equals(""))
                return zero;
            String result = "0";

            for (int elementInArray : number.toCharArray()) {
                if (stringContainsOnlyNumbers(String.valueOf((char) elementInArray)))
                    result += Integer.parseInt(String.valueOf((char)elementInArray));
                else {
                    sum += Integer.parseInt(result);
                    result = "0";
                }
            }
            sum += Integer.parseInt(result);
        }
        return sum;
    }

    private boolean stringContainsOnlyNumbers(String number) {
        return !Pattern.compile(".*[^0-9].*").matcher(number).matches();
    }

    private boolean verifyNumberIsZero(String number) {
        return number.length() == zero || calculateNumber(number) == 0;
    }

    public Integer add(String... numbers) {
        int sum = 0;
        for (String element : numbers)
            sum += verifyNumberIsZero(element) ? 0 : calculateNumber(element);
        return sum;
    }
}
