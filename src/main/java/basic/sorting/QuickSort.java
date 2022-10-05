package basic.sorting;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sort = sort(arr);
        for (int i : sort) {
            System.out.print(i + " ");
        }
    }

    private static int[] sort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(arr, left, right);
        swap(arr, pivotPos, right);
        quickSortRecursive(arr, left, pivotPos - 1);
        quickSortRecursive(arr, pivotPos + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int idx = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, idx, i);
                idx++;
            }
        }
        int pivotPos = idx;
        return pivotPos;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
