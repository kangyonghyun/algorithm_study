package basic.dfs;

import java.util.Scanner;

public class SequenceGuess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sequence seq = new Sequence(sc.nextInt(), sc.nextInt());
        seq.guessSequence(0, 0);
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
                    for (int x : seq) {
                        System.out.print(x + " ");
                    }
                    this.flag = true;
                }
            } else {
                for (int i = 1; i <= this.N; i++) {
                    if (check[i] == 0 && !this.flag) {
                        check[i] = 1;
                        seq[L] = i;
                        guessSequence(L + 1, sum + seq[L] * combinations.combi[L]);
                        check[i] = 0;
                    }
                }
            }
        }
    }

    static class Combinations {
        int[][] memo = new int[35][35];
        int[] combi;

        public Combinations(int n) {
            this.combi = new int[n];
            for (int i = 0; i < n; i++) {
                this.combi[i] = setCombi(n - 1, i);
            }
        }

        private int setCombi(int n, int r) {
            if (memo[n][r] > 0) {
                return memo[n][r];
            }
            if (n == r || r == 0) {
                return 1;
            }
            return memo[n][r] = setCombi(n - 1, r - 1) + setCombi(n - 1, r);
        }
    }

}
