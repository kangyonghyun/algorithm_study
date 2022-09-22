package basic.dfs;

import org.junit.jupiter.api.Test;

class PermutationWithNoRepetitionTest {
    @Test
    void solution1() {
        Permutation permutation = new Permutation(new int[]{3,6,9}, 2);
        permutation.printCombination(0);
    }

    static class Permutation {
        int[] nums;
        int[] comination;
        int[] check;

        public Permutation(int[] nums, int m) {
            this.nums = nums;
            this.comination = new int[m];
            this.check = new int[nums.length];
        }

        public void printCombination(int L) {
            if (L == comination.length) {
                for (int c : comination) {
                    System.out.print(c + " ");
                }
                System.out.println();
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (check[i] == 0) {
                        check[i] = 1;
                        comination[L] = nums[i];
                        printCombination(L + 1);
                        check[i] = 0;
                    }
                }
            }
        }
    }

}