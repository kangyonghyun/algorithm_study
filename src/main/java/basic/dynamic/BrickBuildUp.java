package basic.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrickBuildUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bricks.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        System.out.println(getMaxHeight(bricks));
    }

    private static int getMaxHeight(List<Brick> bricks) {
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
