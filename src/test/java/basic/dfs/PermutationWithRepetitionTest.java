package basic.dfs;

import org.junit.jupiter.api.Test;

class PermutationWithRepetitionTest {

    @Test
    void solution1() {
        Permutation permutation = new Permutation(3, 2);
        permutation.printNumberOfCases(0);
    }

    static class Permutation {
        int n;
        int[] nums;

        public Permutation(int n, int m) {
            this.n = n;
            this.nums = new int[m];
        }

        private void printNumberOfCases(int L) {
            if (L == nums.length) {
                for (int num : nums) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                for (int i = 1; i <= n; i++) {
                    nums[L] = i;
                    printNumberOfCases(L + 1);
                }
            }
        }
    }

}