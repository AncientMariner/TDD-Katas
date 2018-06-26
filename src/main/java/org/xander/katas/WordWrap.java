package org.xander.katas;

public class WordWrap {
    public String wrap(String testString, int columnNumber) {
        if (testString.length() < columnNumber) {
            return testString;
        }
        StringBuilder stringBuilder = new StringBuilder(testString);

        for (int i = columnNumber; i > 0; i--) {
            if (testString.charAt(i) == ' ') {
                return stringBuilder.substring(0, i)
                        + wrap(stringBuilder.deleteCharAt(i).insert(i, '\n').toString().substring(i),
                               columnNumber).toString();
            }
        }
        return testString;
    }
}
