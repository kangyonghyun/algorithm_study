package basic.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankCalculationTest {

    @Test
    void solution() {
        assertThat(calculateRank(5, new int[]{87, 89, 92, 100, 76})).containsExactly(4, 3, 2, 1, 5);
        assertThat(calculateRank(5, new int[]{92,92,92,91,100})).containsExactly(2, 2, 2, 5, 1);
        assertThat(calculateRank(3, new int[]{100,100,92})).containsExactly(1, 1, 3);
        assertThat(calculateRank(4, new int[]{100,92,92,87})).containsExactly(1, 2, 2, 4);
    }

    private int[] calculateRank(int n, int[] scores) {
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            int rank = 1;
            int cur = scores[i];
            for (int j = 0; j < n; j++) {
                if (cur < scores[j]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        return ranks;
    }

    private int[] calculateRank1(int n, int[] scores) {
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            int rank = n + 1;
            int curScore = scores[i];
            for (int j = 0; j < n; j++) {
                if (curScore >= scores[j]) {
                    rank--;
                }
            }
            ranks[i] = rank;
        }
        return ranks;
    }

}