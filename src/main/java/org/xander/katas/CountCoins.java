package org.xander.katas;

public class CountCoins {
    enum Coins {
        PENNY(1),
        NICKEL(5),
        DIME(10),
        QUARTER(25);

        private final int number;
        Coins(int number) {
            this.number = number;
        }
    };
    public String countOneCoin(int i) {
        String coin;
        switch (i) {
            case 1:
                coin = Coins.PENNY.toString().toLowerCase(); break;
            case 5:
                coin = Coins.NICKEL.toString().toLowerCase(); break;
            case 10:
                coin = Coins.DIME.toString().toLowerCase(); break;
            case 25:
                coin = Coins.QUARTER.toString().toLowerCase(); break;
            default:
                coin = "nothing";
        }
        return coin;
    }

    public String countCustomCoin(int number) {
        String result = "";

        //calculate only one type of coin per value
        for (Coins coin : Coins.values()) {
            if (number % coin.number == 0) {
                int numberOfCoins = number / coin.number;
                result += " " + numberOfCoins + " " + countOneCoin(coin.number);
            }
        }
        String resultFOrManyTypes = calculateManyTypesOfCoins(number, result);
        return resultFOrManyTypes;
    }

    private String calculateManyTypesOfCoins(int number, String result) {
        for (Coins coin : Coins.values()) {
            if (number % coin.number > 0 && number > coin.number) {
                int difference = number - (number % coin.number);
                int numberOfCoins = difference / coin.number;
                result += " " + numberOfCoins + " " + countOneCoin(coin.number) + " and";

               result += calculateOnlyOneTypeOfCoin(number % coin.number, "");
            }
        }
        return result;
    }

    private String calculateOnlyOneTypeOfCoin(int number, String result) {
        for (Coins coin : Coins.values()) {
            if (number % coin.number == 0) {
                int numberOfCoins = number / coin.number;
                result += " " + numberOfCoins + " " + countOneCoin(coin.number) + " or";
            }
        }
        return result;
    }
}
