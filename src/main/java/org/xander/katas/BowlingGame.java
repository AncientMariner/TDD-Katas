package org.xander.katas;

public class BowlingGame {
    private static final int NUMBER_OF_ROLLS = 21;
    private static int numberOfFrames = 10;

    private int[] rolls = new int[NUMBER_OF_ROLLS];
    private int currentRoll = 0;

    public void role(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int firstInFrame = 0;
        for (int frame = 0; frame < numberOfFrames; frame++) {
            if (isStrike(firstInFrame)) {
                score += 10 + newTwoBallsForStrike(firstInFrame);
                firstInFrame++;
            } else if (isSpare(firstInFrame)) {
                score += 10 + nextBallForSpare(firstInFrame);
                firstInFrame += 2;
            } else {
                score += twoBallsInFrame(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;
    }

    private int twoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private int nextBallForSpare(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private int newTwoBallsForStrike(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private boolean isStrike(int firstInFrame) {
        return rolls[firstInFrame] == 10;
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
    }
}
