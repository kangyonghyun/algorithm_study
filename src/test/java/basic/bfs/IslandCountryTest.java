package basic.bfs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class IslandCountryTest {

    @Test
    void solution() {
        int n = 7;
        int[][] board = new int[][]{
                {1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}
        };
        Island island = new Island(n, board);
        assertThat(island.getNumberOfIsland()).isEqualTo(5);
    }

    static class Island {
        int n;
        int[][] board;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        public Island(int n, int[][] board) {
            this.n = n;
            this.board = board;
        }

        public int getNumberOfIsland() {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        count++;
                        board[i][j] = 0;
                        findIsland(i, j);
                    }
                }
            }
            return count;
        }

        private void findIsland(int x, int y) {
            Queue<Position> que = new LinkedList<>();
            que.offer(new Position(x, y));

            while (!que.isEmpty()) {
                Position curIsland = que.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = curIsland.x + dx[i];
                    int ny = curIsland.y + dy[i];
                    if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        que.offer(new Position(nx, ny));
                    }
                }
            }
        }
    }

    static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}