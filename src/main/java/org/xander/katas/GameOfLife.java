package org.xander.katas;

import java.util.ArrayList;
import java.util.List;

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

        List<Integer> livingElements = new ArrayList<>();
        for (int y = 0; y < dimensionY; y++) {
            for (int x = 0; x < dimensionX; x++) {
                //previous and next neighbour horizontally and vertically present
                if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                        && ensureHorizontalBoundaries(livingCell, dimensionX, y, x)
                        && ensureVertivalBoundaries(livingCell, dimensionX, y, x)
                        && ensureAtLeastTwoNeighboursPresent(livingCell, dimensionX, y, x)) {
                        livingElements.add(y * (dimensionX + 1) + x);
                }
                //previous and next neighbour horizontally present
                if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                        && ensureHorizontalBoundaries(livingCell, dimensionX, y, x)
                        && ensureAtLeastTwoHorizontalNeighboursPresent(livingCell, dimensionX, y, x)) {
                    livingElements.add(y * (dimensionX + 1) + x);
                }
                //previous and next neighbour vertically present
                if (currentElementIsLiving(livingCell[y * (dimensionX + 1) + x])
                        && ensureVertivalBoundaries(livingCell, dimensionX, y, x)
                        && ensureAtLeastTwoVerticalNeighboursPresent(livingCell, dimensionX, y, x)) {
                    livingElements.add(y * (dimensionX + 1) + x);
                }
            }
        }

//        vertical calculation
//        for (int i = 0; i < dimensionY; i++) {
//            for (int j = 0; j < dimensionX; j++) {
//                //previous and next neighbour horizontally absent
//                if (ensureHorizontalBoundaries(livingCell, dimensionX, i, j) &&
//                        ensureVertivalBoundaries(livingCell, dimensionX, i, j) &&
//                        currentElementIsLiving(livingCell[i * (dimensionX + 1) + j])
//                        && neighbourElementIsLivingOrBoundary(livingCell[i * (dimensionX + 1) + j - (dimensionX+1)])
//                        && neighbourElementIsLivingOrBoundary(livingCell[i * (dimensionX + 1) + j + (dimensionX+1)])) {
//                    livingElements.add(i * (dimensionX + 1) + j);
//                }
//            }
//        }

        currentState = formNewGeneration(dimensionY, dimensionX, livingElements);
    }

    private boolean ensureAtLeastTwoVerticalNeighboursPresent(char[] livingCell, int dimensionX, int y, int x) {
        return neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x - (dimensionX + 1)]) && neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x + (dimensionX + 1)]);
    }

    private boolean ensureAtLeastTwoHorizontalNeighboursPresent(char[] livingCell, int dimensionX, int y, int x) {
        return neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x - 1]) && neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x + 1]);
    }

    private boolean ensureAtLeastTwoNeighboursPresent(char[] livingCell, int dimensionX, int y, int x) {
        return (neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x - 1]) && neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x - (dimensionX+1)]))
     || (neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x - 1]) && neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x + (dimensionX+1)]))
     || (neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x + 1]) && neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x - (dimensionX+1)]))
     || (neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x + 1]) && neighbourElementIsLivingOrBoundary(livingCell[y * (dimensionX + 1) + x + (dimensionX+1)]));
    }

    private boolean neighbourElementIsLivingOrBoundary(char c) {
        return (c == '\n' || c == '*');
    }

    private boolean currentElementIsLiving(char c) {
        return c == '*';
    }

    private boolean ensureHorizontalBoundaries(char[] livingCell, int dimensionX, int y, int x) {
        return y * (dimensionX + 1) + x - 1 >= 0 && y * (dimensionX + 1) + x + 1 <= livingCell.length;
    }
    private boolean ensureVertivalBoundaries(char[] livingCell, int dimensionX, int y, int x) {
        return y * (dimensionX + 1) + x - (dimensionX + 1) >= 0 && y * (dimensionX + 1) + x + (dimensionX + 1) <= livingCell.length;
    }

    private String formNewGeneration(int dimensionY, int dimensionX, List<Integer> livingElements) {
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
