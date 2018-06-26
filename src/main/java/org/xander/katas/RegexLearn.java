package org.xander.katas;

import java.util.regex.Matcher;

public class RegexLearn {
    public boolean findTheResult(Matcher matcher) {
        boolean found = false;
        while (matcher.find()) {
            System.out.printf("The following text is found:"
                               + " \"%s\"; starting at "
                               + "index %d and ending at index %d.%n%n",
                                matcher.group(),
                                matcher.start(),
                                matcher.end());
            found = true;
        }
        if (!found) {
            System.out.println("No match found.");
            return found;
        } else {
            return found;
        }
    }
}
