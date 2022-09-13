package leetcode.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BuyAndSellStockTest {

    @ParameterizedTest
    @MethodSource("providePricesForMaxProfit")
    void solution(int[] prices, int expected) {
        checkMethod(prices, expected);
    }
    
    private void checkMethod(int[] prices, int expected) {
        assertThat(getMaxProfit1(prices)).isEqualTo(expected);
        assertThat(getMaxProfit2(prices)).isEqualTo(expected);
    }

    private static Stream<Arguments> providePricesForMaxProfit() {
        return Stream.of(
                Arguments.of(new int[]{7,1,5,3,6,4}, 5),
                Arguments.of(new int[]{7,6,4,3,1}, 0)
        );
    }

    /**
     * 이중 for 문
     * O(n2)
     * 50 - 90ms, 6% 이하
     */
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

    /**
     * O(n)
     * 1 - 7ms, 100% - 7%
     */
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