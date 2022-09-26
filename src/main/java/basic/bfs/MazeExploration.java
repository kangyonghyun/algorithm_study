package basic.bfs;

import java.util.LinkedList;
import java.util.Queue;
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
        Maze maze = new Maze(board);
        System.out.println(maze.getShortestDistance(1, 1));
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Maze {
        int[][] board;
        int[][] dis = new int[8][8];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        public Maze(int[][] board) {
            this.board = board;
        }

        public int getShortestDistance(int x, int y) {
            Queue<Point> que = new LinkedList<>();
            que.offer(new Point(x, y));
            board[x][y] = 1;

            while (!que.isEmpty()) {
                Point cur = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        que.offer(new Point(nx, ny));
                        dis[nx][ny] = dis[cur.x][cur.y] + 1;
                    }
                }
            }
            if (dis[7][7] == 0) {
                return -1;
            }
            return dis[7][7];
        }
    }

}
