package org.xander.number;

public class StringCalculator {
    public int add() {
        return 0;
    }

    public int add(String number) {
        if (verifyNumberIsZero(number)) return 0;
        return Integer.valueOf(number);
    }

    public Integer add(String number1, String number2) {
        if(verifyNumberIsZero(number1) && verifyNumberIsZero(number2)) return 0;
            else if(verifyNumberIsZero(number1)) return Integer.valueOf(number2);
            else if(verifyNumberIsZero(number2)) return Integer.valueOf(number1);
        return Integer.valueOf(number1) + Integer.valueOf(number2);
    }

    private boolean verifyNumberIsZero(String number) {
        return number.length() == 0 || number.toCharArray()[0] == ' ';
    }
}
