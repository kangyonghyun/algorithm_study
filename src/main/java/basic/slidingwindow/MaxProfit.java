package basic.slidingwindow;

import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }
        System.out.println(getMaxProfit(n, k, sales));
    }

    private static int getMaxProfit(int n, int day, int[] sales) {
        int sum = 0;
        for (int i = 0; i < day; i++) {
            sum += sales[i];
        }
        int max = sum;
        int left = 0;
        for (int right = day; right < n; right++) {
            sum = - sales[left++] + sum + sales[right];
            max = Math.max(max, sum);
        }
        return max;
    }

}
