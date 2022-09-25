package basic.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SequenceGuessTest {

    @Test
    void solution() {
        Sequence seq = new Sequence(4, 16);
        seq.guessSequence(0, 0);
        assertThat(seq.seq).containsExactly(3, 1, 2, 4);
    }
    static class Sequence {
        int N;
        int[] seq;
        int F;
        int[] check;
        boolean flag;
        Combinations combinations;
        public Sequence(int N, int F) {
            this.N = N;
            this.seq = new int[N];
            this.F = F;
            this.check = new int[N + 1];
            this.combinations = new Combinations(N);
        }
        public void guessSequence(int L, int sum) {
            if (this.flag) return;
            if (L == this.N) {
                if (sum == this.F) {
                    this.flag = true;
                }
            } else {
                for (int i = 1; i <= this.N; i++) {
                    if (check[i] == 0 && !this.flag) {
                        check[i] = 1;
                        seq[L] = i;
                        guessSequence(L + 1, sum + seq[L] * combinations.combination[L]);
                        check[i] = 0;
                    }
                }
            }
        }
    }

    static class Combinations {
        int[][] memo = new int[35][35];
        int[] combination;

        public Combinations(int n) {
            this.combination = new int[n];
            for (int i = 0; i < n; i++) {
                this.combination[i] = setCombination(n - 1, i);
            }
        }

        private int setCombination(int n, int r) {
            if (memo[n][r] > 0) {
                return memo[n][r];
            }
            if (n == r || r == 0) {
                return 1;
            }
            return memo[n][r] = setCombination(n - 1, r - 1) + setCombination(n - 1, r);
        }
    }


}