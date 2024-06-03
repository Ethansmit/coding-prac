package algorithms.easy_questions.best_time_buy_sell_stock;

class best_time_buy_sell_stock {
    public static int maxProfit(int[] prices) {
        // Store largest profit to be made from buying and selling once.
        int max_profit = 0;
        // The buying day. Used to calculate best time to sell.
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
        // Answer
        return max_profit;
    }

    public static void main(String[] args) {
        // Example 1, answer 0
        int[] prices1 = {7,6,4,3,1};
        System.out.print("Example 1: ");
        System.out.println(maxProfit(prices1));

        // Example 2, answer 5
        int[] prices2 = {7,1,5,3,6,4};
        System.out.print("Example 2: ");
        System.out.println(maxProfit(prices2));

        // Example 3, answer 8
        int[] prices3 = {1,9};
        System.out.print("Example 3: ");
        System.out.println(maxProfit(prices3));

        // Example 4, answer 7
        int[] prices4 = {5,4,2,9,1,7};
        System.out.print("Example 4: ");
        System.out.println(maxProfit(prices4));

        // Example 5, answer 1
        int[] prices5 = {0,0,0,0,0,0,0,0,1};
        System.out.print("Example 5: ");
        System.out.println(maxProfit(prices5));
    }
}