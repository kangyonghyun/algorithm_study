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

        assertThat(findNumberOfDoll(N, board, M, moves)).isEqualTo(4);
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