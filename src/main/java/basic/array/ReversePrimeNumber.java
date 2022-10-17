package basic.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int reversePrimeNumber : getReversePrimeNumbers(n, arr)) {
            System.out.print(reversePrimeNumber + " ");
        }
    }

    private static List<Integer> getReversePrimeNumbers(int n, int[] arr) {
        List<Integer> reversePrimeNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int reverseNumber = reverse(arr[i]);
            if (isPrimeNumber(reverseNumber)) {
                reversePrimeNumbers.add(reverseNumber);
            }
        }
        return reversePrimeNumbers;
    }

    private static int reverse(int number) {
        int reverseNumber = 0;
        while (number > 0) {
            int temp = number % 10;
            reverseNumber = reverseNumber * 10 + temp;
            number = number / 10;
        }
        return reverseNumber;
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
