package org.xander.katas;

public class RomanNumeral {
    final String ABSENT_NUMBER = "there is no such a number";
    final int THOUSAND = 1000;
    final int HUNDRED = 100;
    final int TEN = 10;

    public static void main(String[] args) {
        System.out.println("Arabic numerals into Roman Numbers");
    }

    public String convert() {
        return "nothing was sent to convert";
    }

    public String convertOneDigit(String oneDigitNumber) {
        if (oneDigitNumber != null) {
            String romanNumber;
            switch (oneDigitNumber) {
                case "1": romanNumber = "I"; break;
                case "2": romanNumber = "II"; break;
                case "3": romanNumber = "III"; break;
                case "4": romanNumber = "IV"; break;
                case "5": romanNumber = "V"; break;
                case "6": romanNumber = "VI"; break;
                case "7": romanNumber = "VII"; break;
                case "8": romanNumber = "VIII"; break;
                case "9": romanNumber = "IX"; break;
                default: romanNumber = ABSENT_NUMBER;
            }
            return romanNumber;
        }
        return ABSENT_NUMBER;
    }

    public String convertTwoDigit(String twoDigitNumber) {
        if (twoDigitNumber != null) {
            String romanNumber;
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
                default: romanNumber = ABSENT_NUMBER;
            }
            return romanNumber;
        }
        return ABSENT_NUMBER;
    }

    public String convertThreeDigit(String threeDigitNumber) {
        if (threeDigitNumber != null) {
        String romanNumber;
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
            default: romanNumber = ABSENT_NUMBER;
        }
        return romanNumber;
        }
        return ABSENT_NUMBER;
    }

    public String convertFourDigit(String fourDigitNumber) {
        if (fourDigitNumber != null) {
        String romanNumber;
        switch (fourDigitNumber) {
            case "1000": romanNumber = "M"; break;
            default: romanNumber = ABSENT_NUMBER;
        }
        return romanNumber;
        }
        return ABSENT_NUMBER;
    }

    public String convertCustomDigit(String customDigit) {
        if (customDigit != null) {
            return convertNumber(customDigit);
        }
        return ABSENT_NUMBER;
    }

    private String convertNumber(String customDigit) {
        String result = "";
        int customDigitLength = customDigit.length();
        if (customDigitLength == 1) {
            return convertOneDigit(customDigit);
        } else {

            if (customDigitLength == 4) {
                int fourNumber = Integer.valueOf(customDigit) / THOUSAND;
                while (fourNumber > 0) {
                    result += convertFourDigit(String.valueOf(THOUSAND));
                    fourNumber--;
                }
                result = threeDigitsNumberConvert(customDigit, result);
            } else if (customDigitLength == 3) {
                result = threeDigitsNumberConvert(customDigit, result);
            } else if (customDigitLength == 2) {
                result = twoDigitsNumberConvert(customDigit, result);
            } else if (customDigitLength == 1) {
                result = oneDigitNumberConvert(customDigit, result);
            } else {
                result = ABSENT_NUMBER;
            }
        }
        return result;
    }

    private String oneDigitNumberConvert(String customDigit, String result) {
        int theLowestDigit = customDigit.length() - 1;
        if (customDigit.substring(theLowestDigit) != null && Integer.valueOf(customDigit.substring(theLowestDigit)) != 0) {
            result += convertOneDigit(customDigit.substring(theLowestDigit));
        }
        return result;
    }

    private String twoDigitsNumberConvert(String customDigit, String result) {
        if ((Integer.valueOf(customDigit) % HUNDRED) != 0) {
            if((Integer.valueOf(customDigit) % HUNDRED) >= 10) {
                int twoNumber = (Integer.valueOf(customDigit) % HUNDRED) / TEN;
                result += convertTwoDigit(String.valueOf(twoNumber * TEN));
            }
            result = oneDigitNumberConvert(customDigit, result);
        }
        return result;
    }

    private String threeDigitsNumberConvert(String customDigit, String result) {
        if ((Integer.valueOf(customDigit) % THOUSAND) != 0) {
            int threeNumber = (Integer.valueOf(customDigit) % THOUSAND) / HUNDRED;
            if (threeNumber != 0) {
                result += convertThreeDigit(String.valueOf(threeNumber * HUNDRED));
            }
            result = twoDigitsNumberConvert(customDigit, result);
        }
        return result;
    }
}
