package basic.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfCombinationsTest {
    @Test
    void solution() {
        Combinations combinations = new Combinations();
        assertThat(combinations.getNumberOfCombination(5, 3)).isEqualTo(10);
        assertThat(combinations.getNumberOfCombination(33, 19)).isEqualTo(818809200);
    }

    static class Combinations {
        int[][] dy = new int[35][35];
        
        public int getNumberOfCombination(int n, int r) {
            if (dy[n][r] > 0) {
                return dy[n][r];
            }
            if (n == r || r == 0) {
                return 1;
            } else {
                return dy[n][r] = getNumberOfCombination(n - 1, r - 1) + getNumberOfCombination(n - 1, r);
            }
        }
    }

}