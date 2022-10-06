package basic.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(searchPosition(n, m, arr));
    }

    private static int searchPosition(int size, int target, int[] arr) {
        Arrays.sort(arr);
        int position = 0;

        int right = size - 1;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                position = mid + 1;
                break;
            }
            if (target < arr[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return position;
    }

}
