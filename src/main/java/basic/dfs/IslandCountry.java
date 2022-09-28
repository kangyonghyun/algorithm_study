package basic.dfs;

import java.util.Scanner;

public class IslandCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        Island island = new Island(n, board);
        System.out.println(island.getNumberOfIsland());
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
                        board[i][j] = 0;
                        count++;
                        findIsland(i, j);
                    }
                }
            }
            return count;
        }

        private void findIsland(int x, int y) {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    findIsland(nx, ny);
                }
            }
        }
    }
}
