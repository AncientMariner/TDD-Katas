package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculateLengthTest {
    CalculateLength calculateLength;

    @Before
    public void setUp() {
        calculateLength = new CalculateLength();
    }

    @Test
    public void basic() {
        int totalLength = 11;
        int bigBrickNumber = 2;
        int littleBrickNumber = 1;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void lengthIsNotEnough() {
        int totalLength = 13;
        int bigBrickNumber = 2;
        int littleBrickNumber = 1;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertFalse("Length is not corresponding", isPossible);
    }

    @Test
    public void lengthIsMadeFromBigBricks() {
        int totalLength = 10;
        int bigBrickNumber = 2;
        int littleBrickNumber = 1;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void bigNumberIsBiggerLittleIsSmaller() {
        int totalLength = 11;
        int bigBrickNumber = 3;
        int littleBrickNumber = 1;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void bigNumberIsBiggerLittleIsBigger() {
        int totalLength = 6;
        int bigBrickNumber = 3;
        int littleBrickNumber = 7;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void bigNumberIsSmallerLittleIsSmaller() {
        int totalLength = 6;
        int bigBrickNumber = 1;
        int littleBrickNumber = 2;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void bigNumberIsSmallerLittleIsBigger() {
        int totalLength = 6;
        int bigBrickNumber = 1;
        int littleBrickNumber = 7;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void notPossibleToBuildFromBigNumber() {
        int totalLength = 9;
        int bigBrickNumber = 1;
        int littleBrickNumber = 10;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void totalLengthIsLessThanNumberOfBigBricksLittleNumberOfBricksIsLess() {
        int totalLength = 12;
        int bigBrickNumber = 3;
        int littleBrickNumber = 1;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertFalse("Length is not corresponding", isPossible);
    }

    @Test
    public void totalLengthIsLessThanBigNumberAndBiggerThanLittleBricks() {
        int totalLength = 11;
        int bigBrickNumber = 3;
        int littleBrickNumber = 3;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void totalLengthIsLessThanBigNumberAndBiggerThanLittleBricks2() {
        int totalLength = 11;
        int bigBrickNumber = 3;
        int littleBrickNumber = 2;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void totalIsLessThanBigNumberAndLessThanLittle() {
        int totalLength = 3;
        int bigBrickNumber = 1;
        int littleBrickNumber = 4;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }

    @Test
    public void totalLengthIsLessThanBigMoreThanSmall() {
        int totalLength = 15;
        int bigBrickNumber = 4;
        int littleBrickNumber = 4;

        boolean isPossible = calculateLength.measure(totalLength, bigBrickNumber, littleBrickNumber);
        assertTrue("Length is not corresponding", isPossible);
    }
    
    @Test
    public void totalIsZero() {
        assertFalse("Length is not zero", calculateLength.measure(0, 2, 1));
    }

    @Test
    public void bigBrickAndLittleBrickNumberIsZero() {
        assertFalse("Number of bricks is not zero", calculateLength.measure(1, 0, 0));
    }

    @Test
    public void bigBrickNumberIsZero() {
        assertTrue("Big brick number is not zero", calculateLength.measure(1, 0, 1));
    }

    @Test
    public void bigBrickNumberIsZeroLittleNumberIsLessThanNeeded() {
        assertFalse("Big brick number is not zero", calculateLength.measure(3, 0, 2));
    }

    @Test
    public void bigBrickNumberIsZeroLittleNumberIsMoreThanNeeded() {
        assertTrue("Big brick number is not zero", calculateLength.measure(2, 0, 3));
    }

    @Test
    public void littleBrickNumberIsZero() {
        assertTrue("Length is zero", calculateLength.measure(5, 1, 0));
    }

    @Test
    public void littleBrickNumberIsZeroBigNumberIsLessThanNeeded() {
        assertFalse("Length is not zero", calculateLength.measure(6, 1, 0));
    }
    @Test
    public void littleBrickNumberIsZeroBigNumberIsMoreThanNeeded() {
        assertTrue("Length is zero", calculateLength.measure(5, 2, 0));
    }

    @Test
    public void littleBrickNumberIsZeroBigNumberIsMoreThanNeeded234() {
        assertFalse("Length is zero", calculateLength.measure(11, 3, 0));
    }
}
