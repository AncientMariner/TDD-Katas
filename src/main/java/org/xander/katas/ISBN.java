package org.xander.katas;

import java.util.regex.Pattern;

public class ISBN {

    public String checkNumber(String numberWithHyphens) {
        String numberWithoutHypens = "";

        for (int element : numberWithHyphens.toCharArray()) {
            if (stringContainsOnlyNumbers(String.valueOf((char) ((int) element)))) {
                numberWithoutHypens += String.valueOf((char) ((int) element));
            }
        }
        return numberWithoutHypens;
    }

    private boolean stringContainsOnlyNumbers(String number) {
        return !Pattern.compile(".*[^0-9].*").matcher(number).matches();
    }

    public String calculateCheckDigitIsbn10(String number) {
        String numberToCalculate = checkNumber(number);
        int checkDigit = 0;
        for (int i = 0; i < numberToCalculate.length(); i++) {
            checkDigit += Integer.valueOf(String.valueOf(((char) (int) numberToCalculate.charAt(i)))) * (i + 1);
        }

        return String.valueOf(checkDigit % 11);
    }

    public String calculateCheckDigitIsbn13(String number) {
        String numberToCalculate = checkNumber(number);
        int checkDigit = 0;
        for (int i = 0; i < numberToCalculate.length(); i++) {
            if ((i + 1) % 2 != 0) {
                checkDigit += Integer.valueOf(String.valueOf(((char) (int) numberToCalculate.charAt(i))));
            } else {
                checkDigit += Integer.valueOf(String.valueOf(((char) (int) numberToCalculate.charAt(i)) )) * 3;
            }
        }
        return String.valueOf(((10 - (checkDigit % 10)) % 10));
    }
}
