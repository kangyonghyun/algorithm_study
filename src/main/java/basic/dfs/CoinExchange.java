package basic.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amount = sc.nextInt();

        Integer[] newCoins = new Integer[n];
        for (int i = 0; i < n; i++) {
            newCoins[i] = coins[i];
        }
        Exchange exchange = new Exchange(newCoins, amount);
        exchange.getMinimumCoin(0, 0);
        System.out.println(exchange.minCountOfCoin);
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
