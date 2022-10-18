package basic.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardMaxSumTest {

    @Test
    void solution() {
        int n = 5;
        int[][] board = {
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}
        };
        assertThat(getMaxSum(n, board)).isEqualTo(155);
    }

    private int getMaxSum(int n, int[][] board) {
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