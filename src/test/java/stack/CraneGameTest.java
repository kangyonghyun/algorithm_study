package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CraneGameTest {
    @Test
    void draw() {
        int N = 5;
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int M = 8;
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        assertThat(executeCraneGame(N, board, moves)).isEqualTo(4);
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