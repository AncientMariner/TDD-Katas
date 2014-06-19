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

    private String drawEmptyCell() {
        int dimensionX = 8;
        int dimensionY = 4;
        return mineFields.drawCell(dimensionX, dimensionY);
    }

    @Test
    public void emptyCell() {
        assertEquals("........\n" + "........\n" + "........\n" + "........\n", drawEmptyCell());
    }

    @Test
    public void outputCellWithMineAtCertainPosition() {
        drawEmptyCell();
        mineFields.placeMineAt(1, 2);
        assertEquals(".*......\n" + "........\n" + "........\n" + "........\n", mineFields.getCell());
    }

    @Test
    public void horizontalAndVerticalMembers() {
        drawEmptyCell();
        mineFields.placeMineAt(3, 2);
        assertEquals("........\n" + "........\n" + ".*......\n" + "........\n", mineFields.getCell());

        mineFields.generateHints();
        assertEquals("........\n" + "111.....\n" + "1*1.....\n" + "111.....\n", mineFields.getCell());

        mineFields.placeMineAt(3, 6);
        assertEquals("........\n" + "111.....\n" + "1*1..*..\n" + "111.....\n", mineFields.getCell());
        mineFields.generateHints();

        assertEquals("........\n" + "111.111.\n" + "1*1.1*1.\n" + "111.111.\n", mineFields.getCell());
    }

    @Test
    public void diagonalMembers() {
        drawEmptyCell();
        mineFields.placeMineAt(3, 2);
        assertEquals("........\n" + "........\n" + ".*......\n" + "........\n", mineFields.getCell());

        mineFields.generateHints();
        assertEquals("........\n" + "111.....\n" + "1*1.....\n" + "111.....\n", mineFields.getCell());
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
            assertEquals("It is not possible to place mine at no field", e.getMessage());
        }
    }

}
