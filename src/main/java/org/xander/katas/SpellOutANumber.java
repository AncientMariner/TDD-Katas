package org.xander.katas;

public class SpellOutANumber {
    static final int HUNDRED = 100;
    static final int THOUSAND = 1000;
    private static final int MILLION = 1_000_000;
    private static final int BILLION = 1_000_000_000;

    public String spellOutOneDigitNumber(int number) {
        String result = "";
        switch (number) {
            case 1: result += "one"; break;
            case 2: result += "two"; break;
            case 3: result += "three"; break;
            case 4: result += "four"; break;
            case 5: result += "five"; break;
            case 6: result += "six"; break;
            case 7: result += "seven"; break;
            case 8: result += "eight"; break;
            case 9: result += "nine"; break;
            default: result += "";
        }
        return result;
    }

    public String spellOutTwoDigitNumber(int number) {
        String result;
        switch (number) {
            case 10: result = "ten"; break;
            case 11: result = "eleven"; break;
            case 12: result = "twelve"; break;
            case 13: result = "thirteen"; break;
            case 14: result = "fourteen"; break;
            case 15: result = "fifteen"; break;
            case 16: result = "sixteen"; break;
            case 17: result = "seventeen"; break;
            case 18: result = "eighteen"; break;
            case 19: result = "nineteen"; break;
            default: result = spellOutOneDigitNumber(number);
        }
        return result;
    }

    public String spellOutTwoDigitNumberAbove20(int number) {
        String result = "";
        if (number - 90 >= 0) {
            result += "ninety" + " " + spellOutOneDigitNumber(number - 90);
        } else if (number - 80 >= 0) {
            result += "eighty" + " " + spellOutOneDigitNumber(number - 80);
        } else if (number - 70 >= 0) {
            result += "seventy" + " " + spellOutOneDigitNumber(number - 70);
        } else if (number - 60 >= 0) {
            result += "sixty" + " " + spellOutOneDigitNumber(number - 60);
        } else if (number - 50 >= 0) {
            result += "fifty" + " " + spellOutOneDigitNumber(number - 50);
        } else if (number - 40 >= 0) {
            result += "forty" + " " + spellOutOneDigitNumber(number - 40);
        } else if (number - 30 >= 0) {
            result += "thirty" + " " + spellOutOneDigitNumber(number - 30);
        } else if (number - 20 >= 0) {
            result += "twenty" + " " + spellOutOneDigitNumber(number - 20);
        } else if (number % 10 >= 0) {
            result += spellOutTwoDigitNumber(number);
        }
        return result;
    }

    public String spellOutThreeDigitNumber(int number) {
        String result = "";
        if (number != 0) {
            int numberOfHundreds = number / HUNDRED;
            String hundredsPart = "";
            if (numberOfHundreds > 0) {
                hundredsPart = spellOutOneDigitNumber(numberOfHundreds) + " HUNDRED ";
            }
            result = hundredsPart + spellOutTwoDigitNumberAbove20(number % HUNDRED);
        }
        return result.trim();
    }

    public String spellOutFourDigitNumber(int number) {
        String result = "";
        if (number != 0) {
            int numberOfThousands = number / THOUSAND;
            String thousandsPart = "";
            if (numberOfThousands > 0) {
                thousandsPart = spellOutOneDigitNumber(numberOfThousands) + " THOUSAND ";
            }
            result = thousandsPart + spellOutThreeDigitNumber(number % THOUSAND);
        }
        return result.trim();
    }

    public String spellOutFiveDigitNumber(int number) {
        String result = "";
        if (number != 0) {
            int numberOfThousands = number / THOUSAND;
            String thousandsPart = "";
            if (numberOfThousands > 0) {
                thousandsPart = spellOutTwoDigitNumber(numberOfThousands) + " THOUSAND ";
            }
            result = thousandsPart + spellOutThreeDigitNumber(number % THOUSAND);
            }
        return result.trim();
    }

    public String spellOutSixDigitNumber(int number) {
        String result = "";
        if (number != 0) {
            int numberOfThousands = number / THOUSAND;
            String thousandsPart = "";
            if (numberOfThousands > 0) {
                thousandsPart = spellOutThreeDigitNumber(numberOfThousands) + " THOUSAND ";
            }
            result = thousandsPart + spellOutThreeDigitNumber(number % THOUSAND);
        }
        return result.trim();
    }

    public String spellOutSevenDigitNumber(int number) {
        String result = "";
        if (number != 0) {
            int numberOfMillions = number / MILLION;
            String thousandsPart = "";
            if (numberOfMillions > 0) {
                thousandsPart = spellOutOneDigitNumber(numberOfMillions) + " MILLION ";
            }
            result = thousandsPart + spellOutSixDigitNumber(number % MILLION);
        }
        return result.trim();
    }

    public String spellOutEightDigitNumber(int number) {
        String result = "";
        if (number != 0) {
            int numberOfMillions = number / MILLION;
            String thousandsPart = "";
            if (numberOfMillions > 0) {
                thousandsPart = spellOutTwoDigitNumberAbove20(numberOfMillions) + " MILLION ";
            }
            result = thousandsPart + spellOutSixDigitNumber(number % MILLION);
        }
        return result.trim();
    }

    public String spellOutNineDigitNumber(int number) {
        String result = "";
        if (number != 0) {
            int numberOfMillions = number / MILLION;
            String thousandsPart = "";
            if (numberOfMillions > 0) {
                thousandsPart = spellOutThreeDigitNumber(numberOfMillions) + " MILLION ";
            }
            result = thousandsPart + spellOutSixDigitNumber(number % MILLION);
        }
        return result.trim();
    }

    public String spellOutTenDigitNumber(long number) {
        String result = "";
        if (number != 0) {
            long numberOfBillions = number / BILLION;
            String thousandsPart = "";
            if (numberOfBillions > 0) {
                thousandsPart = spellOutTwoDigitNumberAbove20((int) numberOfBillions) + " BILLION ";
            }
            result = thousandsPart + spellOutNineDigitNumber((int) (number % BILLION));
        }
        return result.trim();
    }

    public String spellOutANumber(long number) {
        String result = "";
        if (number != 0) {
            result = spellOutTenDigitNumber(number);
        }
        return result.trim();
    }
}
