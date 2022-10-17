package basic.array;

import java.util.Scanner;

public class ScoreCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = sc.nextInt();
        }
        System.out.println(calculateScore(n, results));
    }

    private static int calculateScore(int n, int[] results) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (results[i] == 1) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }
}
