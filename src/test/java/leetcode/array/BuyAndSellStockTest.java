package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuyAndSellStockTest {

    @Test
    void solution() {
        int[] prices = {7,1,5,3,6,4};
        int profit = getMaxProfit(prices);
        assertThat(profit).isEqualTo(5);
    }

    private int getMaxProfit(int[] prices) {
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

}