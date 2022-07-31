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
        System.out.println(craneGame.executeCraneGame(N, board, moves));
    }

    private int executeCraneGame(int N, int[][] board, int[] moves) {
        Stack<Integer> dolls = new Stack<>();
        int count = 0;
        for (int move : moves) {
            for (int i = 0; i < N; i++) {
                int doll = board[i][move - 1];
                drawDoll(move, board[i]);
                if (doll != 0) {
                    count = getCountOfDisappearedDoll(dolls, count, doll);
                    break;
                }
            }
        }
        return count * 2;
    }

    private void drawDoll(int move, int[] board) {
        board[move - 1] = 0;
    }

    private int getCountOfDisappearedDoll(Stack<Integer> dolls, int count, int doll) {
        if (!dolls.isEmpty() && doll == dolls.peek()) {
            dolls.pop();
            count++;
        } else {
            dolls.push(doll);
        }
        return count;
    }

}
