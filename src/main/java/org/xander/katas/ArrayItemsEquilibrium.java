package org.xander.katas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayItemsEquilibrium {

    public static final int ZERO = 0;

    public Set<Integer> calculateEquilibriumBruteForce(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return Collections.emptySet();
        }

        if (numbers.length >= 100_000) {
            return Collections.emptySet();
        }

        if (numbers.length == 1) {
            return new HashSet<Integer>() {{
                add(numbers[0]);
            }};
        }
        if (numbers.length == 2) {
            if (numbers[0] == numbers[1]) {
                return new HashSet<Integer>() {{
                    add(numbers[0]);
                    add(numbers[1]);
                }};
            } else {
                return new HashSet<Integer>() {{
                    Collections.emptySet();
                }};
            }
        }

        Set<Integer> equilibriums = new HashSet<>();


        for (int i = 0; i < numbers.length; i++) {
            int left = ZERO;
            int right = ZERO;

            for (int j = i - 1; j >= 0; j--) {
                left += numbers[j];
            }

            for (int j = i + 1; j < numbers.length; j++) {
                right += numbers[j];
            }

            if (left == right) {
                equilibriums.add(i);
            }
        }

        return equilibriums;
    }

    public Set<Integer> calculateEquilibriumFastSolution(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Collections.emptySet();
        }

        if (numbers.length >= 100_000) {
            return Collections.emptySet();
        }

        if (numbers.length == 1) {
            return new HashSet<Integer>() {{
                add(numbers[0]);
            }};
        }
        if (numbers.length == 2) {
            if (numbers[0] == numbers[1]) {
                return new HashSet<Integer>() {{
                    add(numbers[0]);
                    add(numbers[1]);
                }};
            } else {
                return new HashSet<Integer>() {{
                    Collections.emptySet();
                }};
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        Set<Integer> equilibriums = new HashSet<>();

        int sum_l = 0;
        int sum_r = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum_r = sum - sum_l - numbers[i];
            if (sum_l == sum_r) {
                equilibriums.add(i);
            }
            sum_l += numbers[i];
        }

        return equilibriums;
    }
}
