package org.xander.katas;

import java.util.Arrays;

public class PrimeFactors {
    static boolean[] sieveOfEratosthenes = new boolean[1000];

    static {
        Arrays.fill(sieveOfEratosthenes, true);
        sieveOfEratosthenes[0] = sieveOfEratosthenes[1] = false;

        for (int i = 2; i < Math.sqrt(sieveOfEratosthenes.length); i++) {
            for (int j = 2; i * j < sieveOfEratosthenes.length; j++) {
                if (sieveOfEratosthenes[i * j]) {
                    sieveOfEratosthenes[i * j] = false;
                }
            }
        }
    }

    public int[] factorize(int inputNumber) {
        int originalNumber = inputNumber;
        int[] result = new int[(int) Math.sqrt((double) originalNumber + 1)];

        int counterOfFactors = 0;

        for (int i = 0; i < 1000 && i < originalNumber; i++) {
            if (sieveOfEratosthenes[i]) {
                if (inputNumber / i > 1 && inputNumber % i == 0) {
                    result[counterOfFactors++] = i;

                    if (inputNumber / i == i && inputNumber % i == 0) {
                        result[counterOfFactors++] = i;
                        break;
                    }
                    inputNumber = inputNumber / i;
                    i = 0;
                } else if (inputNumber / i == 1 && inputNumber % i == 0) {
                    result[counterOfFactors++] = i;
                    break;
                }
            }
        }
        return result;
    }
}
