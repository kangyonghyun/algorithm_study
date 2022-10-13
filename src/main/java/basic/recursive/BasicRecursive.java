package basic.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int result : getAllNumbersWithRecursive(sc.nextInt())) {
            System.out.print(result + " ");
        }
    }

    public static List<Integer> getAllNumbersWithRecursive(int n) {
        List<Integer> results = new ArrayList<>();
        recursive(n, results);
        return results;
    }

    private static void recursive(int n, List<Integer> results) {
        if (n == 0) {
            return;
        }
        recursive(n - 1, results);
        results.add(n);
    }
}
