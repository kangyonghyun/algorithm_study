package basic.dfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class EqualSubsetSumTest {

    @Test
    void solution() {
        int n = 6;
        int[] arr = {1, 3, 5, 6, 7, 10};

        isEqualSubsetSum(0, 0, arr);
        assertThat(result).isEqualTo("YES");
    }
    boolean flag;
    String result;
    int total = 32;
    private void isEqualSubsetSum(int L, int sum, int[] arr) {
        if (flag) {
            return;
        }
        if (L == 6) {
            if (total - sum == sum) {
                result = "YES";
                flag = true;
            }
        } else {
            isEqualSubsetSum(L + 1, sum + arr[L], arr);
            isEqualSubsetSum(L + 1, sum, arr);
        }
    }

    @Test
    void solution1() {
        SubsetSum subsetSum = new SubsetSum(new int[]{1, 3, 5, 6, 7, 10});
        subsetSum.isEqualSubsetSum(0, 0);
        assertThat(subsetSum.result).isEqualTo("YES");
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