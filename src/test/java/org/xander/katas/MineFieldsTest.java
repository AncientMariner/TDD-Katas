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
        assertEquals("........\n" + "........\n" + "........\n" + "........\n", drawEmptyCell());
    }

    @Test
    public void outputCellWithMineAtCertainPosition() {
        drawEmptyCell();

        assertEquals(".*......\n" + "........\n" + "........\n" + "........\n", mineFields.placeMineAt(1, 2));
    }

    private String drawEmptyCell() {
        int dimensionX = 8;
        int dimensionY = 4;
        return mineFields.drawCell(dimensionX, dimensionY);
    }
}
