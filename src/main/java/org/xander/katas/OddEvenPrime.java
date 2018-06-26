package org.xander.katas;

import java.util.Arrays;

public class OddEvenPrime {
    private static final int RANGE = 10000;
    private static boolean[] sieveOfEratosthenes = new boolean[RANGE];

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
//        printResultsForTest();
    }

    public String calculate(int number) {
        return (sieveOfEratosthenes[number]) ? number + " is prime"
                : (number % 2 == 0) ? "even"
                : "odd";
    }

//    private static void printResultsForTest() {
//        int primeCounter = 0;
//        System.out.print("{");
//        for (int a = 0; a < sieveOfEratosthenes.length; a++) {
//            if (sieveOfEratosthenes[a]) {
//                primeCounter++;
//                System.out.print(a + ", ");
//           }
//        }
//        System.out.print("}");
//
//       System.out.println("\n\nThere are " + primeCounter + " prime numbers in the range from \'0\' to \'" + range + "\'");
//    }
}
