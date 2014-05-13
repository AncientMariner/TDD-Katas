package org.xander.katas;

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
        return calculateNumber(number1) + calculateNumber(number2);
    }

    private int calculateNumber(String number) {
        int sum = 0;
        for (int elementInArray : number.toCharArray()) {
            sum += elementInArray == ' ' ? 0 : Integer.valueOf(String.valueOf((char)((int)elementInArray)));
        }
        return sum;
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
