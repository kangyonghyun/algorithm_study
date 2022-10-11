package basic.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProfitTest {

    @Test
    void solution() {
        int n = 10;
        int k = 3;
        int[] sales = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        assertThat(getMaxProfit(n, k, sales)).isEqualTo(56);
    }

    /**
     * sliding window
     * O(N)
     */
    private int getMaxProfit(int n, int day, int[] sales) {
        int sum = 0;
        for (int i = 0; i < day; i++) {
            sum += sales[i];
        }
        int max = sum;
        int left = 0;
        for (int right = day; right < n; right++) {
            sum = - sales[left++] + sum + sales[right];
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 이중 for 문
     * O(N2)
     */
    private int getMaxProfit1(int n, int day, int[] sales) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - day; i++) {
            int sum = 0;
            for (int j = i; j < day + i; j++) {
                sum += sales[j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

}