package basic.dynamic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IncreasingSequenceTest {

    @Test
    void increasing() {
        int n = 8;
        int[] seq = {5, 3, 7, 8, 6, 2, 9, 4};
        assertThat(getMaxLength(seq)).isEqualTo(4);
    }

    private int getMaxLength(int[] seq) {
        int[] dp = new int[seq.length];
        dp[0] = 1;

        int result = 0;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0 ; j--) {
                if (seq[i] > seq[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}