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
    }

    public String countOneCoin(int i) {
        String coin;
        switch (i) {
            case 1: coin = Coins.PENNY.toString().toLowerCase(); break;
            case 5: coin = Coins.NICKEL.toString().toLowerCase(); break;
            case 10: coin = Coins.DIME.toString().toLowerCase(); break;
            case 25: coin = Coins.QUARTER.toString().toLowerCase(); break;
            default: coin = "nothing";
        }
        return coin;
    }

    public String countCustomCoin(int number) {
        String result = calculateResultForSingleTypeOfCoin(number);
        String additonalCombinations = calculateManyTypesOfCoins(number, result);
        return additonalCombinations;
    }

    private String calculateResultForSingleTypeOfCoin(int number) {
        String result = "";
        for (Coins coin : Coins.values()) {
            if (number % coin.number == 0) {
                int numberOfCoins = number / coin.number;
                result += " " + numberOfCoins + "_" + countOneCoin(coin.number);
            }
        }
        return result;
    }

    private String calculateManyTypesOfCoins(int number, String result) {
        for (Coins coinOuter : Coins.values()) {
            for (Coins coinInner : Coins.values()) {
//              if (coinInner.number != coinOuter.number)
                String nameOfCoin = countOneCoin(coinOuter.number);
                String numberWithName = "" + ((number - coinInner.number) / coinOuter.number);

                if (number % coinOuter.number == coinInner.number) {
                    result += " " + calculateOnlyOneTypeOfCoin(number - coinOuter.number, numberWithName, nameOfCoin);
                }

                if ((number - coinInner.number) / coinOuter.number > 0 && !"penny".equals(countOneCoin(coinInner.number))) {
                    result += " " + calculateOnlyOneTypeOfCoin(coinInner.number, numberWithName, nameOfCoin);
                }
            }
        }
    return result;
}

    private String calculateOnlyOneTypeOfCoin(int number, String numberWithName, String nameOfCoin) {
        String result = "";
        for (Coins coin : Coins.values()) {
            if (number % coin.number == 0 && !nameOfCoin.equals(countOneCoin(coin.number))) {
                int numberOfCoins = number / coin.number;
                result += numberWithName + "_" + nameOfCoin + " and " + numberOfCoins + "_" + countOneCoin(coin.number) + " ";
            }
        }
        return result;
    }
}
