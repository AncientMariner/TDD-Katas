package org.xander.katas;

public class Tennis {
    private int[] points = new int[4];
    private int score = points[0];

    Tennis() {
        points[0] = 0;
        points[1] = 15;
        points[2] = 30;
        points[3] = 40;
    }

    public int displayResult(int number) {
        switch (number) {
            case 0 : return 0;
            case 1 : return 15;
            case 2 : return 30;
            case 3 : return 40;
            default: return number;
        }
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

    public int[] getPoints() {
        int[] points = this.points;
        return points;
    }

    public int score(int times) {
//        if (times <= 3) {
//            for (int i = 0; i < points.length; i++) {
//                if (i == times) {
//                    score = times;
//                }
//            }
//        } else {
//            score = times;
//        }
        return displayResult(times);
    }

    public String compareResults(int firstPlayerResult, int secondPlayerResult) {
        int resultOfThe1st = transformResultIntoStrikes(firstPlayerResult);
        int resultOfThe2nd = transformResultIntoStrikes(secondPlayerResult);
        int result = 0;

        if (resultOfThe1st == resultOfThe2nd && resultOfThe1st == 3) {
            return "Deuce";
        }

        if (resultOfThe1st > resultOfThe2nd) {
            if (resultOfThe1st - resultOfThe2nd >= 2 && resultOfThe1st == 4) {
                return "first has won";
            }
        }

        if (resultOfThe2nd > resultOfThe1st) {
            if (resultOfThe2nd - resultOfThe1st >= 2 && resultOfThe2nd == 4) {
                return "second has won";
            }
        }

        if ((resultOfThe1st - resultOfThe2nd == 1 || resultOfThe2nd - resultOfThe1st == 1)
                && resultOfThe1st > 3 && resultOfThe2nd > 3) {
            return "game is in progress";
        }

        return displayResult(resultOfThe1st) + " - " + displayResult(resultOfThe2nd);
    }
}
