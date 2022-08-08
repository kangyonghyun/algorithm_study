package basic.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BasicRecursive function = new BasicRecursive();

        for (int result : function.solution(sc.nextInt())) {
            System.out.print(result + " ");
        }
    }

    public List<Integer> solution(int n) {
        List<Integer> results = new ArrayList<>();
        recursiveFunction(n, results);
        return results;
    }

    private void recursiveFunction(int n, List<Integer> results) {
        if (n > 0) {
            recursiveFunction(n - 1, results);
            results.add(n);
        }
    }
}
