package org.xander.katas;

public class GameOfLife {
    public String drawCell(int dimensionY, int dimensionX) {
        String result = "";
        for (int i = 0; i < dimensionY; i++) {
            for (int j = 0; j < dimensionX; j++) {
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


        for (int i = 0; i <= dimensionY; i++) {
            for (int j = 0; j <= dimensionX; j++) {
                if(i == (liveCellPositionY - 1) && j == (liveCellPositionX - 1)){
                    //dimensionX + 1 because of \n char
                    livingCell[i * (dimensionX + 1) + j] = '*';
                }
            }
        }
        String cellWithLivingElement = String.valueOf(livingCell);

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
}
