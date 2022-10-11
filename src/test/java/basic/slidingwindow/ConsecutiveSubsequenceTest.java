package basic.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveSubsequenceTest {

    @Test
    void solution() {
        int n = 8;
        int target = 6;
        int[] subsequence = {1, 2, 1, 3, 1, 1, 1, 2};
        assertThat(getCountOfTarget(n, target, subsequence)).isEqualTo(3);
    }

    private int getCountOfTarget(int n, int target, int[] subsequence) {
        int count = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += subsequence[right];
            while (sum >= target) {
                if (sum == target) {
                    count++;
                }
                sum -= subsequence[left++];
            }
        }
        return count;
    }

}