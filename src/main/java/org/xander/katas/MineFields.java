package org.xander.katas;

public class MineFields {
    String cell;

    public String drawCell(int sizeOfXDimension, int sizeOfYDimension) {
        String result = "";
        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                result += ".";
            }
            result += "\n";
        }
        cell = result;
        return result;
    }

    public void placeMineAt(int horizontal, int vertical) {
        if (cell.isEmpty()) {
            throw new UnsupportedOperationException("It is not possible to place mine at no field");
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
        plaveNextHorizontalHints();
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

            if (elements[i] != '*' && theElementLeftBelow == '*') {
                elements[i] = '1';
            }
            if (elements[i] != '*' && theElementRightBelow == '*') {
                elements[i] = '1';
            }
        }

        for (int i = (calculateXSize(cell) + 1) + 1; i < elements.length; i++) {
            char theElementLeftAbove = elements[i - (calculateXSize(cell) + 1) - 1];
            char theElementRightAbove = elements[i - (calculateXSize(cell) + 1) + 1];

            if (elements[i] != '*' && theElementLeftAbove == '*') {
                elements[i] = '1';
            }
            if (elements[i] != '*' && theElementRightAbove == '*') {
                elements[i] = '1';
            }

        }
        cell = String.valueOf(elements);
    }

    private void placeAboveVerticalHints() {
        char[] elements = cell.toCharArray();

        for (int i = (calculateXSize(cell) + 1); i < elements.length; i++) {
            char theElementBelow = elements[i - (calculateXSize(cell) + 1)];
            if (elements[i] != '*' && theElementBelow == '*') {
                elements[i] = '1';
            }
        }
        cell = String.valueOf(elements);
    }

    private void placeBelowVerticalHints() {
        char[] elements = cell.toCharArray();

        for (int i = 0; i < elements.length - (calculateXSize(cell) + 1); i++) {
            char theElementBelow = elements[i + (calculateXSize(cell) + 1)];
            if (elements[i] != '*' && theElementBelow == '*') {
                elements[i] = '1';
            }
        }
        cell = String.valueOf(elements);
    }

    private void plaveNextHorizontalHints() {
        char[] elements = cell.toCharArray();
        for (int i = 0; i < elements.length - 1; i++) {
            if (elements[i] != '*' && elements[i + 1] == '*') {
                elements[i] = '1';
            }
        }
        cell = String.valueOf(elements);
    }

    private void placePreviousHorizontalHints() {
        char[] elements = cell.toCharArray();

        for (int i = 1; i < elements.length; i++) {
            if (elements[i] != '*' && elements[i - 1] == '*') {
                elements[i] = '1';
            }
        }
        cell = String.valueOf(elements);
    }

    public String getCell() {
        return cell;
    }
}
