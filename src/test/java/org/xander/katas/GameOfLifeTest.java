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

    @Test
    public void testNextGenerationFirstRuleHorizontalNeighbours() {
        int[][] firstGeneration = {{1,2}, {2,2}, {2,3}, {4,5}, {2,4}};
        String afterFirstGeneration = ".*......\n" + ".***....\n" + "........\n" + "....*...\n";
        String resultOfFirstGeneration = gameOfLife.buildTheWholeGeneration(firstGeneration, gameOfLife.drawCell(4, 8));
        assertEquals(afterFirstGeneration, resultOfFirstGeneration);
//        System.out.println(resultOfFirstGeneration + "\n\n\n");

        gameOfLife.evolutionize();

        String resultAfterOneEvolution = gameOfLife.getCurrentState();
//        System.out.println(resultAfterOneEvolution);
        String expectedCellAfterEvolution = "........\n" + ".**.....\n" + "........\n" + "........\n";
        String resultOfSecondGeneration = gameOfLife.getCurrentState();
        assertEquals(expectedCellAfterEvolution, resultOfSecondGeneration);
    }

    @Test
    public void testNextGenerationFirstRuleHorizontalAndVerticalNeighbours() {
        int[][] firstGeneration = {
                {1,1}, {1,2}, {1,3}, {1,4}, {1,7}, {1,8},
                {2,1}, {2,2}, {2,2}, {2,3}, {2,4},{2,8},
                {3,1}, {3,3}, {3,8},
                {4,1}, {4,2}, {4,5}, {4,7}, {4,8} };
        String resultOfFirstGeneration = gameOfLife.buildTheWholeGeneration(firstGeneration, gameOfLife.drawCell(4, 8));
        System.out.println(resultOfFirstGeneration);
        gameOfLife.evolutionize();
        System.out.println(gameOfLife.getCurrentState());
        assertEquals("****...*\n" +
                     "**.*...*\n" +
                     "*......*\n" +
                     "*......*\n", gameOfLife.getCurrentState());
        gameOfLife.evolutionize();
        System.out.println(gameOfLife.getCurrentState());


        assertEquals("****....\n" +
                     "**.....*\n" +
                     "*......*\n" +
                     "........\n", gameOfLife.getCurrentState());
        gameOfLife.evolutionize();
        System.out.println(gameOfLife.getCurrentState());

        assertEquals("***.....\n" +
                     "**......\n" +
                     "........\n" +
                     "........\n", gameOfLife.getCurrentState());
    }

    @Test
    public void testNextGenerationSecondRule() {
//        int[][] firstGeneration = {{1,1}, {1,2}, {1,3}, {2,2}, {2,3}, {4,5}, {2,4}};
        int[][] firstGeneration = {
                {1,1}, {1,2}, {1,3}, {1,4}, {1,7}, {1,8},
                {2,1}, {2,2}, {2,2}, {2,3}, {2,4},{2,8},
                {3,1}, {3,2}, {3,3}, {3,8},
                {4,1}, {4,2}, {4,5}, {4,7}, {4,8} };
        String resultOfFirstGeneration = gameOfLife.buildTheWholeGeneration(firstGeneration, gameOfLife.drawCell(4, 8));

        System.out.println(resultOfFirstGeneration);
        gameOfLife.evolutionize();
        System.out.println(gameOfLife.getCurrentState());
//        gameOfLife.evolutionize();
//
//        String resultAfterOneEvolution = gameOfLife.getCurrentState();
//        System.out.println(resultAfterOneEvolution);
//
//        gameOfLife.evolutionize();
//        String resultAfterSecondEvolution = gameOfLife.getCurrentState();
//        System.out.println(resultAfterSecondEvolution);
    }

    //    TODO third rule

}
