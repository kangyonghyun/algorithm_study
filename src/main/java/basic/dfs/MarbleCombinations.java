package basic.dfs;

import java.util.Scanner;

public class MarbleCombinations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Combinations combinations = new Combinations(sc.nextInt(), sc.nextInt());
        combinations.getNumberOfCases(0, 1);
    }

    static class Combinations {
        int n;
        int m;
        int[] marbles;

        public Combinations(int n, int m) {
            this.n = n;
            this.m = m;
            this.marbles = new int[m];
        }

        public void getNumberOfCases(int L, int S) {
            if (L == this.m) {
                for (int marble : marbles) {
                    System.out.print(marble + " ");
                }
                System.out.println();
            } else {
                for (int i = S; i <= n; i++) {
                    marbles[L] = i;
                    getNumberOfCases(L + 1, i + 1);
                }
            }
        }
    }

}
