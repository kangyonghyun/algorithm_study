package basic.dfs;

import java.util.Scanner;

public class NumberOfCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        Combinations combinations = new Combinations();
        int result = combinations.getNumberOfCombinations(n, r);
        System.out.println(result);
    }

    static class Combinations {
        int[][] dy = new int[35][35];

        public int getNumberOfCombinations(int n, int r) {
            if (dy[n][r] > 0) {
                return dy[n][r];
            }
            if (n == r || r == 0) {
                return 1;
            } else {
                dy[n][r] = getNumberOfCombinations(n - 1, r - 1) + getNumberOfCombinations(n - 1, r);
                return dy[n][r];
            }
        }
    }
}
