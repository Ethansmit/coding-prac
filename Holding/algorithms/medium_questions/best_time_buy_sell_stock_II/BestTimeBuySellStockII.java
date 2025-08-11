package algorithms.medium_questions.best_time_buy_sell_stock_II;

public class BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            // If the next price is larger, than we buy the current price.
            if (prices[i] < prices[i + 1]) {
                // We then look for the optimal time to sell.
                int sell_price = i + 1;
                
                while (sell_price < prices.length - 1 && prices[sell_price] < prices[sell_price + 1]) {
                    sell_price++;
                }
                profit += prices[sell_price] - prices[i];
                
                i = sell_price;
            }
        }

        return profit;
    }
}

class TestBestTimeBuySellStockII {
    public static void runTests(int[][] testCases,  int[] expectedResults) {
        BestTimeBuySellStockII solution = new BestTimeBuySellStockII();

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
        }
        if (correct) {
            System.out.println("All test cases passed.");
        }
    }
    public static void main(String[] args) {
        int[][] testCases = {
            {7, 1, 5, 3, 6, 4},
            {7, 6, 4, 3, 1},
            {0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 10},
            {3, 2, 9, 1, 5, 8, 0},
            {0},
            {1, 10, 2, 5, 9, 4, 13},
            {1, 2, 3, 4, 5}
        };
        
        int[] expectedResults = {7, 0, 1, 0, 10, 14, 0, 25, 4};

        runTests(testCases, expectedResults);
    }
}