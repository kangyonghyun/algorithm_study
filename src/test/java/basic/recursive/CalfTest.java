package basic.recursive;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class CalfTest {
    @Test
    void findCalfTest() {
        int suPos = 5;
        int calfPos = 14;
        assertThat(getShortestPathForFindCalf(suPos, calfPos)).isEqualTo(3);
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