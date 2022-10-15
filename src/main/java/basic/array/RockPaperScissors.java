package basic.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (char winner : getWinners(n, a, b)) {
            System.out.println(winner);
        }
    }

    private static List<Character> getWinners(int n, int[] a, int[] b) {
        List<Character> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int play = a[i] - b[i];
            if (play == -2 || play == 1) {
                results.add('A');
            } else if (play == -1 || play == 2) {
                results.add('B');
            } else {
                results.add('D');
            }
        }
        return results;
    }
}
