package basic.dfs;

import java.util.Scanner;

public class MazeExploration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[8][8];
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1;
        Maze maze = new Maze(board);
        maze.exploration(1, 1);
        System.out.println(maze.count);
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
