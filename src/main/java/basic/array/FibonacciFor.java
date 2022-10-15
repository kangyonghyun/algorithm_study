package basic.array;

import java.util.Scanner;

public class FibonacciFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i : getFibonacci(n)) {
            System.out.print(i + " ");
        }
    }

    private static int[] getFibonacci(int n) {
        int[] numbers = new int[n];
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < n; i++) {
            numbers[i] = numbers[i - 2] + numbers[i - 1];
        }
        return numbers;
    }

    private static int[] getFibonacci1(int n) {
        int[] numbers = new int[n];
        int a = 1;
        int b = 1;
        int c = 0;
        numbers[0] = a;
        numbers[1] = b;
        for (int i = 2; i < n; i++) {
            c = a + b;
            numbers[i] = c;
            a = b;
            b = c;
        }
        return numbers;
    }

}
