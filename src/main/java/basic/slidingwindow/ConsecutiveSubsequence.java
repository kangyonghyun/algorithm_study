package basic.slidingwindow;

import java.util.Scanner;

public class ConsecutiveSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] subsequence = new int[n];
        for (int i = 0; i < n; i++) {
            subsequence[i] = sc.nextInt();
        }
        System.out.println(getCountOfTarget(n, target, subsequence));
    }

    private static int getCountOfTarget(int n, int target, int[] subsequence) {
        int count = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += subsequence[right];
            while (sum >= target) {
                if (sum == target) {
                    count++;
                }
                sum -= subsequence[left++];
            }
        }
        return count;
    }
}
