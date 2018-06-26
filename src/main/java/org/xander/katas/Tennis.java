package org.xander.katas;

public class Tennis {
    private int[] points;

    Tennis() {
        points = new int[4];
        points[0] = 0;
        points[1] = 15;
        points[2] = 30;
        points[3] = 40;
    }

    public int[] getPoints() {
        int[] points = this.points;
        return points;
    }

    private int transformResultIntoStrikes(int number) {
        switch (number) {
            case 0 : return 0;
            case 15 : return 1;
            case 30 : return 2;
            case 40 : return 3;
            default: return number;
        }
    }

    public int displayResult(int times) {
        switch (times) {
            case 0 : return 0;
            case 1 : return 15;
            case 2 : return 30;
            case 3 : return 40;
            default: return times;
        }
    }

    public String compareResults(int firstPlayerResult, int secondPlayerResult) {
        int resultOfThe1st = transformResultIntoStrikes(firstPlayerResult);
        int resultOfThe2nd = transformResultIntoStrikes(secondPlayerResult);

        int pointsDifference1st2nd = resultOfThe1st - resultOfThe2nd;
        int pointsDifference2nd1st = resultOfThe2nd - resultOfThe1st;

        if (resultOfThe1st == resultOfThe2nd && resultOfThe1st == 3) {
            return "Deuce";
        }

        if (resultOfThe1st > resultOfThe2nd) {
            if (winCondition(resultOfThe1st, pointsDifference1st2nd)) {
                return "first has won";
            }
        }

        if (resultOfThe2nd > resultOfThe1st) {
            if (winCondition(resultOfThe2nd, pointsDifference2nd1st)) {
                return "second has won";
            }
        }

        if ((pointsDifference1st2nd == 1 || pointsDifference2nd1st == 1)
                && resultOfThe1st > 3 && resultOfThe2nd > 3) {
            return "game is in progress";
        }

        return displayResult(resultOfThe1st) + " - " + displayResult(resultOfThe2nd);
    }

    private boolean winCondition(int resultOfThePlayer, int pointsDifference) {
        if (pointsDifference >= 2 && resultOfThePlayer >= 4) {
            return true;
        }
        return false;
    }
}
