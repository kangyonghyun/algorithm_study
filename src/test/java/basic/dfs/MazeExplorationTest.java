package basic.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazeExplorationTest {

    @Test
    void solution() {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0}
        };
        Maze maze = new Maze(board);
        maze.exploration(1, 1);
        assertThat(maze.count).isEqualTo(8);
    }

    static class Maze {
        int[][] board;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count;

        public Maze(int[][] board) {
            this.board = board;
        }

        public void exploration(int x, int y) {
            if (x == 7 && y == 7) {
                this.count++;
            } else {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        exploration(nx, ny);
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }

}