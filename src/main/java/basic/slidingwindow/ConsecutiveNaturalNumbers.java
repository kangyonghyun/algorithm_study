package basic.slidingwindow;

import java.util.Scanner;

public class ConsecutiveNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNumberOfCases(n));
    }

    private static int getNumberOfCases(int n) {
        int count = 0;
        int sum = 0;
        int left = 1;
        int size = n / 2 + 1;
        for (int right = 1; right <= size; right++) {
            sum += right;
            while (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= left++;
            }
        }
        return count;
    }
}
