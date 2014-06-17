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

    public String placeMineAt(int horizontal, int vertical) {
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
        return result;
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
}
