package basic.twopointers;

import java.util.Scanner;

public class MaxLengthConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }
        System.out.println(getMaxLengthOne(n, k, seq));
    }

    private static int getMaxLengthOne(int n, int k, int[] seq) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (seq[right] == 0) {
                count++;
            }

            while (count > k) {
                if (seq[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
