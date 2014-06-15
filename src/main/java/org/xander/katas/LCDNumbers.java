package org.xander.katas;

public class LCDNumbers {
    public String generateLCDNumberFrom(int number) {
        int lengthOfNumberSequence = "999".toCharArray().length;
        int lengthOfTheLine = 9;
        String result = "";

        for (int i = 0; i < lengthOfTheLine; i += 4) {
            int a = lengthOfNumberSequence;
            for (int size = 2; size >= 0; size--) {
                int numberInEachRange = number % (int) Math.pow(10, a--) / ((int) Math.pow(10, size));
                result += generateNumberFromSingleDigit(numberInEachRange).substring(i, i + lengthOfNumberSequence) + " ";
            }
            result = result.trim();
            result += "\n";
        }
        return result.substring(0, result.length() - 1);
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
