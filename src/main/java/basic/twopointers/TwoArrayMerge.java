package basic.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoArrayMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        List<Integer> elements = getSortMerge(n, arr1, m, arr2);
        for (int element : elements) {
            System.out.print(element + " ");
        }
    }

    private static List<Integer> getSortMerge(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> elements = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                elements.add(arr1[p1++]);
            } else {
                elements.add(arr2[p2++]);
            }
        }

        while (p1 < n) {
            elements.add(arr1[p1++]);
        }
        while (p2 < m) {
            elements.add(arr2[p2++]);
        }

        return elements;
    }
}
