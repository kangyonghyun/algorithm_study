package basic.array;

import java.util.Scanner;

public class RankCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        for (int o : calculateRank(n, scores)) {
            System.out.print(o + " ");
        }
    }

    private static int[] calculateRank(int n, int[] scores) {
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
}
