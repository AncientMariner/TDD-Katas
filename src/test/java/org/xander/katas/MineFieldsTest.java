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
    public void horizontalMembers() {
        drawEmptyCell();
        mineFields.placeMineAt(3, 2);
        assertEquals("........\n" + "........\n" + ".*......\n" + "........\n", mineFields.getCell());
        assertEquals("........\n" + ".1......\n" + "1*1.....\n" + "........\n", mineFields.generateHints());

    }

}
