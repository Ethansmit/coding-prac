package algorithms.easy_questions.best_time_buy_sell_stock;

class best_time_buy_sell_stock {
    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int start_day = 0;

        // Loop through prices.
        for (int i = 1; i < prices.length; i++) {
            // If the difference in prices between the current - start day is greater than max_profit,
            // then this is our new largest possible profit.
            if (prices[i] - prices[start_day] > max_profit) {
                max_profit = prices[i] - prices[start_day];
            } else if (prices[i] < prices[start_day]) { // Reflects new lowest price day.
                // Choose lowest price day to ensure maximum possible profit.
                start_day = i;
            }
        }

        return max_profit;
    }

    public static void main(String[] args) {
        // Example 1
        int[] prices1 = {7,6,4,3,1};
        System.out.print("Example 1: ");
        System.out.println(maxProfit(prices1));

        // Example 2
        int[] prices2 = {7,1,5,3,6,4};
        System.out.print("Example 2: ");
        System.out.println(maxProfit(prices2));
    }
}