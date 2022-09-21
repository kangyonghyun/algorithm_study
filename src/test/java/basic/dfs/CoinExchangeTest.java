package basic.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class CoinExchangeTest {

    @Test
    void solution() {
        Integer[] coins = {1, 2, 5};
        Exchange exchange = new Exchange(coins, 15);
        exchange.getMinimumCoin(0, 0);
        Assertions.assertThat(exchange.minCountOfCoin).isEqualTo(3);
    }

    static class Exchange {
        Integer[] coins;
        int target;
        int minCountOfCoin;

        public Exchange(Integer[] coins, int target) {
            this.coins = coins;
            Arrays.sort(coins, Collections.reverseOrder());
            this.target = target;
            this.minCountOfCoin = Integer.MAX_VALUE;
        }

        public void getMinimumCoin(int L, int sum) {
            if (this.minCountOfCoin <= L) {
                return;
            }
            if (this.target < sum) {
                return;
            }
            if (this.target == sum) {
                this.minCountOfCoin = Math.min(this.minCountOfCoin, L);
            } else {
                for (int i = 0; i < coins.length; i++) {
                    getMinimumCoin(L + 1, sum + coins[i]);
                }
            }
        }
    }

}