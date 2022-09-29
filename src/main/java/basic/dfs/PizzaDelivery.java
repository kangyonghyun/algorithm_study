package basic.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDelivery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        ShortDelivery shortDelivery = new ShortDelivery(n, m, board);
        shortDelivery.findDeliveryShortestDistance(0, 0);
        System.out.println(shortDelivery.shortDistance);
    }

    static class ShortDelivery {
        int n;
        int m;
        int[][] board;
        int shortDistance = Integer.MAX_VALUE;
        int[] combination;
        List<Position> stores = new ArrayList<>();
        List<Position> homes = new ArrayList<>();

        public ShortDelivery(int n, int m, int[][] board) {
            this.n = n;
            this.m = m;
            this.board = board;
            this.combination = new int[m];
            setPosition(n, board);
        }

        private void setPosition(int n, int[][] board) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        homes.add(new Position(i, j));
                    } else if (board[i][j] == 2) {
                        stores.add(new Position(i, j));
                    }
                }
            }
        }

        public void findDeliveryShortestDistance(int L, int S) {
            if (L == m) {
                int sum = 0;
                for (Position home : homes) {
                    int dis = Integer.MAX_VALUE;
                    for (int c : combination) {
                        Position store = stores.get(c);
                        dis = Math.min(dis, Math.abs(store.x - home.x) + Math.abs(store.y - home.y));
                    }
                    sum += dis;
                }
                shortDistance = Math.min(shortDistance, sum);
            } else {
                for (int i = S; i < stores.size(); i++) {
                    combination[L] = i;
                    findDeliveryShortestDistance(L + 1, i + 1);
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
