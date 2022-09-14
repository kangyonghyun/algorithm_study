package basic.dfs;

import java.util.Scanner;

public class BadugiRide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Badugis badugis = new Badugis(c, arr);
        badugis.getMaxWeightRide(0, 0);
        System.out.println(badugis.total);
    }

    static class Badugis {
        int maxWeight;
        int[] badugis;

        int total;
        boolean flag;

        public Badugis(int maxWeight, int[] badugis) {
            this.maxWeight = maxWeight;
            this.badugis = badugis;
            this.total = Integer.MIN_VALUE;
        }

        public void getMaxWeightRide(int L, int sum) {
            if (this.maxWeight < sum) {
                return;
            }
            if (L == this.badugis.length) {
                this.total = Math.max(this.total, sum);
            } else {
                getMaxWeightRide(L + 1, sum + this.badugis[L]);
                getMaxWeightRide(L + 1, sum);
            }
        }
    }
}
