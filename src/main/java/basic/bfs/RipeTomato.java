package basic.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RipeTomato {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] box = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        TomatoBox tBox = new TomatoBox(m, n, box);
        System.out.println(tBox.getMinDateForRipeTomatoes());
    }

    static class TomatoBox {
        int m;
        int n;
        int[][] box;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dates;

        public TomatoBox(int m, int n, int[][] box) {
            this.m = m;
            this.n = n;
            this.box = box;
            this.dates = new int[n][m];
        }

        public int getMinDateForRipeTomatoes() {
            Queue<Tomato> que = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 1) {
                        que.offer(new Tomato(i, j));
                    }
                }
            }

            while (!que.isEmpty()) {
                Tomato ripeTomato = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = ripeTomato.x + dx[i];
                    int ny = ripeTomato.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        que.offer(new Tomato(nx, ny));
                        dates[nx][ny] = dates[ripeTomato.x][ripeTomato.y] + 1;
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 0) {
                        return -1;
                    }
                    max = Math.max(max, dates[i][j]);
                }
            }
            return max;
        }
    }

    static class Tomato {
        int x;
        int y;
        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
