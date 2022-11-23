package basic.bfs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class MazeExplorationTest {

    /**
     *  격자판에서 출발부터 도착까지 최단경로 구하기
     *  Que 에 처음 출발할 Point(격자판의 위치) 객체를 저장
     *  Que 가 완전히 빌때까지 반복문을 돌려준다.
     *  Que 에서 Point 를 꺼낸 후, 위치 값을 계산
     *  계산된 위치가 조건에 맞으면 (격자판이 0이고, 1-7 사이)
     *      1. 격자판에 다녀간 위치 표시 (1)
     *      2. Que 에 새로운 Point 저장
     *      3. 위치값을 저장할 2차원 배열에 +1 해줌
     *  반복문이 끝난 후 위치가 저장된 2차원 배열에 끝 지점이 최단 경로 길이
     */

    @Test
    void solution() {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        Maze maze = new Maze(board);
        assertThat(maze.getShortestDistance(0, 0)).isEqualTo(12);
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
        int[][] dis = new int[7][7];
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
                    if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        que.offer(new Point(nx, ny));
                        dis[nx][ny] = dis[cur.x][cur.y] + 1;
                    }
                }
            }
            if (dis[6][6] == 0) {
                return -1;
            }
            return dis[6][6];
        }
    }

    @Test
    void solution1() {
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
        Board bd = new Board(board);
        assertThat(bd.getShortestDistance(1, 1)).isEqualTo(12);
    }

    private class Board {
        private final int[][] board;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] dis = new int[8][8];

        public Board(int[][] board) {
            this.board = board;
        }

        public int getShortestDistance(int x, int y) {
            Queue<XYPoint> que = new LinkedList<>();
            que.offer(new XYPoint(x, y));

            while (!que.isEmpty()) {
                XYPoint point = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        que.offer(new XYPoint(nx, ny));
                        dis[nx][ny] = dis[point.x][point.y] + 1;
                    }
                }
            }
            if (dis[7][7] == 0) {
                return -1;
            }
            return dis[7][7];
        }
    }

    private class XYPoint {
        int x;
        int y;
        public XYPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}