package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class GameOfLifeTest {
    GameOfLife gameOfLife;

    @Before
    public void setUp() {
        gameOfLife = new GameOfLife();
    }

    @Test
    public void testBasic() {
        assertNotNull(gameOfLife);
    }

    @Test
    public void testOutPutEmptyCell() {
        String expectedCell = "........\n" + "........\n" + "........\n" + "........\n";
        int dimensionX = 8;
        int dimensionY = 4;
        String actualCell = gameOfLife.drawCell(dimensionY,dimensionX);

        assertEquals(expectedCell, actualCell);
    }

    @Test
    public void testFirstPositions() {
        String expectedCell = ".*......\n" + "........\n" + "........\n" + "........\n";
        String cell = gameOfLife.drawCell(4,8);
        int liveCellPositionX = 2;
        int liveCellPositionY = 1;
        String actualCell = gameOfLife.buildFirstGeneration(liveCellPositionY, liveCellPositionX, cell);

        assertEquals(expectedCell, actualCell);

        int liveCellPositionX2= 2;
        int liveCellPositionY2 = 2;
        String expectedCell2 = ".*......\n" + ".*......\n" + "........\n" + "........\n";
        String actualCell2 = gameOfLife.buildFirstGeneration(liveCellPositionY2, liveCellPositionX2, actualCell);

        assertEquals(expectedCell2, actualCell2);

        int liveCellPositionX3= 3;
        int liveCellPositionY3 = 2;
        String expectedCell3 = ".*......\n" + ".**.....\n" + "........\n" + "........\n";
        String actualCell3 = gameOfLife.buildFirstGeneration(liveCellPositionY3, liveCellPositionX3, actualCell2);

        assertEquals(expectedCell3, actualCell3);
    }

    @Test
    public void testWholeGenerationAtOnce() {
        String expectedCell = ".*......\n" + ".**.....\n" + "........\n" + "........\n";
        int[][] input = {{1,2}, {2,2}, {2,3}};
        String result = gameOfLife.buildTheWholeGeneration(input, gameOfLife.drawCell(4, 8));
        assertEquals(expectedCell,result);
    }


}
