package org.xander.katas;

public class SpiltString {
    private int dividedStringsArrayCounter = 0;
    String stringWithoutDelimiter = "";

    public String[] splitString(String input, char[] delimiter) {
        if (input == null || input.isEmpty()) {
            return new String[]{};
        }
        String[] arrayOfDividedStrings = new String[input.length()];

        for (int inputStringSymbolCount = 0; inputStringSymbolCount < input.length(); inputStringSymbolCount++) {

            boolean isLastSymbol = checkWhetherThisIsLastSymbolOfInput(input, inputStringSymbolCount);
            boolean isNextSymbolDelimiter = checkWhetherNextSymbolIsDelimiter(input, inputStringSymbolCount, delimiter);
            boolean isThereNoNeedOfAdditionalWhiteSpace = checkWhetherWhiteSpaceIsJustAdded(arrayOfDividedStrings);

            for (int delimiterCount = 0; delimiterCount < delimiter.length; delimiterCount++) {
                if (input.charAt(inputStringSymbolCount) == delimiter[delimiterCount]) {
                    if (!isLastSymbol && !isThereNoNeedOfAdditionalWhiteSpace && dividedStringsArrayCounter > 0) {
                        arrayOfDividedStrings[dividedStringsArrayCounter++] = "";
                    }
                    break;
                } else {
                    if (delimiterCount == delimiter.length - 1) {
                        stringWithoutDelimiter += input.charAt(inputStringSymbolCount);
                    }

                    if (!stringWithoutDelimiter.equals("")) {
                        if (isLastSymbol && delimiterCount == delimiter.length - 1) {
                            addDividedStringToArray(arrayOfDividedStrings);
                            break;
                        } else if (isNextSymbolDelimiter && delimiterCount == delimiter.length - 1) {
                            addDividedStringToArray(arrayOfDividedStrings);
                        }
                    }
                }
            }
        }
        dividedStringsArrayCounter = 0;
        return arrayOfDividedStrings;
    }

    private void addDividedStringToArray(String[] arrayOfDividedStrings) {
        arrayOfDividedStrings[dividedStringsArrayCounter++] = stringWithoutDelimiter;
        stringWithoutDelimiter = "";
    }

    private boolean checkWhetherWhiteSpaceIsJustAdded(String[] arrayOfDividedStrings) {
        return dividedStringsArrayCounter > 0 && arrayOfDividedStrings[dividedStringsArrayCounter - 1].equals("");
    }

    private boolean checkWhetherThisIsLastSymbolOfInput(String input, int inputStringSymbolCount) {
        return inputStringSymbolCount == input.length() - 1;
    }

    private boolean checkWhetherNextSymbolIsDelimiter(String input, int inputStringSymbolCount, char[] delimiter) {
        if (!checkWhetherThisIsLastSymbolOfInput(input, inputStringSymbolCount)) {
            for (int i = 0; i < delimiter.length; i++) {
                if (input.charAt(inputStringSymbolCount + 1) == delimiter[i]) {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        }
        return false;
    }
}
