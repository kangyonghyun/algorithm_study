package stack;

import java.util.Scanner;
import java.util.Stack;

public class CraneGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int M = sc.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = sc.nextInt();
        }
        CraneGame craneGame = new CraneGame();
        System.out.println(craneGame.findNumberOfDoll(N, board, M, moves));
    }

    private int findNumberOfDoll(int N, int[][] board, int M, int[] moves) {
        Stack<Integer> dolls = new Stack<>();
        dolls.push(0);
        int count = 0;
        for (int move : moves) {
            for (int i = 0; i < N; i++) {
                if (board[i][move - 1] == 0) {
                    continue;
                }
                if (dolls.peek() != board[i][move - 1]) {
                    dolls.push(board[i][move - 1]);
                } else {
                    if (!dolls.isEmpty()) {
                        dolls.pop();
                        count++;
                    }
                }
                board[i][move - 1] = 0;
                break;
            }
        }
        return count * 2;
    }

}
