package basic.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersMoreThanBefore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : getNumbersMoreThanBefore(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> getNumbersMoreThanBefore(int n, int[] arr) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                numbers.add(arr[i]);
            }
        }
        return numbers;
    }
}
