package leetcode.array;

public class BuyAndSellStock {
    public int getMaxProfit1(int[] prices) {
        int maxProfit = 0;
        int maxSell = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i > 0; i--) {
            int sell = prices[i];
            if (maxSell < sell) {
                maxSell = sell;
                for (int j = i - 1; j >= 0; j--) {
                    int buy = prices[j];
                    maxProfit = Math.max(maxProfit, sell - buy);
                }
            }
        }
        return maxProfit;
    }

    public int getMaxProfit2(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minBuyPrice = Math.min(price, minBuyPrice);
            maxProfit = Math.max(price - minBuyPrice, maxProfit);
        }
        return maxProfit;
    }
}
