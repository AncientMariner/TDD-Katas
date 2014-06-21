package org.xander.katas;

import java.util.Set;
import java.util.TreeSet;

public class GameOfLife {
    private String currentState;

    public String drawCell(int sizeOfXDimension, int sizeOfYDimension) {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                result.append(".");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String buildTheBeginning(int liveCellPositionX, int liveCellPositionY, String cell) {
        char[] livingCell = cell.toCharArray();
        int sizeOfYDimension = calculateYSize(cell);
        int sizeOfXDimension = calculateXSize(cell);


        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                if(y == (liveCellPositionY - 1) && x == (liveCellPositionX - 1)){
                    livingCell[y * lengthOfXDimension(sizeOfXDimension) + x] = '*';
                }
            }
        }
        String cellWithLivingElement = String.valueOf(livingCell);
        currentState = cellWithLivingElement;
        return cellWithLivingElement;
    }

    private int lengthOfXDimension(int sizeOfXDimension) {
        // (sizeOfXDimension + 1) - mind the '\n' char presence
        return sizeOfXDimension + 1;
    }

    public String buildTheWholeGeneration(int[][] arrayOfCoordinates, String cell) {
        String result = cell;
        for (int[] coordinates : arrayOfCoordinates) {
            result = buildTheBeginning(coordinates[1], coordinates[0], result);
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
        int sizeOfXDimension = calculateXSize(currentState);
        int sizeOfYDimension = calculateYSize(currentState);

        Set<Integer> livingElements =
                firstRule(sizeOfXDimension, sizeOfYDimension, livingCell);
                secondRule(sizeOfXDimension, sizeOfYDimension, livingCell, livingElements);
                thirdRule(sizeOfXDimension, sizeOfYDimension, livingCell, livingElements);
                fourthRule(sizeOfXDimension, sizeOfYDimension, livingCell, livingElements);

        currentState = formNewGeneration(sizeOfXDimension, sizeOfYDimension, livingElements);
    }

    private Set<Integer> firstRule(int sizeOfXDimension, int sizeOfYDimension, char[] livingCell) {
        Set<Integer> livingElements = new TreeSet<>();
        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                if (twoNeighboursLiving(x, y, sizeOfXDimension, sizeOfYDimension, livingCell)) {
                    livingElements.add(y * (lengthOfXDimension(sizeOfXDimension)) + x);
                }
            }
        }
        return livingElements;
    }

    private boolean twoNeighboursLiving(int x, int y, int sizeOfXDimension, int sizeOfYDimension, char[] livingCell) {
        return currentElementIsLiving(livingCell[y * (lengthOfXDimension(sizeOfXDimension)) + x])
                && (ensureHorizontalBoundaries(sizeOfXDimension, x, y, livingCell) && elementIsLivingOnVerticalBorders(sizeOfXDimension, sizeOfYDimension, x, y, livingCell)

                || (ensureVerticalBoundaries(sizeOfXDimension, x, y, livingCell)
                    && ensureAtLeastTwoVerticalNeighboursPresent(sizeOfXDimension, x, y, livingCell))

                || (ensureHorizontalBoundaries(sizeOfXDimension, x, y, livingCell)
                    && ensureAtLeastTwoHorizontalNeighboursPresent(sizeOfXDimension, x, y, livingCell))

                || (ensureHorizontalBoundaries(sizeOfXDimension, x, y, livingCell)
                    && ensureVerticalBoundaries(sizeOfXDimension, x, y, livingCell)
                    && ensureAtLeastTwoNeighboursPresentHorizOrVertic(sizeOfXDimension, x, y, livingCell))

                || cornerElementsAreLiving(sizeOfXDimension, sizeOfYDimension, x, y, livingCell)

                || (ensureVerticalBoundaries(sizeOfXDimension, x, y, livingCell)
                    && elementIsLivingOnHorizontalBorders(sizeOfXDimension, x, y, livingCell)));
    }

    private void secondRule(int sizeOfXDimension, int sizeOfYDimension, char[] livingCell, Set<Integer> livingElements) {
        Set<Integer> deadElements = new TreeSet<>();

        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                if(livingElements.contains(y * (lengthOfXDimension(sizeOfXDimension)) + x))
                if (currentElementIsLiving(livingCell[y * (lengthOfXDimension(sizeOfXDimension)) + x])
                        && ensureHorizontalBoundaries(sizeOfXDimension, x, y, livingCell)
                        && ensureVerticalBoundaries(sizeOfXDimension, x, y, livingCell)
                        && ensureFourNeighboursPresent(sizeOfXDimension, x, y, livingCell)) {
                    deadElements.add(y * (lengthOfXDimension(sizeOfXDimension)) + x);
                }
            }
        }
        livingElements.removeAll(deadElements);
    }

    private void thirdRule(int sizeOfXDimension, int sizeOfYDimension, char[] livingCell, Set<Integer> livingElements) {
        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                if (livingElements.contains(y * (lengthOfXDimension(sizeOfXDimension)) + x)) {
                        if (threeNeighboursLiving(sizeOfXDimension, sizeOfYDimension, x, y, livingCell)) {
                            livingElements.add(y * (lengthOfXDimension(sizeOfXDimension)) + x);
                    }
                }
            }
        }
    }

    private void fourthRule(int sizeOfXDimension, int sizeOfYDimension, char[] livingCell, Set<Integer> livingElements) {
        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                if (!livingElements.contains(y * (lengthOfXDimension(sizeOfXDimension)) + x)) {
                    if (threeNeighboursLiving(sizeOfXDimension, sizeOfYDimension, x, y, livingCell)) {
                        livingElements.add(y * (lengthOfXDimension(sizeOfXDimension)) + x);
                    }
                }
            }
        }
    }

    private boolean threeNeighboursLiving(int sizeOfXDimension, int sizeOfYDimension, int x, int y, char[] livingCell) {
        return !cornerElementsAreLiving(sizeOfXDimension, sizeOfYDimension, x, y, livingCell)
                    && (
                    (currentElementIsLiving(livingCell[y * (lengthOfXDimension(sizeOfXDimension)) + x])
                    && (threeElementsAreLivingOnHorizontalBorders(sizeOfXDimension, x, y, livingCell)
                    || threeElementsAreLivingOnVerticalBorders(sizeOfXDimension, sizeOfYDimension, x, y, livingCell)))

                    || (ensureHorizontalBoundaries(sizeOfXDimension, x, y, livingCell)
                    && ensureVerticalBoundaries(sizeOfXDimension, x, y, livingCell)
                    && threeLiveNeighboursPresent(sizeOfXDimension, x, y, livingCell))
                    );
    }

    private boolean threeLiveNeighboursPresent(int sizeOfXDimension, int x, int y, char[] livingCell) {
        return (currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)]))

                || (currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)]))

                || (currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)]))

                || (currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)]));
    }

    private boolean cornerElementsAreLiving(int sizeOfXDimension, int sizeOfYDimension, int x, int y, char[] livingCell) {
        return (((y == 0 && x == 0)
                && currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)]))

                || ((y == 0 && x == sizeOfXDimension - 1)
                && currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)]))

                || ((y == sizeOfYDimension - 1 && x == 0)
                && currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)]))

                || ((y == sizeOfYDimension - 1 && x == sizeOfXDimension - 1)
                && currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])));
    }

    private boolean elementIsLivingOnVerticalBorders(int sizeOfXDimension, int sizeOfYDimension, int x, int y, char[] livingCell) {
       return ((y == 0)
               && (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
               && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])

               || (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
               && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])))

               || ((y == sizeOfYDimension - 1)
               && (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
               && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])

               || (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
               && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])))) );
    }

    private boolean threeElementsAreLivingOnVerticalBorders(int sizeOfXDimension, int sizeOfYDimension, int x, int y, char[] livingCell) {
        return ((y == 0)
                && (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])
                && (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)]))))

                || ((y == sizeOfYDimension - 1)
                && (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                && (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)]))));
    }

    private boolean elementIsLivingOnHorizontalBorders(int sizeOfXDimension, int x, int y, char[] livingCell) {
        if (x == 0) {
            return (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
                || (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])));
        }
        if (x == sizeOfXDimension - 1) {
            return (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
                || (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])));
        }
        return false;
    }

    private boolean threeElementsAreLivingOnHorizontalBorders(int sizeOfXDimension, int x, int y, char[] livingCell) {
        if (x == 0) {
            return (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)]));
        }
        if (x == sizeOfXDimension - 1) {
            return (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
                    && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)]));
        }
        return false;
    }


    private boolean ensureFourNeighboursPresent(int sizeOfXDimension, int x, int y, char[] livingCell) {
        return currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
            && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)])
            && currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
            && currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)]);
    }

    private boolean ensureAtLeastTwoVerticalNeighboursPresent(int sizeOfXDimension, int x, int y, char[] livingCell) {
        return currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)])
            && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)]);
    }

    private boolean ensureAtLeastTwoHorizontalNeighboursPresent(int sizeOfXDimension, int x, int y, char[] livingCell) {
        return currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
            && currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)]);
    }

    private boolean ensureAtLeastTwoNeighboursPresentHorizOrVertic(int sizeOfXDimension, int x, int y, char[] livingCell) {
        return (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)]))
            || (currentElementIsLiving(livingCell[previousElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)]))
            || (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementAbove(sizeOfXDimension, x, y)]))
            || (currentElementIsLiving(livingCell[nextElement(sizeOfXDimension, x, y)])
                && currentElementIsLiving(livingCell[theElementBelow(sizeOfXDimension, x, y)]));
    }

    private boolean currentElementIsLiving(char givenElement) {
        return givenElement == '*';
    }

    private boolean ensureHorizontalBoundaries(int sizeOfXDimension, int x, int y, char[] livingCell) {
        return previousElement(sizeOfXDimension, x, y) >= 0 && nextElement(sizeOfXDimension, x, y) < livingCell.length;
    }

    private int nextElement(int sizeOfXDimension, int x, int y) {
        return y * (lengthOfXDimension(sizeOfXDimension)) + x + 1;
    }

    private int previousElement(int sizeOfXDimension, int x, int y) {
        return y * (lengthOfXDimension(sizeOfXDimension)) + x - 1;
    }

    private boolean ensureVerticalBoundaries(int sizeOfXDimension, int x, int y, char[] livingCell) {
        return theElementAbove(sizeOfXDimension, x, y) >= 0
            && theElementBelow(sizeOfXDimension, x, y) < livingCell.length;
    }

    private int theElementBelow(int sizeOfXDimension, int x, int y) {
        return y * (lengthOfXDimension(sizeOfXDimension)) + x + (lengthOfXDimension(sizeOfXDimension));
    }

    private int theElementAbove(int sizeOfXDimension, int x, int y) {
        return y * (lengthOfXDimension(sizeOfXDimension)) + x - (lengthOfXDimension(sizeOfXDimension));
    }

    private String formNewGeneration(int sizeOfXDimension, int sizeOfYDimension, Set<Integer> livingElements) {
        StringBuilder newGeneration = new StringBuilder();
        for (int y = 0; y < sizeOfYDimension; y++) {
            for (int x = 0; x < sizeOfXDimension; x++) {
                if (livingElements.contains(y * (lengthOfXDimension(sizeOfXDimension)) + x))
                    newGeneration.append("*");
                else
                    newGeneration.append(".");
            }
            newGeneration.append("\n");
        }
        return newGeneration.toString();
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
