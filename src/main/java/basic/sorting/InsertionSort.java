package basic.sorting;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sort = sort(n, arr);
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }

    public static int[] sort(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
