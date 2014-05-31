package org.xander.katas;

public class Diversion {
    public int calculateAdjacentNumbers(int size) {
        if ((size - 1) >= 2 && (size - 2) >= 1) {
            return calculateAdjacentNumbers(size - 1) + calculateAdjacentNumbers(size - 2);
        }
        if (size - 2 == 0 && size - 1 == 1) {
            return 3;
        }
        return 2;
    }
}
