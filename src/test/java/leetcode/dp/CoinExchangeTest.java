package leetcode.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoinExchangeTest {

    @Test
    void solution1() {
        int[] coins = {1, 2, 5};
        assertThat(coinChange(coins, 11)).isEqualTo(3);
        assertThat(coinChange1(coins, 11)).isEqualTo(3);

    }

    /**
     * 반복문 사용
     * 37-40ms, 40%
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 재귀함수 사용
     * 40-50ms 50%
     */
    public int coinChange1(int[] coins, int amount) {
        Exchange exchange = new Exchange(coins, amount);
        int min = exchange.getMinimumCoin(amount);
        return min <= amount ? min : -1;
    }

    static class Exchange {
        int[] coins;
        int[] dp;

        public Exchange(int[] coins, int amount) {
            this.coins = coins;
            this.dp = new int[amount + 1];
        }

        public int getMinimumCoin(int amount) {
            if (amount < 0) {
                return Integer.MAX_VALUE - 1;
            }
            if (amount == 0) {
                return 0;
            }
            if (dp[amount] > 0) {
                return dp[amount];
            }
            int min = Integer.MAX_VALUE - 1;

            for (int i = 0; i < this.coins.length; i++) {
                min = Math.min(min, getMinimumCoin(amount - this.coins[i]) + 1);
            }
            return dp[amount] = min;
        }
    }

}