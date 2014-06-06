package org.xander.katas;

public class LCDNumbers {
    public String generateLCDNumberFrom(int number) {
        String hundreds = generateNumberFromSingleDigit(number / 100);
        String tens = generateNumberFromSingleDigit(number % 100 / 10);
        String ones = generateNumberFromSingleDigit(number % 10  / 1);

        String firstLine = hundreds.substring(0, 3) + " " + tens.substring(0, 3) + " " + ones.substring(0, 3);
        String secondLine = hundreds.substring(4, 7) + " " + tens.substring(4, 7) + " " + ones.substring(4, 7);
        String thirdLine = hundreds.substring(8) + " " + tens.substring(8) + " " + ones.substring(8);

        String result = firstLine + "\n" + secondLine + "\n" + thirdLine;

        return result;
    }

    private String generateNumberFromSingleDigit(int number) {
        String lcdNumber="";
        if (number >= 0) {
            switch (number) {
                case 0: lcdNumber = "._.\n|.|\n|_|"; break;
                case 1: lcdNumber = "...\n..|\n..|"; break;
                case 2: lcdNumber = "._.\n._|\n|_."; break;
                case 3: lcdNumber = "._.\n._|\n._|"; break;
                case 4: lcdNumber = "...\n|_|\n..|"; break;
                case 5: lcdNumber = "._.\n|_.\n._|"; break;
                case 6: lcdNumber = "._.\n|_.\n|_|"; break;
                case 7: lcdNumber = "._.\n..|\n./."; break;
                case 8: lcdNumber = "._.\n|_|\n|_|"; break;
                case 9: lcdNumber = "._.\n|_|\n..|"; break;
            }
        }
        return lcdNumber;
    }
}
