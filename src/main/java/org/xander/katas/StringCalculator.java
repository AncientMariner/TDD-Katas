package org.xander.katas;

import java.util.regex.Pattern;

public class StringCalculator {
    final int zero = 0;

    public int add() {
        return zero;
    }

    public int add(String number) {
        if (verifyNumberIsZero(number)) return 0;
        return calculateNumber(number);
    }

    public Integer add(String number1, String number2) {
        if(verifyNumberIsZero(number1) && verifyNumberIsZero(number2)) return 0;
            else if(verifyNumberIsZero(number1)) return calculateNumber(number2);
            else if(verifyNumberIsZero(number2)) return calculateNumber(number1);

        //calculate both are negative

        return calculateNumber(number1) + calculateNumber(number2);
    }

    private int calculateNumber(String number) {
        int sum = 0;
        if(stringContainsOnlyNumbers(number))
            for (int elementInArray : number.toCharArray()) {
                sum += Integer.valueOf(String.valueOf((char) ((int) elementInArray)));
            } else {
            for (int elementInArray : number.toCharArray()) {
                if (String.valueOf((char) ((int) elementInArray)).equals("-")) {
                    throw new NumberFormatException("Negative number is not allowed \'" + number + "\'");
                }

                if (String.valueOf((char) ((int) elementInArray)).equals("1") ||
                        String.valueOf((char) ((int) elementInArray)).equals("2") ||
                        String.valueOf((char) ((int) elementInArray)).equals("3") ||
                        String.valueOf((char) ((int) elementInArray)).equals("4") ||
                        String.valueOf((char) ((int) elementInArray)).equals("5") ||
                        String.valueOf((char) ((int) elementInArray)).equals("6") ||
                        String.valueOf((char) ((int) elementInArray)).equals("7") ||
                        String.valueOf((char) ((int) elementInArray)).equals("8") ||
                        String.valueOf((char) ((int) elementInArray)).equals("9") ||
                        String.valueOf((char) ((int) elementInArray)).equals("0")
                        ) {
                    sum += Integer.valueOf(String.valueOf((char) ((int) elementInArray)));
                }
            }
            return sum;
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
        for (String element : numbers) {
            sum += verifyNumberIsZero(element) ? 0 : calculateNumber(element);
        }
        return sum;
    }
}
