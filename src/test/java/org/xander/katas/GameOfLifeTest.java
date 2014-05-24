package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

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

}
