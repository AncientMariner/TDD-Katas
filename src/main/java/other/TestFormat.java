package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFormat {
    public String format(int number) {
        int absoluteNumber = Math.abs(number);
        String numberInString = Integer.toString(absoluteNumber);
        char[] symbols = numberInString.toCharArray();
        List<Character> numbers = new ArrayList<>();

        int index = 1;
        for (int i = symbols.length - 1; i >= 0; i--) {
            if (index++ % 3 == 0) {
                numbers.add(symbols[i]);
                if (i > 0) {
                    numbers.add(' ');
                }
            } else {
                numbers.add(symbols[i]);
            }
        }
        List<Character> shallowCopy = numbers.subList(0, numbers.size());
        Collections.reverse(shallowCopy);

        StringBuilder builder = new StringBuilder();
        if (number < 0) {
            builder.append("(");
            for (Character character : shallowCopy) {
                builder.append(character);
            }
            builder.append(")");
        } else {
            for (Character character : shallowCopy) {
                builder.append(character);
            }
        }
        return builder.toString();
    }
}
