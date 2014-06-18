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
        String result = "";
        for (int y = 0; y < calculateYSize(cell); y++) {
            for (int x = 0; x < calculateXSize(cell); x++) {
                if (y == horizontal - 1 && x == vertical - 1) {
                    result += "*";
                } else {
                    result += ".";
                }
            }
            result += "\n";
        }
        cell = result;
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

    public String generateHints() {


        plaveNextHorizontalHints();
        placePreviousHorizontalHints();
        placeAboveVerticalHints();

        return cell;
    }

    private void placeAboveVerticalHints() {
        char[] elements = cell.toCharArray();
        int elementBelowDifference = calculateXSize(cell) + 1;

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
