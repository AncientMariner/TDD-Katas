package org.xander.katas;

import java.util.Set;
import java.util.TreeSet;

public class GameOfLife {
    private String currentState;

    public String drawCell(int dimensionY, int dimensionX) {
        String result = "";
        for (int y = 0; y < dimensionY; y++) {
            for (int x = 0; x < dimensionX; x++) {
                result += ".";
            }
            result += "\n";
        }
        return result;
    }

    public String buildFirstGeneration(int liveCellPositionY, int liveCellPositionX, String cell) {
        char[] livingCell = cell.toCharArray();
        int dimensionY = calculateYSize(cell);
        int dimensionX = calculateXSize(cell);


        for (int y = 0; y < dimensionY; y++) {
            for (int x = 0; x < dimensionX; x++) {
                if(y == (liveCellPositionY - 1) && x == (liveCellPositionX - 1)){
                    //dimensionX + 1 because of \n char
                    livingCell[y * (dimensionX + 1) + x] = '*';
                }
            }
        }
        String cellWithLivingElement = String.valueOf(livingCell);
        currentState = cellWithLivingElement;
        return cellWithLivingElement;
    }

    public String buildTheWholeGeneration(int[][] arrayOfCoordinates, String cell) {
        String result = cell;
        for (int[] yCoordinates : arrayOfCoordinates) {
            result = buildFirstGeneration(yCoordinates[0], yCoordinates[1], result);
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

    public void evolutionize() {
        char[] livingCell = currentState.toCharArray();
        int dimensionY = calculateYSize(currentState);
        int dimensionX = calculateXSize(currentState);

        Set<Integer> livingElements = firstRule(livingCell, dimensionY, dimensionX);
        secondRule(livingCell, dimensionY, dimensionX, livingElements);
//        thirdRule(livingCell, dimensionY, dimensionX, livingElements);

        currentState = formNewGeneration(dimensionY, dimensionX, livingElements);
    }

    private Set<Integer> firstRule(char[] livingCell, int dimensionY, int dimensionX) {
        Set<Integer> livingElements = new TreeSet<>();
        for (int y = 0; y < dimensionY; y++) {
            for (int x = 0; x < dimensionX; x++) {
                if (twoNeighboursLiving(livingCell, dimensionY, dimensionX, livingElements, y, x)) {
                    livingElements.add(y * (dimensionX + 1) + x);
                }
            }
        }
        return livingElements;
    }

    private boolean twoNeighboursLiving(char[] livingCell, int dimensionY, int dimensionX, Set<Integer> livingElements, int y, int x) {
        if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                && ensureHorizontalBoundaries(livingCell, dimensionX, y, x)) {
            if (elementIsLivingOnVerticalBorders(livingCell, dimensionY, dimensionX, y, x)) {
                return true;
            }
        }
        if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                && ensureVerticalBoundaries(livingCell, dimensionX, y, x)) {
            if(elementIsLivingOnHorizontalBorders(livingCell, dimensionY, dimensionX, y, x)) {
                return true;
            }
        }
        if (cornerElementsAreLiving(livingCell, dimensionY, dimensionX, y, x)) {
            return true;
        }
        if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                && ensureHorizontalBoundaries(livingCell, dimensionX, y, x)
                && ensureVerticalBoundaries(livingCell, dimensionX, y, x)
                && ensureAtLeastTwoNeighboursPresentHorizOrVertic(livingCell, dimensionX, y, x)) {
            return true;
        }
        if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                && ensureHorizontalBoundaries(livingCell, dimensionX, y, x)
                && ensureAtLeastTwoHorizontalNeighboursPresent(livingCell, dimensionX, y, x)) {
            return true;
        }
        if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                && ensureVerticalBoundaries(livingCell, dimensionX, y, x)
                && ensureAtLeastTwoVerticalNeighboursPresent(livingCell, dimensionX, y, x)) {
            return true;
        }
        return false;
    }

    private void secondRule(char[] livingCell, int dimensionY, int dimensionX, Set<Integer> livingElements) {
        Set<Integer> deadElements = new TreeSet<>();

        for (int y = 0; y < dimensionY; y++) {
            for (int x = 0; x < dimensionX; x++) {
                if(livingElements.contains(y * (dimensionX + 1) + x))
                if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                        && ensureHorizontalBoundaries(livingCell, dimensionX, y, x)
                        && ensureVerticalBoundaries(livingCell, dimensionX, y, x)
                        && ensureFourNeighboursPresent(livingCell, dimensionX, y, x)) {
                    deadElements.add(y * (dimensionX + 1) + x);
                }
            }
        }
        livingElements.removeAll(deadElements);
    }

    private void thirdRule(char[] livingCell, int dimensionY, int dimensionX, Set<Integer> livingElements) {
        for (int y = 0; y < dimensionY; y++) {
            for (int x = 0; x < dimensionX; x++) {
                if (livingElements.contains(y * (dimensionX + 1) + x)) {
                    if (twoNeighboursLiving(livingCell, dimensionY, dimensionX, livingElements, y, x)) {
                        if (threeNeighboursLiving(livingCell, dimensionY, dimensionX, livingElements, y, x)) {
                            livingElements.add(y * (dimensionX + 1) + x);
                        }
                    }
                }
            }
        }
    }

    private boolean threeNeighboursLiving(char[] livingCell, int dimensionY, int dimensionX, Set<Integer> livingElements, int y, int x) {
        return (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1]))

                || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1]))

                || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1]))

                || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1]));
    }

    private boolean cornerElementsAreLiving(char[] livingCell, int dimensionY, int dimensionX, int y, int x) {
        if (y == 0 && x == 0) {
            return currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)]);
        }
        if (y == 0 && x == dimensionX - 1) {
            return currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)]);
        }
        if (y == dimensionY - 1 && x == 0) {
            return currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)]);
        }
        if (y == dimensionY - 1 && x == dimensionX - 1) {
            return currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)]);
        }
        return false;
    }

    private boolean elementIsLivingOnVerticalBorders(char[] livingCell, int dimensionY, int dimensionX, int y, int x) {
        if (y == 0) {
            return (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])
                || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])));
        }
        if (y == dimensionY - 1) {
            return (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
                || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])));
        }
        return false;
    }

    private boolean elementIsLivingOnHorizontalBorders(char[] livingCell, int dimensionY, int dimensionX, int y, int x) {
        if (x == 0) {
            return (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
                || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])));
        }
        if (x == dimensionX - 1) {
            return (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
                || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                    && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])));
        }
        return false;
    }

    private boolean ensureFourNeighboursPresent(char[] livingCell, int dimensionX, int y, int x) {
        return currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
            && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)])
            && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
            && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1]);
    }

    private boolean ensureAtLeastTwoVerticalNeighboursPresent(char[] livingCell, int dimensionX, int y, int x) {
        return currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)])
            && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)]);
    }

    private boolean ensureAtLeastTwoHorizontalNeighboursPresent(char[] livingCell, int dimensionX, int y, int x) {
        return currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
            && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1]);
    }

    private boolean ensureAtLeastTwoNeighboursPresentHorizOrVertic(char[] livingCell, int dimensionX, int y, int x) {
        return (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX+1)]))
            || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX+1)]))
            || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x - (dimensionX+1)]))
            || (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + 1])
                && currentElementIsLiving(livingCell[y * (dimensionX + 1) + x + (dimensionX+1)]));
    }

    private boolean currentElementIsLiving(char givenElement) {
        return givenElement == '*';
    }

    private boolean ensureHorizontalBoundaries(char[] livingCell, int dimensionX, int y, int x) {
        return y * (dimensionX + 1) + x - 1 >= 0 && y * (dimensionX + 1) + x + 1 < livingCell.length;
    }
    private boolean ensureVerticalBoundaries(char[] livingCell, int dimensionX, int y, int x) {
        return y * (dimensionX + 1) + x - (dimensionX + 1) >= 0
            && y * (dimensionX + 1) + x + (dimensionX + 1) < livingCell.length;
    }

    private String formNewGeneration(int dimensionY, int dimensionX, Set<Integer> livingElements) {
        String newGeneration = "";
        for (int y = 0; y < dimensionY; y++) {
            for (int x = 0; x < dimensionX; x++) {
                if (livingElements.contains(y * (dimensionX + 1) + x)) {
                    newGeneration += "*";
                } else
                    newGeneration += ".";
            }
            newGeneration += "\n";
        }
        return newGeneration;
    }

    private void printCellContent() {
        int i = 0;
        for (char a : currentState.toCharArray()) {
            System.out.println("counter= " + i++ + " element= " + a);
        }
    }

    public String getCurrentState() {
        return currentState;
    }
}
