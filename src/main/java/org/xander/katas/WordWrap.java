package org.xander.katas;

public class WordWrap {
    public String wrap(String testString, int columnNumber) {
        if (testString.length() < columnNumber) {
            return testString;
        }
        StringBuilder stringBuilder = new StringBuilder(testString);
        String result = "";

        for (int i = columnNumber; i > 0 ; i--) {
            if (testString.charAt(i) == ' ') {
                return result +=
                        stringBuilder.substring(0, i)
                        + wrap(stringBuilder.deleteCharAt(i).insert(i, '\n').toString().substring(i),
                               columnNumber).toString();
            }
        }
        return testString;
    }
}
