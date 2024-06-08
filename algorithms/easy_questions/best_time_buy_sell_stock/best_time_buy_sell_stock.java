package algorithms.easy_questions.best_time_buy_sell_stock;

class best_time_buy_sell_stock {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int start_day = 0;

        for (int i = 1; i < prices.length; i++) {
            // If the difference in prices between the current - start day is greater than max_profit,
            // then this is our new largest possible profit.
            if (prices[i] - prices[start_day] > max_profit) {
                max_profit = prices[i] - prices[start_day];
            } else if (prices[i] < prices[start_day]) { 
                // Choose lowest price day to ensure maximum possible profit.
                start_day = i;
            }
        }
        // Answer
        return max_profit;
    }
}

class TestBestTimeBuySellStock {
    public static void runTests(int[][] testCases, int[] expectedResults) {
        best_time_buy_sell_stock solution = new best_time_buy_sell_stock();

        boolean correct = true;

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            int expected = expectedResults[i];
            int result = solution.maxProfit(testCase);

            if (result != expected) {
                System.out.println("Test case " + (i + 1) + " failed!");
                System.out.println("Input: \"" + testCase + "\"");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
                correct = false;
            }
            //System.out.println("Test case " + (i + 1) + ": " + (actual == expected));
        }
        if (correct) {
            System.out.println("All test cases passed.");
        }
    }
    public static void main(String[] args) {
        int[][] testCases = {
            {7, 6, 4, 3, 1},
            {7, 1, 5, 3, 6, 4},
            {5},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {1, 100, 2, 200},
            {0,0,0,0,0,0,0,0,0,0,1}
        };

        int[] expectedResults = {0, 5, 0, 4, 0, 199, 1};

        runTests(testCases, expectedResults);
    }
}