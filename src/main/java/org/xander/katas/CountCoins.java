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

    public String countOneCoin(int number) {
        String coin;
        switch (number) {
            case 1: coin = Coins.PENNY.toString().toLowerCase(); break;
            case 5: coin = Coins.NICKEL.toString().toLowerCase(); break;
            case 10: coin = Coins.DIME.toString().toLowerCase(); break;
            case 25: coin = Coins.QUARTER.toString().toLowerCase(); break;
            default: coin = "nothing";
        }
        return coin;
    }

    public String countCustomCoin(int number) {
        String resultForSingleCoin = calculateResultForSingleTypeOfCoin(number);
        String resultForCoinCombinations = calculateManyTypesOfCoins(number);
        return resultForSingleCoin + resultForCoinCombinations;
    }

    private String calculateResultForSingleTypeOfCoin(int number) {
        StringBuilder result = new StringBuilder();
        for (Coins coin : Coins.values()) {
            if (number % coin.number == 0) {
                int numberOfCoins = number / coin.number;
                result.append(" " + numberOfCoins + "_" + countOneCoin(coin.number));
                //test generation
//                result += " assertThat(true, is(name.contains(\"" + numberOfCoins + "_" + countOneCoin(coin.number) + "\")));\n";

            }
        }
        return result.toString();
    }

    private String calculateManyTypesOfCoins(int incomingNumber) {
        StringBuilder result = new StringBuilder();
        for (Coins existingCoin : Coins.values()) {
            int numberOfCoins = incomingNumber / existingCoin.number;
            for (int currentCoin = 1; currentCoin <= numberOfCoins; currentCoin++) {
                int additionalValueToCalculate = incomingNumber - existingCoin.number * currentCoin;
                result.append(calculateOnlyOneTypeOfCoin(additionalValueToCalculate,
                        String.valueOf(currentCoin),
                        existingCoin.toString().toLowerCase()));
            }
        }
        return result.toString();
    }

    private String calculateOnlyOneTypeOfCoin(int additionalValueToCalculate, String incomingNumberOfCoins, String nameOfCoin) {
        StringBuilder result = new StringBuilder();
        for (Coins coin : Coins.values()) {
            if (additionalValueToCalculate % coin.number == 0 && !nameOfCoin.equals(countOneCoin(coin.number))) {
                int numberOfCoinsForCurrentCoin = additionalValueToCalculate / coin.number;
                if (numberOfCoinsForCurrentCoin != 0) {
                    result.append(incomingNumberOfCoins + "_" + nameOfCoin + " and " + numberOfCoinsForCurrentCoin + "_" + countOneCoin(coin.number) + " ");
                    //test generation
//                    result += " assertThat(true, is(name.contains(\"" + incomingNumberOfCoins + "_" + nameOfCoin + " and " + numberOfCoinsForCurrentCoin + "_" + countOneCoin(coin.number) + "\")));\n ";
                }
            }
        }
        if (result.toString().isEmpty()) {
            return "";
        }
        return " " + result.toString();
    }
}
