package basic.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BrickBuildUpTest {

    /**
     * 동적 계획법
     * 면적을 기준으로 오름차순 정렬
     * dp[] 배열에 최대 높이 저장
     * 밑에 벽돌과 위에 벽돌 무게를 비교하여 위에 벽돌이 무게가 작을 경우 dp[] 배열과 비교하여 최대 높이를 저장
     * dp[] 배열에 최대 높이(max) 와 현재 벽돌의 높이를 더해서 dp[] 배열에 저장
     * 최대 높이 산출 (result)
     * 바깥 for 문은 2번째 벽돌부터 끝 벽똘까지, 안쪽 for 문은 i - 1 벽돌부터 첫번째 벽똘까지 비교
     */

    @Test
    void build() {
        int n = 5;
        List<Brick> bricks = new ArrayList<>();
        bricks.add(new Brick(25, 3, 4));
        bricks.add(new Brick(4, 4, 6));
        bricks.add(new Brick(9, 2, 3));
        bricks.add(new Brick(16, 2, 5));
        bricks.add(new Brick(1, 5, 2));
        assertThat(getMaxHeight(bricks)).isEqualTo(10);
    }

    private int getMaxHeight(List<Brick> bricks) {
        bricks.sort((o1, o2) -> o2.area - o1.area);
        int[] dp = new int[bricks.size()];
        dp[0] = bricks.get(0).height;
        int result = bricks.get(0).height;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(j).weight > bricks.get(i).weight && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + bricks.get(i).height;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    static class Brick {
        int area;
        int height;
        int weight;

        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }


}