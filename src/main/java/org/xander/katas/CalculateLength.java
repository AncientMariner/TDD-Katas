package org.xander.katas;

public class CalculateLength {
    //    private static final int bigBrick = 5;
//    private static final int littleBrick = 1;
    private int littleBrick;
    private int bigBrick;
    private boolean result;

    public CalculateLength(int bigBrick, int littleBrick) {
        this.bigBrick = bigBrick; 
        this.littleBrick = littleBrick; 
    }

    boolean measure(int totalLength, int bigBrickNumber, int littleBrickNumber) {
        if (totalLength <= 0) {
            return false;
        }
        if (bigBrickNumber == 0 && littleBrickNumber == 0) {
            return false;
        }

        if (bigBrickNumber == 0) {
            return oneOfNumbersIsZero(totalLength, littleBrickNumber, littleBrick);
        }

        if (littleBrickNumber == 0) {
            return oneOfNumbersIsZero(totalLength, bigBrickNumber, bigBrick);
        }

        if (totalLength > bigBrickNumber * bigBrick + littleBrickNumber * littleBrick) {
            result = false;
        } else if (totalLength == bigBrickNumber * bigBrick + littleBrickNumber * littleBrick) {
            result = true;
        } else {
            int leftOverForSmallBricks = calculateLeftOverForSmallBricks(totalLength, bigBrickNumber);

            if ((totalLength <= bigBrickNumber * bigBrick && totalLength >= littleBrickNumber * littleBrick)
               || (totalLength >= bigBrickNumber * bigBrick && totalLength >= littleBrickNumber * littleBrick)) {

                if (!result) {
                    if (leftOverForSmallBricks < littleBrick * littleBrickNumber) {
                        result = leftOverBricksCouldBeBuildFromExistingOnes(leftOverForSmallBricks);
                    } else {
                        result = leftOverForSmallBricks == littleBrick * littleBrickNumber;
                    }
                }
            }

            if ((totalLength <= bigBrickNumber * bigBrick && totalLength <= littleBrickNumber * littleBrick)
               || (totalLength >= bigBrickNumber * bigBrick && totalLength <= littleBrickNumber * littleBrick)) {

                if (!result) {
                    result = leftOverBricksCouldBeBuildFromExistingOnes(leftOverForSmallBricks);
                }
            }
        }
        return result;
    }

    private int calculateLeftOverForSmallBricks(int totalLength, int bigBrickNumber) {
        int numberOfBricks = 0;
        if (totalLength % bigBrick == 0) {
            int requiredNumberOfBigBricks = totalLength / bigBrick;
            if (requiredNumberOfBigBricks == bigBrickNumber) {
                result = true;
            } else if (requiredNumberOfBigBricks < bigBrickNumber) {
                numberOfBricks = requiredNumberOfBigBricks;
            }
        } else {
            int leftOverOfBigBricks = totalLength % bigBrick;
            int numberOfBigBricksNeeded = (totalLength - leftOverOfBigBricks) / bigBrick;
            if (numberOfBigBricksNeeded <= bigBrickNumber) {
                numberOfBricks = numberOfBigBricksNeeded;
            }
        }
        return totalLength - numberOfBricks * bigBrick;
    }

    private boolean leftOverBricksCouldBeBuildFromExistingOnes(int leftOverForSmallBricks) {
        return leftOverForSmallBricks % littleBrick == 0;
    }

    private Boolean oneOfNumbersIsZero(int totalLength, int brickNumber, int brickLength) {
        if (totalLength == brickNumber * brickLength) {
            return true;
        }
        if (totalLength > brickNumber * brickLength) {
            return false;
        }

        if (totalLength < brickNumber * brickLength) {
            int leftOverOfBricks = brickNumber * brickLength - totalLength;
            if (totalLength % brickLength == 0) {
                int requiredNumber = totalLength / brickLength;
                if (requiredNumber <= brickNumber) {
                    return true;
                }
            }
        }
        return false;
    }
}
