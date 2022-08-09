package basic.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Fibonacci fibonacci = new Fibonacci();

        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci.calculateRecursive(i) + " ");
        }

        System.out.println();

        List<Integer> results = fibonacci.calculateList(n);
        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }

    private int calculateRecursive(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return calculateRecursive(i - 2) + calculateRecursive(i - 1);
        }
    }

    private List<Integer> calculateList(int n) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                results.add(1);
            } else {
                results.add(results.get(i - 2) + results.get(i - 1));
            }
        }
        return results;
    }
}
