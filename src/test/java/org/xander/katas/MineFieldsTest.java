package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class MineFieldsTest {
    MineFields mineFields;

    @Before
    public void setUp() {
        mineFields = new MineFields();
    }

    @Test
    public void basic() {
        assertNotNull(mineFields);
    }

    @Test
    public void emptyCell() {
        assertEquals("........\n" + "........\n" + "........\n" + "........\n", mineFields.drawCell(4, 8));
    }

    @Test
    public void outputCellWithMineAtCertainPosition() {
        mineFields.drawCell(4, 8);
        mineFields.placeMineAt(1, 2);

        assertEquals(".*......\n" + "........\n" + "........\n" + "........\n", mineFields.getCell());
    }

    @Test
    public void horizontalAndVerticalMembers() {
        mineFields.drawCell(4, 8);
        mineFields.placeMineAt(3, 2);

        assertEquals("........\n" + "........\n" + ".*......\n" + "........\n", mineFields.getCell());

        mineFields.placeMineAt(3, 6);
        mineFields.generateHints();

        assertEquals("........\n" + "111.111.\n" + "1*1.1*1.\n" + "111.111.\n", mineFields.getCell());
    }

    @Test
    public void diagonalMembers() {
        mineFields.drawCell(4, 8);
        mineFields.placeMineAt(3, 2);

        assertEquals("........\n" + "........\n" + ".*......\n" + "........\n", mineFields.getCell());

        mineFields.generateHints();

        assertEquals("........\n" + "111.....\n" + "1*1.....\n" + "111.....\n", mineFields.getCell());
    }

    @Test
    public void multipleMinesPlacedNearby() {
        mineFields.drawCell(4, 8);
        mineFields.placeMineAt(2, 3);
        mineFields.placeMineAt(3, 2);
        mineFields.placeMineAt(3, 4);

        assertEquals("........\n" +
                     "..*.....\n" +
                     ".*.*....\n" +
                     "........\n", mineFields.getCell());
        mineFields.generateHints();

        assertEquals(".111....\n" +
                     "12*21...\n" +
                     "1*3*1...\n" +
                     "11211...\n", mineFields.getCell());
    }

    @Test
    public void multipleMinesPlacedNearbyNineMines() {
        mineFields.drawCell(4, 8);
        mineFields.placeMineAt(2, 2);
        mineFields.placeMineAt(2, 3);
        mineFields.placeMineAt(2, 4);
        mineFields.placeMineAt(3, 2);
        mineFields.placeMineAt(3, 4);
        mineFields.placeMineAt(4, 2);
        mineFields.placeMineAt(4, 3);
        mineFields.placeMineAt(4, 4);

        assertEquals("........\n" +
                     ".***....\n" +
                     ".*.*....\n" +
                     ".***....\n", mineFields.getCell());
        mineFields.generateHints();

        assertEquals("12321...\n" +
                     "2***2...\n" +
                     "3*8*3...\n" +
                     "2***2...\n", mineFields.getCell());
    }

    @Test
    public void multipleMinesPlacedNearbyNineMinesBigField() {
        mineFields.drawCell(10, 20);
        mineFields.placeMineAt(2, 2);
        mineFields.placeMineAt(2, 3);
        mineFields.placeMineAt(2, 4);
        mineFields.placeMineAt(3, 2);
        mineFields.placeMineAt(3, 4);
        mineFields.placeMineAt(4, 2);
        mineFields.placeMineAt(4, 3);
        mineFields.placeMineAt(4, 4);

        mineFields.placeMineAt(2, 5);
        mineFields.placeMineAt(2, 7);
        mineFields.placeMineAt(2, 9);
        mineFields.placeMineAt(3, 7);
        mineFields.placeMineAt(3, 10);
        mineFields.placeMineAt(3, 20);
        mineFields.placeMineAt(4, 16);
        mineFields.placeMineAt(4, 17);
        mineFields.placeMineAt(4, 18);
        mineFields.placeMineAt(4, 19);
        mineFields.placeMineAt(4, 20);
        mineFields.placeMineAt(5, 20);

        mineFields.placeMineAt(6, 2);
        mineFields.placeMineAt(6, 3);
        mineFields.placeMineAt(6, 4);
        mineFields.placeMineAt(7, 2);
        mineFields.placeMineAt(7, 4);
        mineFields.placeMineAt(8, 2);
        mineFields.placeMineAt(8, 3);
        mineFields.placeMineAt(8, 4);

        mineFields.placeMineAt(6, 6);
        mineFields.placeMineAt(6, 7);
        mineFields.placeMineAt(6, 8);
        mineFields.placeMineAt(7, 6);
        mineFields.placeMineAt(7, 8);
        mineFields.placeMineAt(8, 6);
        mineFields.placeMineAt(8, 7);
        mineFields.placeMineAt(8, 8);

        mineFields.placeMineAt(10, 16);
        mineFields.placeMineAt(10, 17);
        mineFields.placeMineAt(9, 17);
        mineFields.placeMineAt(9, 18);
        mineFields.placeMineAt(8, 18);
        mineFields.placeMineAt(8, 19);
        mineFields.placeMineAt(7, 19);
        mineFields.placeMineAt(7, 20);

        mineFields.placeMineAt(1, 1);
        mineFields.placeMineAt(1, 20);
        mineFields.placeMineAt(10, 1);
        mineFields.placeMineAt(10, 20);

        assertEquals("*..................*\n" +
                ".****.*.*...........\n" +
                ".*.*..*..*.........*\n" +
                ".***...........*****\n" +
                "...................*\n" +
                ".***.***............\n" +
                ".*.*.*.*..........**\n" +
                ".***.***.........**.\n" +
                "................**..\n" +
                "*..............**..*\n", mineFields.getCell());

        mineFields.generateHints();

        assertEquals("*333221211........1*\n" +
                     "3****3*3*21.......22\n" +
                     "3*8*43*32*1...12334*\n" +
                     "2***2111111...1*****\n" +
                     "246432321.....12334*\n" +
                     "2***4***2........133\n" +
                     "3*8*6*8*3.......13**\n" +
                     "2***4***2......13**3\n" +
                     "233222321.....13**42\n" +
                     "*1............1**32*\n", mineFields.getCell());
    }

    @Test(expected = NullPointerException.class)
    public void negativePlaceMineAtNoField() {
        mineFields.placeMineAt(1,1);
    }

    @Test
    public void negativePlaceMineAtEmptyField1() {
        mineFields.drawCell(0, 0);
        try {
            mineFields.placeMineAt(1, 1);
        } catch (UnsupportedOperationException e) {
            assertEquals("It is not possible to place a mine at no field", e.getMessage());
        }
    }
}
