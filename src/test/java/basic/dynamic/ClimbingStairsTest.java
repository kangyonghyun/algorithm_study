package basic.dynamic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingStairsTest {

    /**
     * 다이나믹 프로그래밍 (동적 계획법)
     * 계단을 오를 수 있는 경우의 수
     * 계단을 오를 수 있는 경우의 수를 dp[] 배열에 저장
     * 전전 계단 경우의 수 + 전 계단 경우의 수
     */

    @Test
    void solution() {
        int n = 7;
        assertThat(getNumberOfCases(n)).isEqualTo(21);
    }

    private int getNumberOfCases(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}