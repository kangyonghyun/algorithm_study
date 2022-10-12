package basic.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveNaturalNumbersTest {

    @Test
    void solution() {
        int n = 15;
        assertThat(getNumberOfCases(n)).isEqualTo(3);
    }

    private int getNumberOfCases(int n) {
        int count = 0;
        int sum = 0;
        int left = 1;
        int size = n / 2 + 1;
        for (int right = 1; right <= size; right++) {
            sum += right;
            while (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= left++;
            }
        }
        return count;
    }

}