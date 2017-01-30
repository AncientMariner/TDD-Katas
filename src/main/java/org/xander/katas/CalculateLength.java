package org.xander.katas;

public class CalculateLength {
    private static final int bigBrickLength = 5;
    private static final int littleBrickLength = 1;
    private boolean result;

    boolean measure(int totalLength, int bigBrickNumber, int littleBrickNumber) {
        if (totalLength <= 0) {
            return false;
        }
        if (bigBrickNumber == 0 && littleBrickNumber == 0) {
            return false;
        }


        if (bigBrickNumber == 0) {
            return oneOfNumbersIsZero(totalLength, littleBrickNumber, littleBrickLength);
        }

        if (littleBrickNumber == 0) {
            return oneOfNumbersIsZero(totalLength, bigBrickNumber, bigBrickLength);
        }

        if (totalLength > bigBrickNumber * bigBrickLength + littleBrickNumber * littleBrickLength) {
            result = false;
        } else if (totalLength == bigBrickNumber * bigBrickLength + littleBrickNumber * littleBrickLength) {
            result = true;
        } else {
            int leftOverForSmallBricks = calculateLeftOverForSmallBricks(totalLength, bigBrickNumber);

            if ((totalLength <= bigBrickNumber * bigBrickLength && totalLength >= littleBrickNumber * littleBrickLength)
               || (totalLength >= bigBrickNumber * bigBrickLength && totalLength >= littleBrickNumber * littleBrickLength)) {

                if (!result) {
                    if (leftOverForSmallBricks < littleBrickLength * littleBrickNumber) {
                        result = leftOverBricksCouldBeBuildFromExistingOnes(leftOverForSmallBricks);
                    } else result = leftOverForSmallBricks == littleBrickLength * littleBrickNumber;
                }
            }

            if ((totalLength <= bigBrickNumber * bigBrickLength && totalLength <= littleBrickNumber * littleBrickLength)
               || (totalLength >= bigBrickNumber * bigBrickLength && totalLength <= littleBrickNumber * littleBrickLength)) {

                if(!result){
                    result = leftOverBricksCouldBeBuildFromExistingOnes(leftOverForSmallBricks);
                }
            }
        }
        return result;
    }

    private int calculateLeftOverForSmallBricks(int totalLength, int bigBrickNumber) {
        int numberOfBricks = 0;
        if (totalLength % bigBrickLength == 0) {
            int requiredNumberOfBigBricks = totalLength / bigBrickLength;
            if (requiredNumberOfBigBricks == bigBrickNumber) {
                result = true;
            } else if (requiredNumberOfBigBricks < bigBrickNumber) {
                numberOfBricks = requiredNumberOfBigBricks;
            }
        } else {
            int leftOverOfBigBricks = totalLength % bigBrickLength;
            int numberOfBigBricksNeeded = (totalLength - leftOverOfBigBricks) / bigBrickLength;
            if (numberOfBigBricksNeeded <= bigBrickNumber) {
                numberOfBricks = numberOfBigBricksNeeded;
            }
        }
        return totalLength - numberOfBricks * bigBrickLength;
    }

    private boolean leftOverBricksCouldBeBuildFromExistingOnes(int leftOverForSmallBricks) {
        return leftOverForSmallBricks % littleBrickLength == 0;
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
