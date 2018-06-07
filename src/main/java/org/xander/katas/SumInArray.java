package org.xander.katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumInArray {
    public boolean checkBruteForce(int[] nums, int sum) {
        checkArray(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWithMap(int[] nums, int sum) {
        checkArray(nums);
        Map<Integer, Integer> numbers = new HashMap<>();
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            if (numbers.containsKey(nums[i])) {
//                System.out.println(nums[i] + ", " + numbers.get(nums[i]));
                found = true;
            } else {
                numbers.put(sum - nums[i], nums[i]);
            }
        }
        return found;
    }

    public boolean checkWithSet(int[] nums, int sum) {
        checkArray(nums);

        Arrays.sort(nums);
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            int foundIndex = Arrays.binarySearch(nums, sum - nums[i]);
            if (foundIndex > 0) {
//                System.out.println(nums[i] + ", " + nums[found]);
                found = true;
            }
        }
        return found;
    }

    private void checkArray(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("Array is null");
        }
        if (nums.length == 0 || nums.length == 1) {
            throw new IllegalStateException("Array length is not sufficient");
        }
    }
}
