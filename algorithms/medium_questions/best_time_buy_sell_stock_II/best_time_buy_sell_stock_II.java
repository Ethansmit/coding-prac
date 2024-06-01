package algorithms.medium_questions.best_time_buy_sell_stock_II;

public class best_time_buy_sell_stock_II {
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            // If the next price is larger, than we buy the current price.
            if (prices[i] < prices[i + 1]) {
                // We then look for the optimal time to sell.
                int sell_price = i + 1;
                // Move through prices until the next price is less than. Set that price as our sell price
                // And add to profit.
                while (sell_price < prices.length - 1 && prices[sell_price] < prices[sell_price + 1]) {
                    sell_price++;
                }
                profit += prices[sell_price] - prices[i];
                // Set index of our sell price to our buy price.
                i = sell_price;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {7,1,5,3,6,4};
        System.out.print("Example 1: ");
        System.out.println(maxProfit(nums1));

        // Example 2
        int [] nums2 = {7,6,4,3,1};
        System.out.print("Example 2: ");
        System.out.println(maxProfit(nums2));
    }
}