package algorithms.medium_questions.cont_subarray_sum;

import java.util.HashMap;

public class ContSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store sum % k.
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);
        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int mod = cumulativeSum % k;

            // Mod is not negative.
            if (mod < 0) {
                mod += k;
            }

            // Check is seen twice and size is greater than two.
            if (modMap.containsKey(mod)) {
                if (i - modMap.get(mod) > 1) {
                    return true;
                }
            } else {
                modMap.put(mod, i);
            }
        }

        return false;
    }
}

class TestContSubarraySum {
    public static void runTests(int[][] testCases, int[] kVals,  boolean[] expectedResults) {
        ContSubarraySum solution = new ContSubarraySum();

        boolean correct = true;

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int k = kVals[i];
            boolean expected = expectedResults[i];
            boolean result = solution.checkSubarraySum(testCase, k);

            if (result != expected) {
                System.out.println("Test case " + (i + 1) + " failed!");
                System.out.println("Input: \"" + testCase + "\"");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
                correct = false;
            }
        }
        if (correct) {
            System.out.println("All test cases passed.");
        }
    }
    public static void main(String[] args) {
        int[][] testCases = {
            {23, 2, 4, 6, 7},
            {23, 2, 6, 4, 7},
            {5, 0, 0, 0},
            {23, 2, 4, 6, 7},
            {0, 0},
            {1, 1},
            {23,2,6,4,7}
        };
        
        int[] kVals = {6, 13, 3, 1, 1, 2, 6};

        boolean[] expectedResults = {true, false, true, true, true, true, true};

        runTests(testCases, kVals, expectedResults);
    }
}