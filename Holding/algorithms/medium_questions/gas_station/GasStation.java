package algorithms.medium_questions.gas_station;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalDiff = 0;
        int currentGas = 0;
        int startPos = 0;

        for (int i = 0; i < n; ++i) {
            totalDiff += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                startPos = i + 1;
            }
        }
        return (totalDiff < 0) ? -1 : startPos;
    }
}

class TestBestTimeBuySellStock {
    public static void runTests(int[][] testGas, int[][] testCost, int[] expectedResults) {
        GasStation solution = new GasStation();

        boolean correct = true;

        for (int i = 0; i < testGas.length; i++) {
            int[] gas = testGas[i];
            int[] cost = testCost[i];
            int expected = expectedResults[i];
            int result = solution.canCompleteCircuit(gas, cost);

            if (result != expected) {
                System.out.println("Test case " + (i + 1) + " failed!");
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
        int[][] testCaseGas = {
            {1, 2, 3, 4, 5},
            {2, 3, 4},
            {5},
            {4, 3, 2, 5},
            {2, 4, 3},
            {3, 2, 1, 1, 3, 2}
        };

        int[][] testCaseCost = {
            {3, 4, 5, 1, 2},
            {3, 4, 3},
            {4},
            {3, 4, 5, 1},
            {3, 3, 2},
            {4, 3, 2, 2, 4, 3}
        };

        int[] expectedResults = {3, -1, 0, 3, 1, -1};

        runTests(testCaseGas, testCaseCost, expectedResults);
    }
}