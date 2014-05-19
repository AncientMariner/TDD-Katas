package org.xander.katas;

public class CountCoins {

    enum Coins {
        QUARTER(25),
        DIME(10),
        NICKEL(5),
        PENNY(1);

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
}
