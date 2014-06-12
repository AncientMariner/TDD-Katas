package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowlingGame.role(pins);
        }
    }

    private void rollSpare() {
        bowlingGame.role(5);
        bowlingGame.role(5);
    }

    private void rollStrike() {
        bowlingGame.role(10);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    @Test
    public void oneSpare() {
        rollSpare();
        bowlingGame.role(3);

        rollMany(17, 0);

        assertEquals(10 + 3 + 3, bowlingGame.score());
    }

    @Test
    public void oneStrike() {
        rollStrike();
        bowlingGame.role(3);
        bowlingGame.role(4);

        rollMany(16, 0);

        assertEquals(10 + 7 + 7, bowlingGame.score());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, bowlingGame.score());

    }


}
