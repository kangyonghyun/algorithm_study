package basic.array;

import java.util.Scanner;

public class BoardMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaxSum(n, board));
    }

    private static int getMaxSum(int n, int[][] board) {
        int rowMax = 0;
        int columnMax = 0;
        int diagonalMax = 0;
        int ldMax = 0;
        int rdMax = 0;
        for (int i = 0; i < n; i++) {
            int rMax = 0;
            int cMax = 0;
            for (int j = 0; j < n; j++) {
                rMax += board[i][j];
                cMax += board[j][i];
            }
            rowMax = Math.max(rowMax, rMax);
            columnMax = Math.max(columnMax, cMax);
            ldMax += board[i][i];
            rdMax += board[i][n - 1 - i];
        }
        diagonalMax = Math.max(ldMax, rdMax);
        return Math.max(Math.max(rowMax, columnMax), diagonalMax);
    }
}
