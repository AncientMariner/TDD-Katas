package org.xander.number;

public class RomanNumeral {
    public static void main(String[] args) {
        System.out.println("Arabic numerals into Roman Numbers");
    }

    public String convert() {
        return "nothing was sent to convert";
    }

    public String convertOneDigit(String oneDigitNumber) {
        String romanNumber = null;
        switch (oneDigitNumber) {
            case "0": romanNumber = ""; break;
            case "1": romanNumber = "I"; break;
            case "2": romanNumber = "II"; break;
            case "3": romanNumber = "III"; break;
            case "4": romanNumber = "IV"; break;
            case "5": romanNumber = "V"; break;
            case "6": romanNumber = "VI"; break;
            case "7": romanNumber = "VII"; break;
            case "8": romanNumber = "VIII"; break;
            case "9": romanNumber = "IX"; break;
            default: romanNumber = "there is no such a number";
        }
        return romanNumber;
    }

    public String convertTwoDigit(String twoDigitNumber) {
        String romanNumber = null;
        switch (twoDigitNumber) {
            case "10": romanNumber = "X"; break;
            case "20": romanNumber = "XX"; break;
            case "30": romanNumber = "XXX"; break;
            case "40": romanNumber = "XL"; break;
            case "50": romanNumber = "L"; break;
            case "60": romanNumber = "LX"; break;
            case "70": romanNumber = "LXX"; break;
            case "80": romanNumber = "LXXX"; break;
            case "90": romanNumber = "XC"; break;
            default: romanNumber = "there is no such a number";
        }
        return romanNumber;
    }

    public String convertThreeDigit(String threeDigitNumber) {
        String romanNumber = null;
        switch (threeDigitNumber) {
            case "100": romanNumber = "C"; break;
            case "200": romanNumber = "CC"; break;
            case "300": romanNumber = "CCC"; break;
            case "400": romanNumber = "CD"; break;
            case "500": romanNumber = "D"; break;
            case "600": romanNumber = "DC"; break;
            case "700": romanNumber = "DCC"; break;
            case "800": romanNumber = "DCCC"; break;
            case "900": romanNumber = "CM"; break;
            default: romanNumber = "there is no such a number";
        }
        return romanNumber;
    }

    public String convertFourDigit(String fourDigitNumber) {
        String romanNumber = null;
        switch (fourDigitNumber) {
            case "1000": romanNumber = "M"; break;
            default: romanNumber = "there is no such a number";
        }
        return romanNumber;
    }
}
