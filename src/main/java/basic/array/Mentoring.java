package basic.array;

import java.util.Scanner;

public class Mentoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] test = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                test[i][j] = sc.nextInt();
            }
        }
        System.out.println(getNumberOfCase(n, m, test));
    }

    private static int getNumberOfCase(int students, int tests, int[][] results) {
        int numberOfCase = 0;
        for (int i = 1; i <= students; i++) {
            for (int j = 1; j <= students; j++) {
                int count = 0;
                for (int k = 0; k < tests; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int l = 0; l < students; l++) {
                        if (results[k][l] == i) {
                            pi = l;
                        }
                        if (results[k][l] == j) {
                            pj = l;
                        }
                    }
                    if (pi < pj) {
                        count++;
                    }
                }
                if (count == tests) {
                    numberOfCase++;
                }
            }
        }
        return numberOfCase;
    }
}
