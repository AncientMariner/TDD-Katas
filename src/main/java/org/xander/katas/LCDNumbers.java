package org.xander.katas;

public class LCDNumbers {
    public String generateLCDNumberFrom(int number) {
        int lengthOfNumberSequence = "999".toCharArray().length;
        int lengthOfTheLine = 9;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lengthOfTheLine; i += 4) {
            int a = lengthOfNumberSequence;
            for (int size = 2; size >= 0; size--) {
                int numberInEachRange = number % (int) Math.pow(10, a--) / ((int) Math.pow(10, size));
                result.append(generateNumberFromSingleDigit(numberInEachRange).substring(i, i + lengthOfNumberSequence) + " ");
            }
            result.replace(result.length() - 1, result.length(), "");
            result.append("\n");
        }
        return result.substring(0, result.length() - 1);
    }

    private String generateNumberFromSingleDigit(int number) {
        if (number >= 0) {
            switch (number) {
                case 0: return "._.\n|.|\n|_|";
                case 1: return "...\n..|\n..|";
                case 2: return "._.\n._|\n|_.";
                case 3: return "._.\n._|\n._|";
                case 4: return "...\n|_|\n..|";
                case 5: return "._.\n|_.\n._|";
                case 6: return "._.\n|_.\n|_|";
                case 7: return "._.\n..|\n./.";
                case 8: return "._.\n|_|\n|_|";
                case 9: return "._.\n|_|\n..|";
                default: return "number is not present";
            }
        }
        return "";
    }
}
