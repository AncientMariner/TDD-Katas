package org.xander.katas;

import java.util.Objects;
import java.util.regex.Pattern;

public class MineFields {
    private String cell;

    public String getCell() {
        return cell;
    }

    public String drawCell(int sizeOfYDimension, int sizeOfXDimension) {
        StringBuilder result = new StringBuilder("");
        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                result.append(".");
            }
            result.append("\n");
        }
        cell = result.toString();
        return cell;
    }

    public void placeMineAt(int horizontal, int vertical) {
        Objects.requireNonNull(cell);
        if (cell.isEmpty()) {
            throw new UnsupportedOperationException("It is not possible to place a mine at no field");
        }
        StringBuilder result = new StringBuilder(cell);
        for (int y = 0; y < calculateYSize(cell); y++) {
            for (int x = 0; x < calculateXSize(cell); x++) {
                if (y == horizontal - 1 && x == vertical - 1) {
                    result.replace(elementAtPosition(y, x), elementAtPosition(y, x) + 1, "*");
                }
            }
            result.replace(lastElementInHorizontalRow(y), lastElementInHorizontalRow(y) + 1, "\n");
        }
        cell = result.toString();
    }

    private int lastElementInHorizontalRow(int y) {
        return elementAtPosition(y, calculateXSize(cell));
    }

    private int elementAtPosition(int y, int x) {
        return y * (calculateXSize(cell) + 1) + x;
    }

    private int calculateXSize(String cell) {
        int size = 0;
        for (char element : cell.toCharArray()) {
            if (element != '\n') {
                size++;
            } else break;
        }
        return size;
    }

    private int calculateYSize(String cell) {
        int size = 0;
        for (char element : cell.toCharArray()) {
            if (element == '\n') {
                size++;
            }
        }
        return size;
    }

    public void generateHints() {
        placeNextHorizontalHints();
        placePreviousHorizontalHints();
        placeAboveVerticalHints();
        placeBelowVerticalHints();
        placeDiagonalHints();
    }

    private void placeDiagonalHints() {
        char[] elements = cell.toCharArray();
        for (int i = 0; i < elements.length - (calculateXSize(cell) + 1) - 1; i++) {
            char theElementLeftBelow = elements[i + (calculateXSize(cell) + 1) - 1];
            char theElementRightBelow = elements[i + (calculateXSize(cell) + 1) + 1];
            placeHint(elements, i, theElementLeftBelow);
            placeHint(elements, i, theElementRightBelow);
        }
        for (int i = (calculateXSize(cell) + 1) + 1; i < elements.length; i++) {
            char theElementLeftAbove = elements[i - (calculateXSize(cell) + 1) - 1];
            char theElementRightAbove = elements[i - (calculateXSize(cell) + 1) + 1];
            placeHint(elements, i, theElementLeftAbove);
            placeHint(elements, i, theElementRightAbove);
        }
        cell = String.valueOf(elements);
    }

    private void placeAboveVerticalHints() {
        char[] elements = cell.toCharArray();
        for (int i = (calculateXSize(cell) + 1); i < elements.length; i++) {
            char theElementBelow = elements[i - (calculateXSize(cell) + 1)];
            placeHint(elements, i, theElementBelow);
        }
        cell = String.valueOf(elements);
    }

    private void placeBelowVerticalHints() {
        char[] elements = cell.toCharArray();
        for (int i = 0; i < elements.length - (calculateXSize(cell) + 1); i++) {
            char theElementBelow = elements[i + (calculateXSize(cell) + 1)];
            placeHint(elements, i, theElementBelow);
        }
        cell = String.valueOf(elements);
    }

    private void placeNextHorizontalHints() {
        char[] elements = cell.toCharArray();
        for (int i = 0; i < elements.length - 1; i++) {
            char nextElement = elements[i + 1];
            placeHint(elements, i, nextElement);
        }
        cell = String.valueOf(elements);
    }

    private void placePreviousHorizontalHints() {
        char[] elements = cell.toCharArray();
        for (int i = 1; i < elements.length; i++) {
            char previousElement = elements[i - 1];
            placeHint(elements, i, previousElement);
        }
        cell = String.valueOf(elements);
    }

    private void placeHint(char[] elements, int currentNumber, char neighbourElement) {
        if (neighbourElement == '*') {
            if (elements[currentNumber] != '*' && elements[currentNumber] != '\n') {
                if (stringContainsOnlyNumbers(String.valueOf(elements[currentNumber]))) {
                    elements[currentNumber] = (char) (elements[currentNumber] + 1);
                } else {
                    elements[currentNumber] = '1';
                }
            }
        }
    }

    private boolean stringContainsOnlyNumbers(String number) {
        return Pattern.compile("[1-9]").matcher(number).matches();
    }
}
