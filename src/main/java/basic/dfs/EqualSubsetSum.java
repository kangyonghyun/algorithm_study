package basic.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SubsetSum subsetSum = new SubsetSum(arr);
        subsetSum.isEqualSubsetSum(0, 0);
        System.out.println(subsetSum.result);
    }

    static class SubsetSum {

        int[] subset;
        int total;
        String result;
        boolean flag;

        public SubsetSum(int[] subset) {
            this.subset = subset;
            this.total = Arrays.stream(subset).sum();
            this.result = "NO";
            this.flag = false;
        }

        public void isEqualSubsetSum(int L, int sum) {
            if (flag) {
                return;
            }
            if (L == subset.length) {
                if (total - sum == sum) {
                    this.flag = true;
                    this.result = "YES";
                }
            } else {
                isEqualSubsetSum(L + 1, sum + subset[L]);
                isEqualSubsetSum(L + 1, sum);
            }
        }
    }
}
