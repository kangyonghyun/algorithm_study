package basic.dynamic;

import java.util.Scanner;

public class IncreasingSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seq = new int[sc.nextInt()];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = sc.nextInt();
        }
        IncreasingSequence increasingSequence = new IncreasingSequence();

        System.out.println(increasingSequence.getMaxLength(seq));
    }

    private int getMaxLength(int[] seq) {
        int[] dp = new int[seq.length];
        dp[0] = 1;

        int result = 0;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0 ; j--) {
                if (seq[i] > seq[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
