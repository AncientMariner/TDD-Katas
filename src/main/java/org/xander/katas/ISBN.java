package org.xander.katas;

import java.util.regex.Pattern;

public class ISBN {
    public String checkNumber(String numberWithHyphens) {
        StringBuilder numberWithoutHyphens = new StringBuilder();

        for (int element : numberWithHyphens.toCharArray()) {
            if (stringContainsOnlyNumbers(String.valueOf((char) element))) {
                numberWithoutHyphens.append(String.valueOf((char) element));
            }
        }
        return numberWithoutHyphens.toString();
    }

    private boolean stringContainsOnlyNumbers(String number) {
        return Pattern.compile(".*[0-9].*").matcher(number).matches();
    }

    public String calculateCheckDigitIsbn10(String number) {
        String numberToCalculate = checkNumber(number);
        int checkDigit = 0;
        for (int i = 0; i < numberToCalculate.length(); i++) {
            checkDigit += Integer.parseInt(String.valueOf(((char) (int) numberToCalculate.charAt(i)))) * (i + 1);
        }

        return String.valueOf(checkDigit % 11);
    }

    public String calculateCheckDigitIsbn13(String number) {
        String numberToCalculate = checkNumber(number);
        int checkDigit = 0;
        for (int i = 0; i < numberToCalculate.length(); i++) {
            if ((i + 1) % 2 != 0) {
                checkDigit += Integer.parseInt(String.valueOf(((char) (int) numberToCalculate.charAt(i))));
            } else {
                checkDigit += Integer.parseInt(String.valueOf(((char) (int) numberToCalculate.charAt(i)))) * 3;
            }
        }
        return String.valueOf(((10 - (checkDigit % 10)) % 10));
    }
}
