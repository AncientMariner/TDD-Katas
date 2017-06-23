package org.xander.katas;

public class TestA {
   public char findFirstUnique(String s) {
        int number = -1;
        if (s.length() == 1) {
            return s.charAt(0);
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0
                    && i + 1 < s.length()
                    && s.charAt(i + 1) != s.charAt(i) ) {
                number = i;
                break;
            }
            if (i - 1 >= 0
                    && s.charAt(i - 1) != s.charAt(i)
                    && i + 1 < s.length()
                    && s.charAt(i + 1) != s.charAt(i)) {
                number = i;
                break;
            }
            if (i == s.length() - 1
                    && s.charAt(i - 1) != s.charAt(i) ) {
                number = i;
                break;
            }
        }
        if (number < 0) {
            throw new IllegalArgumentException("no unique element");
        }
        return s.charAt(number);
    }
}
