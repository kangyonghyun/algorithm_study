package basic.dynamic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingStairsTest {

    @ParameterizedTest
    @CsvSource({"2,2", "3, 3"})
    void 반복문(int n, int expected) {
        assertThat(climbStairs(n)).isEqualTo(expected);
    }

    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Time Limit Exceeded
    @ParameterizedTest
    @CsvSource({"2,2", "3, 3"})
    void 재귀문(int n, int expected) {
        assertThat(climbStairsRec(n)).isEqualTo(expected);
    }

    private int climbStairsRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }


    // 2s 661ms
    @Test
    void 큰수_재귀() {
        assertThat(climbStairsRec(45)).isEqualTo(1836311903);
    }

    // 102ms
    @Test
    void 큰수_반복() {
        assertThat(climbStairs(45)).isEqualTo(1836311903);
    }

}