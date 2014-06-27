package org.xander.katas;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TennisTest {
    Tennis tennis;

    @Before
    public void setUp() {
        tennis = new Tennis();
    }

    @Test
    public void basic() {
        assertNotNull(tennis);
    }

    @Test
    public void pointsPresent() {
        assertEquals(0, tennis.getPoints()[0]);
        assertEquals(15, tennis.getPoints()[1]);
        assertEquals(30, tennis.getPoints()[2]);
        assertEquals(40, tennis.getPoints()[3]);
    }

    @Test
    public void onePlayerScore() {
        Tennis firstPlayer = tennis;
        int times = 1;
        int result = firstPlayer.score(times);
        assertEquals(15, result);

        int times1 = 2;
        int result1 = firstPlayer.score(times1);
        assertEquals(30, result1);

        int times2 = 3;
        int result2 = firstPlayer.score(times2);
        assertEquals(40, result2);
    }

    @Test
    public void twoPlayersScore15() {
        Tennis firstPlayer = tennis;
        int times = 1;
        int result1 = firstPlayer.score(times);
        assertEquals(15, result1);

        Tennis secondPlayer = tennis;
        int result2 = secondPlayer.score(times);
        assertEquals(15, result2);

        assertEquals("15 - 15", tennis.compareResults(result1, result2));
    }

    @Test
    public void twoPlayersScore30() {
        Tennis firstPlayer = tennis;
        int times = 2;
        int result1 = firstPlayer.score(times);
        assertEquals(30, result1);

        Tennis secondPlayer = tennis;
        int result2 = secondPlayer.score(times);
        assertEquals(30, result2);

        assertEquals("30 - 30", tennis.compareResults(result1, result2));
    }

    @Test
    public void twoPlayersScoreDeuce() {
        Tennis firstPlayer = tennis;
        int times = 3;
        int result1 = firstPlayer.score(times);
        assertEquals(40, result1);

        Tennis secondPlayer = tennis;
        int result2 = secondPlayer.score(times);
        assertEquals(40, result2);

        assertEquals("Deuce", tennis.compareResults(result1, result2));
    }

    @Test
    public void twoPlayersScoreDifferently() {
        Tennis firstPlayer = tennis;
        int times1 = 0;
        int result1 = firstPlayer.score(times1);
        assertEquals(0, result1);

        Tennis secondPlayer = tennis;
        int times2 = 2;
        int result2 = secondPlayer.score(times2);
        assertEquals(30, result2);

        assertEquals("0 - 30", tennis.compareResults(result1, result2));
    }

    @Test
    public void gameIsWonBy1() {
        Tennis firstPlayer = tennis;
        int times1 = 4;
        int result1 = firstPlayer.score(times1);
//        assertEquals(4, result1);

        Tennis secondPlayer = tennis;
        int times2 = 0;
        int result2 = secondPlayer.score(times2);

        assertEquals(0, result2);
        assertEquals("first has won", tennis.compareResults(result1, result2));
    }


    @Test
    public void gameIsWonBy2() {
        Tennis firstPlayer = tennis;
        int times1 = 0;
        int result1 = firstPlayer.score(times1);
        assertEquals(0, result1);

        Tennis secondPlayer = tennis;
        int times2 = 4;
        int result2 = secondPlayer.score(times2);

        assertEquals(4, result2);
        assertEquals("second has won", tennis.compareResults(result1, result2));
    }

    @Test
    public void gameIsNotWon() {
        Tennis firstPlayer = tennis;
        int times1 = 2;
        int result1 = firstPlayer.score(times1);
        assertEquals(30, result1);

        Tennis secondPlayer = tennis;
        int times2 = 3;
        int result2 = secondPlayer.score(times2);
        assertEquals(40, result2);
        assertEquals("30 - 40", tennis.compareResults(result1, result2));
    }

    @Ignore
    @Test
    public void gameIsWonInManyStrikes() {
        Tennis firstPlayer = tennis;
        int times1 = 6;
        int result1 = firstPlayer.score(times1);
//        assertEquals(30, result1);

        Tennis secondPlayer = tennis;
        int times2 = 7;
        int result2 = secondPlayer.score(times2);
//        assertEquals(40, result2);
        assertEquals("second has won", tennis.compareResults(result1, result2));
    }


}

