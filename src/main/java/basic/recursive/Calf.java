package basic.recursive;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calf calf = new Calf();
        System.out.println(calf.getShortestPathForFindCalf(sc.nextInt(), sc.nextInt()));
    }

    private int getShortestPathForFindCalf(int suPos, int calfPos) {
        int[] move = {1, -1, 5};
        int[] check = new int[10001];
        Queue<Integer> position = new LinkedList<>();
        position.add(suPos);
        int level = 0;
        while (!position.isEmpty()) {
            int size = position.size();
            for (int i = 0; i < size; i++) {
                int cur = position.poll();
                for (int j = 0; j < move.length; j++) {
                    int dis = cur + move[j];
                    if (dis == calfPos) {
                        return level + 1;
                    }
                    if (dis >= 1 && dis <= 10000 && check[dis] == 0) {
                        check[dis] = 1;
                        position.offer(dis);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
