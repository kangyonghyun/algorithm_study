package basic.twopointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxLengthConsecutiveSubsequenceTest {

    @Test
    void solution() {
        int n = 14;
        int k = 2;
        int[] subsequence = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        assertThat(getMaxLengthOne(n, k, subsequence)).isEqualTo(8);
    }

    private int getMaxLengthOne(int n, int k, int[] subsequence) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (subsequence[right] == 0) {
                count++;
            }
            while (count > k) {
                if (subsequence[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}